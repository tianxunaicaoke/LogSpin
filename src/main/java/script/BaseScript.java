package script;

import groovy.lang.Script;

public class BaseScript extends Script {

    public void init(){
    }

    public void apply(String s){
        System.out.println("apply: "+s);
    }

    @Override
    public Object run() {
        return null;
    }
}
