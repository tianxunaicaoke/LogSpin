package org.logSpin.spinCase;

import org.logSpin.LogProcess;


import java.util.ArrayList;
import java.util.List;

public class VariantCase extends DefaultCase {
    private final List<String> processes = new ArrayList<>();

    public void addProcessId(String processId){
        processes.add(processId);
    }

    @Override
    public void action(LogProcess logProcess) {

    }
}
