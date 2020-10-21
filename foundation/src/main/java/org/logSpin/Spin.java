package org.logSpin;


import java.util.List;

/**
 * This interface represent the once log analysis carrier
 */
public interface Spin {
    void configure(String[] arg);
    void analyse();
    void addPreAnalyseCase(SpinCase spinCase);
    PluginContainer<Plugin<Spin>> getPluginContainer();
    PluginManager<Spin> getPluginManager();
    SpinProcess getProcess();
    List<SpinCase> getResolvedCases();
    List<SpinCase> getConfiguredCase();
    LogVariantManager getLogVariantManager();
}
