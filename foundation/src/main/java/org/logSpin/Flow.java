package org.logSpin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Flow {

    private String name;
    private final List<String> keys = new ArrayList<>();
    private final List<String> flowValue = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<String> getKeys() {
        return keys;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addKey(String key) {
        keys.add(key);
    }

    public void addFlowValue(String value) {
        flowValue.add(value);
    }

    public void reset(){
        flowValue.clear();
    }

    public void key(String... keys){
        this.keys.addAll(Arrays.asList(keys));
    }
}
