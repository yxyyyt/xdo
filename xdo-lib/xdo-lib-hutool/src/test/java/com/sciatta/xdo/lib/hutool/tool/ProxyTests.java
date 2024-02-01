package com.sciatta.xdo.lib.hutool.tool;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.aop.aspects.TimeIntervalAspect;
import cn.hutool.core.lang.Console;
import org.junit.Test;

/**
 * Created by Rain on 2024/1/31<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * ProxyTests
 */
public class ProxyTests {
    @Test
    public void testAOP() {
        Animal proxy = ProxyUtil.proxy(new Dog(), TimeIntervalAspect.class);
        proxy.eat();
    }

    private static class Dog implements Animal {

        @Override
        public void eat() {
            Console.log("wang...");
        }
    }

    private interface Animal {
        void eat();
    }
}
