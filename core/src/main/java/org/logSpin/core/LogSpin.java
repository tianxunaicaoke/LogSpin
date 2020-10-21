package org.logSpin.core;

import org.logSpin.*;
import org.logSpin.plugin.DefaultPluginManager;
import org.logSpin.script.ScriptRunner;

import java.util.ArrayList;
import java.util.List;

public class LogSpin implements Spin {

    private final ScriptRunner scriptRunner;
    private final PluginManager<Spin> pluginManager;
    private final List<SpinCase> preActionCases;
    private final List<SpinCase> resolvedCase;
    private final List<SpinCase> configuredCase;
    private final SpinProcess spinProcess;
    private final LogVariantManager logVariantManager;

    public LogSpin(PluginContainer<Plugin<Spin>> pluginContainer, ScriptRunner scriptRunner, SpinProcess spinProcess) {
        this.scriptRunner = scriptRunner;
        this.spinProcess = spinProcess;
        this.pluginManager = new DefaultPluginManager(pluginContainer);
        this.resolvedCase = new ArrayList<>();
        this.configuredCase = new ArrayList<>();
        this.logVariantManager = new DefaultLogSpinManager();
        this.preActionCases = new ArrayList<>();
    }

    @Override
    public void configure(String[] arg) {
        applyPrePlugin();
        scriptRunner.runScriptToConfigSpin(arg);
        resolveCase();
    }

    private void applyPrePlugin() {
        pluginManager.addPlugin("BasePlugin");
        pluginManager.getPluginContainer()
                .getPlugins()
                .values()
                .forEach(spinPlugin ->
                        spinPlugin.apply(this));
    }

    private void resolveCase() {
        getPluginContainer()
                .getPlugins()
                .values()
                .forEach(
                        plugin ->
                                plugin.resolveCase(this)
                );
        perAnalyse();
    }

    private void perAnalyse() {
        preActionCases.forEach(spinCase ->
                spinCase.action(spinProcess));
        logVariantManager.applyVariant(resolvedCase);
        analyse();
    }

    @Override
    public void analyse() {
        resolvedCase.forEach(spinCase ->
                spinCase.action(spinProcess)
        );
    }

    @Override
    public void addPreAnalyseCase(SpinCase preActionCase) {
        preActionCases.add(preActionCase);
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
    public SpinProcess getProcess() {
        return spinProcess;
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
