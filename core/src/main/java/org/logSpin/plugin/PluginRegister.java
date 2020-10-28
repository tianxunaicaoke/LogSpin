package org.logSpin.plugin;

import org.logSpin.Plugin;
import org.logSpin.Spin;
import sun.misc.URLClassPath;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class PluginRegister {
    private final List<PluginId> pluginIdList = new ArrayList<>();
    private final List<Class<?>> classes = new ArrayList<>();

    public void register(String id, Class<? extends Plugin<Spin>> clazz) {
        pluginIdList.add(new PluginId(id, clazz));
    }

    public PluginId getPlugin(String PluginId) {
        PluginId pluginId = pluginIdList.stream()
                .filter((id) -> id.getId().equals(PluginId))
                .findFirst()
                .orElse(null);

        if (pluginId == null) {
            pluginId = tryGetPluginFromDependence(PluginId);
        }
        return pluginId;
    }

    private PluginId tryGetPluginFromDependence(String id) {
        try {
            Field ucpfield = URLClassLoader.class.getDeclaredField("ucp");
            ucpfield.setAccessible(true);
            URLClassPath classPath = (URLClassPath) ucpfield.get(ClassLoader.getSystemClassLoader());

            Field pathField = URLClassPath.class.getDeclaredField("path");
            pathField.setAccessible(true);
            ArrayList<URL> path = (ArrayList<URL>) pathField.get(classPath);
            
            List<PluginId> list = new ArrayList<>();
            path.stream().filter(p -> p.getPath().contains("jar")).forEach(
                    p -> {
                        File file = new File(p.getPath());
                        try {
                            JarFile jarFile = new JarFile(file);
                            PluginId pluginId = fillPluginInfo(id,jarFile);
                            if(pluginId!=null){
                                list.add(pluginId);
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );
            return list.stream().findFirst().orElse(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private PluginId fillPluginInfo(String id, JarFile jarFile) {
        try {
            Manifest manifest = jarFile.getManifest();
            Attributes attributes = manifest.getMainAttributes();
            String className = attributes.getValue("Plugin-Class");
            String pluginName = attributes.getValue("Plugin-Name");
            if (id.equals(pluginName)) {
                Class<? extends Plugin<Spin>> pluginClass = (Class<? extends Plugin<Spin>>) Class.forName(className);
                return new PluginId(pluginName, pluginClass);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
