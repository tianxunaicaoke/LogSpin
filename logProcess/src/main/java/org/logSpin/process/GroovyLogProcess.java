package org.logSpin.process;

import groovy.lang.GroovyObject;
import groovy.util.GroovyScriptEngine;
import org.logSpin.core.DefaultLogProcess;

import java.io.IOException;

public class GroovyLogProcess extends DefaultLogProcess {

    GroovyScriptEngine groovyScriptEngine;

    public GroovyLogProcess() {
        try {
            groovyScriptEngine = new GroovyScriptEngine("D:\\Code\\MyGitCode\\LogSpin\\logProcess\\src\\main\\groovy\\org\\logSpin\\process\\");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String[] match(String[] key) {
        Class<GroovyObject> searchHelper = groovyScriptEngine.getGroovyClassLoader().parseClass("FileSearchHelper.groovy");
        try {
            GroovyObject groovyObject = searchHelper.newInstance();
            String[] params = new  String[key.length+1];
            System.arraycopy(key, 0, params, 0, key.length);
            params[key.length] = getLogSet().getLogPath()[0];
            groovyObject.invokeMethod("main", null);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
