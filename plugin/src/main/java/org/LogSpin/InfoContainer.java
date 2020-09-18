package org.LogSpin;

import org.LogSpin.core.NameDomainContainer;
import reflect.InstanceCreator;

public class InfoContainer extends NameDomainContainer<Info> {
    InstanceCreator instanceCreator;

    InfoContainer(InstanceCreator instanceCreator) {
        this.instanceCreator = instanceCreator;
    }

    @Override
    public Info create(String name) {
        Info info = instanceCreator.newInstance(Info.class, name);
        getList().add(info);
        return info;
    }
}
