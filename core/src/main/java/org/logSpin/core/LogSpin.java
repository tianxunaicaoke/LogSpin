package org.logSpin.core;

import org.logSpin.*;
import org.logSpin.plugin.DefaultPluginManager;
import org.logSpin.script.ScriptRunner;

import java.util.ArrayList;
import java.util.List;

public class LogSpin implements Spin {

    private final ScriptRunner scriptRunner;
    private final PluginManager<Spin> pluginManager;
    private final List<SpinCase> resolvedCase;
    private final List<SpinCase> configuredCase;
    private final LogProcess logProcess;
    private final LogVariantManager logVariantManager;

    public LogSpin(PluginContainer<Plugin<Spin>> pluginContainer, ScriptRunner scriptRunner, LogProcess logProcess) {
        this.scriptRunner = scriptRunner;
        this.pluginManager = new DefaultPluginManager(pluginContainer);
        this.logProcess = logProcess;
        this.resolvedCase = new ArrayList<>();
        this.configuredCase = new ArrayList<>();
        this.logVariantManager = new DefaultLogSpinManager();
    }

    @Override
    public void configure(String[] arg) {
        scriptRunner.runScriptToConfigSpin(arg);
        resolveCase();
    }

    private void resolveCase() {
        getPluginContainer()
                .getPlugins()
                .values()
                .forEach(
                        plugin ->
                                plugin.resolveCase(this)
                );
        applyLogScope();
        analyse();
    }

    private void applyLogScope() {
        if (logVariantManager.getVariant().isEmpty()) {
            resolvedCase.forEach(spinCase ->
                    spinCase.addVariants(logVariantManager.getVariant()));
        }
    }

    @Override
    public void analyse() {
        getResolvedCases().forEach(spinCase ->
                spinCase.action(getLogProcess())
        );
    }

    @Override
    public PluginContainer<Plugin<Spin>> getPluginContainer() {
        return pluginManager.getPluginContainer();
    }

    @Override
    public PluginManager<Spin> getPluginManager() {
        return pluginManager;
    }

    @Override
    public LogProcess getLogProcess() {
        return logProcess;
    }

    @Override
    public List<SpinCase> getResolvedCases() {
        return resolvedCase;
    }

    @Override
    public List<SpinCase> getConfiguredCase() {
        return configuredCase;
    }

    @Override
    public LogVariantManager getLogVariantManager() {
        return logVariantManager;
    }
}
