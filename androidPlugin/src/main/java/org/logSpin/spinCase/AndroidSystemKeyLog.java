package org.logSpin.spinCase;

import java.util.Arrays;
import java.util.List;

public class AndroidSystemKeyLog {
    public static final String PROC_START = "am_proc_start";
    public static final String PROC_DIED = "am_proc_died";
    public static final String PROC_BOUND = "am_proc_bound";

    public static List<String> getProcessRelatedKeyLog(){
        return Arrays.asList(PROC_START,PROC_BOUND,PROC_DIED);
    }
}
