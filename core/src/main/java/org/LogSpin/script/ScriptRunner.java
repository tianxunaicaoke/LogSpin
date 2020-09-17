package org.LogSpin.script;

import groovy.lang.Binding;
import groovy.lang.Script;
import org.codehaus.groovy.runtime.InvokerHelper;

public class ScriptRunner {
    CompileScriptHelper compileScriptHelper;
    ScriptSourceReader scriptSourceReader;
    ScriptDelegate scriptDelegate;
    public ScriptRunner(CompileScriptHelper compileScriptHelper,
                        ScriptSourceReader scriptSourceReader,
                        ScriptDelegate scriptDelegate) {
        this.compileScriptHelper = compileScriptHelper;
        this.scriptSourceReader = scriptSourceReader;
        this.scriptDelegate = scriptDelegate;
    }

    public void runScriptToConfigSpin(String[] args) {
        for (String arg : args) {
            String source = null;
            if (!arg.isEmpty()) {
                source = getScriptSource(arg);
            }
            if (source != null)
                runScript(source);
        }
    }

    private void runScript(String source) {
        Binding binding = new Binding();
        Class<?> clazz = compileScriptHelper.compileScript(source, "Logspin");
        Script script = InvokerHelper.createScript(clazz, binding);
        ((BaseScript) script).init(scriptDelegate);
        script.run();
    }

    private String getScriptSource(String path) {
        return scriptSourceReader.getScriptSource(path);
    }
}
