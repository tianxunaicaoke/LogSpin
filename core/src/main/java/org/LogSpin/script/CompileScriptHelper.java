package org.LogSpin.script;

import groovy.lang.GroovyClassLoader;
import org.codehaus.groovy.control.CompilerConfiguration;

public class CompileScriptHelper {
    public Class<?> compileScript(String scriptSource, String scriptName) {
        CompilerConfiguration configuration = new CompilerConfiguration();
        configuration.setScriptBaseClass(BaseScript.class.getName());
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(this.getClass().getClassLoader(), configuration, false);
        return groovyClassLoader.parseClass(scriptSource, scriptName);
    }
}
