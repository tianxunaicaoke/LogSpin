package org.logSpin.process;

import groovy.lang.Binding;
import groovy.lang.GroovyObject;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import org.logSpin.core.DefaultLogProcess;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class GroovyLogProcess extends DefaultLogProcess {

    private GroovyScriptEngine groovyScriptEngine;

    public GroovyLogProcess() {
        try {
            groovyScriptEngine = new GroovyScriptEngine("D:\\Code\\MyGitCode\\LogSpin\\logProcess\\src\\main\\groovy\\org\\logSpin\\process\\");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String[] match(String[] key) {
        invoke("search", new SearchBean(getLogSet().getLogPath(), new ArrayList(Arrays.asList(key))));
        return null;
    }

    @Override
    public Object invokeMethod(String name, Object... o) {
        invoke(name, o);
        return null;
    }

    private void invoke(String methodName, Object... params) {
        Binding binding = new Binding();
        try {
            GroovyObject groovyObject = (GroovyObject) groovyScriptEngine.run("FileSearchHelper.groovy", binding);
            groovyObject.invokeMethod(methodName, params);
        } catch (ResourceException | ScriptException e) {
            e.printStackTrace();
        }
    }
}
