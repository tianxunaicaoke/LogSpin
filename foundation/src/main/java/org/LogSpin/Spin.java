package org.LogSpin;


/**
 * This interface represent the once log analysis carrier
 */
public interface Spin {
    void configure(String[] arg);
    void analyse();
    PluginContainer<Plugin> getPluginContainer();
    PluginManager getPluginManager();
}
