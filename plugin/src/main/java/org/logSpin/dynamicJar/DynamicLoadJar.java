package org.logSpin.dynamicJar;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class DynamicLoadJar {
    private String[] paths;
    private Method addURL;

    {
        try {
            addURL = this.getClass().getClassLoader().getClass().getDeclaredMethod("addURL", new Class[]{URL.class});
            addURL.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private URLClassLoader classloader = (URLClassLoader) this.getClass().getClassLoader();

    public DynamicLoadJar(String[] paths) {
        this.paths = paths;
    }

    public void loadClass() {
        for (String s : paths) {
            File file = new File(s);
            loopDirs(file);
        }
    }

    private void loopDirs(File file) {
        if (file.isDirectory()) {
            addURL(file);
            File[] tmps = file.listFiles();
            for (File tmp : tmps) {
                loopDirs(tmp);
            }
        } else if (file.getName().endsWith("jar")) {
            addURL(file);
        }
    }

    private void addURL(File file) {
        try {
            addURL.invoke(classloader, file.toURI().toURL());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
