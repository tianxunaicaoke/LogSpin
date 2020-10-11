package org.logSpin.script;

import groovy.lang.GroovyClassLoader;
import org.codehaus.groovy.control.CompilerConfiguration;

public class CompileScriptHelper {
    public Class<?> compileScript(String scriptSource, String scriptName) {
        CompilerConfiguration configuration = new CompilerConfiguration();
        configuration.setScriptBaseClass(BaseScript.class.getName());
        configuration.setTargetDirectory("D:\\Code\\MyGitCode\\LogSpin\\build\\classes\\java\\main\\org\\logSpin\\launch\\");
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(this.getClass().getClassLoader(), configuration, false);
        return groovyClassLoader.parseClass(scriptSource, scriptName);
    }
}
