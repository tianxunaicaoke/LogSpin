package org.logSpin.process;

import groovy.lang.*;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import org.logSpin.core.DefaultLogProcess;

import java.io.IOException;
import java.util.List;


public class GroovyLogProcess extends DefaultLogProcess {

    private static final String GROOVY_URL = "/GroovyScript/";
    private List<Object> helper;

    @SuppressWarnings("unchecked")
    public GroovyLogProcess() {
        try {
            GroovyScriptEngine groovyScriptEngine = new GroovyScriptEngine(System.getProperty("user.dir") + GROOVY_URL);
            Binding binding = new Binding();
            helper = (List<Object>) groovyScriptEngine.run("FileHelper.groovy", binding);
        } catch (IOException | ResourceException | ScriptException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object invokeMethod(String name, Object... params) {
        return invoke(name, getLogSet().getLogPath(), params);
    }

    @Override
    public Object invokeMethod(String name, Object params) {
        return invoke(name, params);
    }

    private Object invoke(String name, Object... params) {
        for (Object object : helper) {
            GroovyObject groovyObject = (GroovyObject) object;
            Object result = tryInvokeMethod(groovyObject, name, params);
            if (result != null) {
                return result;
            }
        }
        return null;
    }
}
