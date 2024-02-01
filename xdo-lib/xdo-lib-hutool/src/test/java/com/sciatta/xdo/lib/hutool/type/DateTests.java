package com.sciatta.xdo.lib.hutool.type;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.thread.ThreadUtil;
import org.junit.Test;

/**
 * Created by Rain on 2024/1/27<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * DateTests
 */
public class DateTests {
    @Test
    public void testNow() {
        String now = DateUtil.now();
        System.out.println(now);
    }

    @Test
    public void testCurrentTimeMillis() {
        long current = DateUtil.current();
        System.out.println(current);
    }

    @Test
    public void testOffset() {
        String date = "2024-1-27";
        DateTime offset = DateUtil.parse(date).offset(DateField.DAY_OF_MONTH, -3);
        System.out.println(DateUtil.format(offset, "yyyy-MM-dd"));
    }

    @Test
    public void testAge() {
        int i = DateUtil.ageOfNow("1982-7-1");
        System.out.println(i);
    }

    @Test
    public void testInterval() {
        TimeInterval timer = DateUtil.timer();
        ThreadUtil.sleep(2000);
        System.out.println("cost: " + timer.intervalMs() + "ms");
    }
}
