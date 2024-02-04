package com.sciatta.xdo.algo.zcy.support;

import java.util.Arrays;

/**
 * Created by Rain on 2024/2/2<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * PrintUtil
 */
public class PrintUtil {
    public static void log(String fmt, Object... args) {
        String s = fmt.replace("{}", "%s");

        System.out.printf((s) + "%n", args);
    }

    public static void error(String fmt, Object... args) {
        String s = fmt.replace("{}", "%s");

        System.err.printf((s) + "%n", args);
    }
}
