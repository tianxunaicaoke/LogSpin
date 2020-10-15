package org.logSpin.plugin;

import groovy.lang.Closure;
import org.logSpin.*;

import org.logSpin.core.ConfigureUtil;
import org.logSpin.spinCase.InfoCase;
import org.logSpin.Rule;
import org.logSpin.spinCase.RuleCase;
import org.logSpin.util.SpinLogLog;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.logSpin.spinCase.DefaultCase.CaseState.Configured;
import static org.logSpin.spinCase.DefaultCase.CaseState.Resolved;

@SuppressWarnings("unused")
public class BasePlugin implements Plugin<Spin> {
    private FlowContainer flowContainer;
    private InfoContainer infoContainer;
    private RuleContainer ruleContainer;
    private LogSet logSet;
    private Spin spin;

    @Override
    public void apply(Spin spin) {
        this.spin = spin;
        this.logSet = new LogSet();
        this.flowContainer = new FlowContainer();
        this.infoContainer = new InfoContainer();
        this.ruleContainer = new RuleContainer();
        init();
    }

    private void init() {
        spin.getLogProcess().setLogSet(logSet);
        SpinLogLog.log(" logSet  " + logSet.toString());
    }

    public void info(Closure<?> closure) {
        infoContainer.clear();
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
        ruleContainer.clear();
        ConfigureUtil.configureByObject(closure, ruleContainer);
        RuleCase ruleCase = new RuleCase.Builder()
                .caseState(Configured)
                .build();
        ruleCase.addRules(ruleContainer.getRuleList());
        spin.getConfiguredCase().add(ruleCase);
    }

    public Rule when(Closure<?>[] rules) {
        ruleContainer.clear();
        Arrays.stream(rules).forEach(closure ->
                ConfigureUtil.configureByObject(closure, ruleContainer)
        );
        RuleCase ruleCase = new RuleCase.Builder()
                .caseState(Configured)
                .build();
        Rule rule = ruleContainer.getMergedRule();
        ruleCase.addRule(rule);
        spin.getConfiguredCase().add(ruleCase);
        return rule;
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
    public void resolveCase(Spin spin) {
        resolveInfoCase(spin.getConfiguredCase());
        resolveRuleCase(spin.getConfiguredCase());
    }

    private void resolveRuleCase(List<SpinCase> cases) {
        Iterator<SpinCase> iterator = cases.iterator();
        RuleCase ruleCase = new RuleCase.Builder()
                .caseState(Resolved)
                .build();
        while (iterator.hasNext()) {
            SpinCase spinCase = iterator.next();
            if (spinCase instanceof RuleCase) {
                ((RuleCase) spinCase).getRules()
                        .stream()
                        .filter(Rule::isLegal)
                        .forEach(ruleCase::addRule);
            }
        }
        spin.getResolvedCases().add(ruleCase);
    }

    private void resolveInfoCase(List<SpinCase> cases) {
        Iterator<SpinCase> iterator = cases.iterator();
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
