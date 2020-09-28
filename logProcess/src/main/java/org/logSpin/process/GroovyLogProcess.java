package org.logSpin.process;

import groovy.lang.Binding;
import groovy.lang.GroovyObject;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import org.logSpin.core.DefaultLogProcess;

import java.io.IOException;


public class GroovyLogProcess extends DefaultLogProcess {

    private GroovyScriptEngine groovyScriptEngine;
    private static final String GROOVY_URL = "logProcess/src/main/groovy/org/logSpin/process/";

    public GroovyLogProcess() {
        try {
            groovyScriptEngine = new GroovyScriptEngine(GROOVY_URL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object invokeMethod(String name, Object... params) {
        return invoke(name, getLogSet().getLogPath(), params);
    }

    private Object invoke(String name, Object... params) {
        Binding binding = new Binding();
        try {
            GroovyObject groovyObject = (GroovyObject) groovyScriptEngine.run("FileSearchHelper.groovy", binding);
            groovyObject.invokeMethod(name, params);
        } catch (ResourceException | ScriptException e) {
            e.printStackTrace();
        }
        return null;
    }
}
