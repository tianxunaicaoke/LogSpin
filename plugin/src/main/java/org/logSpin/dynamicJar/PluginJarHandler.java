package org.logSpin.dynamicJar;

import org.logSpin.Plugin;
import org.logSpin.Spin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class PluginJarHandler {
    private static final String PLUGIN_URL = "/ExternalPlugin/";
    private final DynamicLoadJar dynamicLoadJar;
    private final HashMap<String, Class<? extends Plugin<Spin>>> ExternalPlugins;

    public PluginJarHandler() {
        dynamicLoadJar = new DynamicLoadJar(new String[]{System.getProperty("user.dir") + PLUGIN_URL});
        ExternalPlugins = new HashMap<>();
    }

    public HashMap<String, Class<? extends Plugin<Spin>>> getThePluginUnderFolder() {
        dynamicLoadJar.loadClass();
        List<JarFile> jarFiles = dynamicLoadJar.getJarFiles();
        jarFiles.forEach(this::fillPluginInfo);
        return ExternalPlugins;
    }

    @SuppressWarnings("unchecked")
    private void fillPluginInfo(JarFile jarFile) {
        try {
            Manifest manifest = jarFile.getManifest();
            Attributes attributes = manifest.getMainAttributes();
            String className = attributes.getValue("Plugin-Class");
            String pluginName = attributes.getValue("Plugin-Name");
            Class<? extends Plugin<Spin>> pluginClass = (Class<? extends Plugin<Spin>>) Class.forName(className);
            ExternalPlugins.put(pluginName, pluginClass);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
