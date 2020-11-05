package org.logSpin.dynamicJar;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarFile;

public class DynamicLoadJar {
    private final String[] paths;
    private final Method addURL;
    private final List<JarFile> jarFiles;
    private final URLClassLoader classloader;

    {
        try {
            classloader = (URLClassLoader) Thread.currentThread().getContextClassLoader();
            addURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            addURL.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<JarFile> getJarFiles() {
        return jarFiles;
    }

    public DynamicLoadJar(String[] paths) {
        this.paths = paths;
        jarFiles = new ArrayList<>();
    }

    public void loadClass() {
        Arrays.stream(paths).forEach(path -> {
            File file = new File(path);
            loopDirs(file);
        });
    }

    private void loopDirs(File file) {
        if (file.isDirectory()) {
            File[] temps = file.listFiles();
            assert temps != null;
            Arrays.stream(temps).forEach(this::loopDirs);
        } else if (file.getName().endsWith("jar")) {
            addURL(file);
        }
    }

    private void addURL(File file) {
        try {
            addURL.invoke(classloader, file.toURI().toURL());
            jarFiles.add(new JarFile(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
