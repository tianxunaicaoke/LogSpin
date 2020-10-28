package org.logSpin.Exception;

public class NoPluginFoundException extends RuntimeException{
    private final String pluginId;

    public NoPluginFoundException(String pluginId) {
        this.pluginId = pluginId;
    }

    @Override
    public String toString() {
        return "NoPluginFoundException{" +
                "pluginId='" + pluginId + '\'' +
                '}';
    }
}
