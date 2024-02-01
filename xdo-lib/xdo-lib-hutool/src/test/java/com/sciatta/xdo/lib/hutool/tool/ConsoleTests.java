package com.sciatta.xdo.lib.hutool.tool;

import cn.hutool.core.lang.Console;
import org.junit.Test;

/**
 * Created by Rain on 2024/1/28<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * ConsoleTests
 */
public class ConsoleTests {
    @Test
    public void testLog() {
        Console.log("hi, {}", "rain");
        Console.log(new int[]{1, 2, 3});
    }

    @Test
    public void testError() {
        Console.error("is a {} error", IllegalArgumentException.class);
    }
}
