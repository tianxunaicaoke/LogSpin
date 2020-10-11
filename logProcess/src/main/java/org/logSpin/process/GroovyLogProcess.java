package org.logSpin.process;

import groovy.lang.*;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import org.logSpin.core.DefaultLogProcess;

import java.io.IOException;
import java.util.List;


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

    @SuppressWarnings("unchecked")
    private Object invoke(String name, Object... params) {
        Binding binding = new Binding();
        try {
            List<Object> helper = (List<Object>) groovyScriptEngine.run("FileHelper.groovy", binding);
            for (Object object : helper) {
                GroovyObject groovyObject = (GroovyObject) object;
                if (tryInvokeMethod(groovyObject, name, params) != null) {
                    break;
                }
            }
        } catch (ResourceException | ScriptException e) {
            e.printStackTrace();
        }
        return null;
    }
}
