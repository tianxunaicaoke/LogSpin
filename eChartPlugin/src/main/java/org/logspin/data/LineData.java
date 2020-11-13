package org.logspin.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LineData {
    private final HashMap<String, List<String>> data = new HashMap<>();

    public void putData(String key,String value){
        if(data.get(key)==null){
            ArrayList<String> list = new ArrayList<>();
            list.add(value);
            data.put(key,list);
        }else{
            data.get(key).add(value);
        }
    }

    public List<String> getData(String key){
        return data.get(key);
    }
}
