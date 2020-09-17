package org.LogSpin.plugin;

import java.util.ArrayList;
import java.util.List;

public class PluginRegister {
   List<PluginId> pluginIdList = new ArrayList<>();
   
   public void register(String id, Class<?> clazz){
       pluginIdList.add(new PluginId(id,clazz));
   }

    public PluginId getPlugin(String PluginId) {
        return pluginIdList.stream()
                .filter((id) -> id.id.equals(PluginId))
                .findFirst()
                .get();
    }
}
