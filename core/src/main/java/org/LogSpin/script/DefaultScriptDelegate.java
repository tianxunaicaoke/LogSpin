package org.LogSpin.script;

import org.LogSpin.Plugin;
import org.LogSpin.Spin;
import org.LogSpin.core.AbstractDynamicObject;

public class DefaultScriptDelegate extends AbstractDynamicObject implements ScriptDelegate {
    Spin spin;

    public void setSpin(Spin spin){
        this.spin = spin;
    }

    @Override
    public void apply(String pluginId) {
      Plugin plugin = spin.getPluginManager().getPluginById(pluginId);
      plugin.apply(spin);
      spin.getPluginContainer().addPlugin(plugin);
    }

    @Override
    public Object invokeMethod(String name, Object[] args) {
        for (Plugin plugin: spin.getPluginContainer().getPlugins()) {
           tryInvokeMethod(plugin,name,args);
        }
        return null;
    }
}
