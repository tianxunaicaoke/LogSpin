package org.logSpin.plugin;

import org.logSpin.Plugin;
import org.logSpin.Spin;

import java.util.HashMap;

public interface PluginHandler {
    HashMap<String, Class<? extends Plugin<Spin>>> getPlugins();
}
