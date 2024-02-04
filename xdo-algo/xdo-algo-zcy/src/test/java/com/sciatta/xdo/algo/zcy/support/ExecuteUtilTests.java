package com.sciatta.xdo.algo.zcy.support;

import org.junit.Test;

/**
 * Created by Rain on 2024/2/3<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * ExecuteUtilTests
 */
public class ExecuteUtilTests {
    @Test
    public void testOneThreadExecute() {
        ExecuteUtil.execute(() -> {
            ExecuteUtil.sleep(RandomUtil.randomPositiveIntNumber(100));
        }, 1, 100, ExecuteUtilTests.class);
    }

    @Test
    public void testMoreThreadExecute() {
        ExecuteUtil.execute(() -> {
            ExecuteUtil.sleep(RandomUtil.randomPositiveIntNumber(100));
        }, 3, 100, ExecuteUtilTests.class);
    }
}
