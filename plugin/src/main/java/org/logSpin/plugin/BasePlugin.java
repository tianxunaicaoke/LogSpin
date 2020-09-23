package org.logSpin.plugin;

import groovy.lang.Closure;
import org.logSpin.Info;
import org.logSpin.LogSet;
import org.logSpin.Plugin;
import org.logSpin.Spin;

import org.logSpin.core.ConfigureUtil;
import org.logSpin.spinCase.InfoCase;
import org.logSpin.util.SpinLogLog;

import java.util.List;

import static org.logSpin.spinCase.DefaultCase.CaseState.Resolved;

@SuppressWarnings("unused")
public class BasePlugin<T extends Spin> implements Plugin<T> {
    private FlowContainer flowContainer;
    private InfoContainer infoContainer;
    private LogSet logSet;
    private Spin spin;

    @Override
    public void apply(Spin spin) {
        this.spin = spin;
        this.logSet = new LogSet();
        this.flowContainer = new FlowContainer();
        this.infoContainer = new InfoContainer();
        init();
    }

    private void init() {
        spin.getLogProcess().setLogSet(logSet);
        SpinLogLog.log(" logSet  " + logSet.toString());
    }

    public void info(Closure<?> closure) {
        infoContainer.configure(closure, infoContainer);
        List<Info> infoList = infoContainer.getList();
        InfoCase infoCase = new InfoCase.Builder()
                .caseState(Resolved)
                .build();
        for (Info info : infoList) {
            SpinLogLog.log(info.toString());
            infoCase.addInfo(info.getKey(), info.getDescription());
        }
        spin.getResolvedCases().add(infoCase);
    }

    public void logSet(Closure<?> closure) {
        ConfigureUtil.configureByObject(closure, logSet);
        SpinLogLog.log(" logSet  " + logSet.toString());
        spin.getLogProcess().setLogSet(logSet);
    }

    public void flow(Closure<?> closure) {
        flowContainer.configure(closure, flowContainer);
    }
}
