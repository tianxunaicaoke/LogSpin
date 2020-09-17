package org.LogSpin.script;

import groovy.lang.Script;

public abstract class BaseScript extends Script {

    public void init(){

    }

    public void apply(String s){
        System.out.println("apply: "+s);
        String[] ss = s.split(".");
    }
}
