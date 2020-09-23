package org.logSpin.plugin;

import java.util.ArrayList;
import java.util.List;

public class PluginRegister {
    private final List<PluginId> pluginIdList = new ArrayList<>();

    public void register(String id, Class<?> clazz) {
        pluginIdList.add(new PluginId(id, clazz));
    }

    public PluginId getPlugin(String PluginId) {
        return pluginIdList.stream()
                .filter((id) -> id.getId().equals(PluginId))
                .findFirst()
                .get();
    }
}