package org.LogSpin;

import groovy.lang.Closure;
import org.LogSpin.core.ConfigureUtil;
import org.LogSpin.core.NameDomainContainer;
import org.LogSpin.reflect.InstanceCreator;

public class InfoContainer extends NameDomainContainer<Info> {
    InstanceCreator instanceCreator;

    InfoContainer(InstanceCreator instanceCreator) {
        this.instanceCreator = instanceCreator;
    }

    @Override
    public Info create(String name, Object[] params) {
        Info info = instanceCreator.newInstance(Info.class, name);
        getList().add(info);
        if (params[0] instanceof Closure) {
            ConfigureUtil.configureByObject((Closure<?>) params[0],info);
        }
        return info;
    }
}
