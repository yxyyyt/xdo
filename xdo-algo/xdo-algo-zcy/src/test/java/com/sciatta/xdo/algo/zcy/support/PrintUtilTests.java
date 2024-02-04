package com.sciatta.xdo.algo.zcy.support;

import org.junit.Test;

/**
 * Created by Rain on 2024/2/3<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * PrintUtilTests
 */
public class PrintUtilTests {
    @Test
    public void testLog() {
        PrintUtil.log("{} name is {}!", "Dog", "lucky");
    }

    @Test
    public void testError() {
        PrintUtil.error("{} has a error!", RuntimeException.class);
    }
}
