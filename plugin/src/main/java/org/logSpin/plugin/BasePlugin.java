package org.logSpin.plugin;

import groovy.lang.Closure;
import org.logSpin.*;

import org.logSpin.core.ConfigureUtil;
import org.logSpin.spinCase.InfoCase;
import org.logSpin.spinCase.RuleCase;
import org.logSpin.util.SpinLogLog;

import java.util.Iterator;
import java.util.List;

import static org.logSpin.spinCase.DefaultCase.CaseState.Configured;
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
                .caseState(Configured)
                .build();
        infoList.forEach(info -> {
            SpinLogLog.log(info.toString());
            infoCase.addInfo(info);
        });
        spin.getConfiguredCase().add(infoCase);
    }

    public void rule(Closure<?> closure) {
        Rule newRule = new Rule();
        ConfigureUtil.configureByObject(closure, newRule);
        RuleCase ruleCase = new RuleCase.Builder()
                .caseState(Configured)
                .build();
    }

    public void when() {

    }

    public void logSet(Closure<?> closure) {
        ConfigureUtil.configureByObject(closure, logSet);
        SpinLogLog.log(" logSet  " + logSet.toString());
        spin.getLogProcess().setLogSet(logSet);
    }

    public void flow(Closure<?> closure) {
        flowContainer.configure(closure, flowContainer);
    }

    @Override
    public void resolveCase(T spin) {
        Iterator<SpinCase> iterator = spin.getConfiguredCase().iterator();
        resolveInfoCase(iterator);
    }

    private void resolveRuleCase() {

    }

    private void resolveInfoCase(Iterator<SpinCase> iterator) {
        InfoCase infoCase = new InfoCase.Builder()
                .caseState(Resolved)
                .build();
        while (iterator.hasNext()) {
            SpinCase spinCase = iterator.next();
            if (spinCase instanceof InfoCase) {
                infoCase.merge((InfoCase) spinCase);
                iterator.remove();
            }
        }
        spin.getResolvedCases().add(infoCase);
    }
}
