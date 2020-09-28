package org.logSpin;


import java.util.List;

/**
 * This interface represent the once log analysis carrier
 */
public interface Spin {
    void configure(String[] arg);
    void analyse();
    PluginContainer<Plugin<Spin>> getPluginContainer();
    PluginManager getPluginManager();
    LogProcess getLogProcess();
    List<SpinCase> getResolvedCases();
    List<SpinCase> getConfiguredCase();
}
