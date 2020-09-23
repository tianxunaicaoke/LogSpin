package org.logSpin.plugin;

import groovy.lang.Closure;
import org.logSpin.Info;
import org.logSpin.core.ConfigureUtil;
import org.logSpin.core.NameDomainContainer;

public class InfoContainer extends NameDomainContainer<Info> {

    @Override
    public Info create(String name, Object[] params) {
        Info info = new Info.Builder()
                .name(name)
                .build();
        add(info);
        if (params[0] instanceof Closure) {
            ConfigureUtil.configureByObject((Closure<?>) params[0], info);
        }
        return info;
    }
}
