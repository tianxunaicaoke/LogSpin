package org.logSpin.plugin;

import groovy.lang.Closure;
import org.logSpin.Flow;
import org.logSpin.core.ConfigureUtil;
import org.logSpin.core.NameDomainContainer;

public class FlowContainer extends NameDomainContainer<Flow> {

    @Override
    public Flow create(String name, Object[] args) {
        Flow flow = new Flow();
        flow.setName(name);
        add(flow);
        if (args[0] instanceof Closure) {
            ConfigureUtil.configureByObject((Closure<?>) args[0], flow);
        }
        return flow;
    }
}
