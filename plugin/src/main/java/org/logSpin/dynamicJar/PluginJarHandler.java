package org.logSpin.dynamicJar;

public class PluginJarHandler {
    private static final String PLUGIN_URL = "/Plugin/";
    private DynamicLoadJar dynamicLoadJar = new DynamicLoadJar(new String[]{System.getProperty("user.dir") + PLUGIN_URL});

    public PluginJarHandler(){
        dynamicLoadJar.loadClass();
    }

    public void loadThePluginUnderFolder(){

    }
}
