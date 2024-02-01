package com.sciatta.xdo.lib.hutool.bean;

import cn.hutool.core.bean.BeanUtil;
import lombok.Data;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Rain on 2024/1/29<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * BeanTests
 */
public class BeanTests {
    @Test
    public void isBean() {
        boolean test = BeanUtil.isBean(HashMap.class);
        assertFalse(test);

        test = BeanUtil.isBean(Dog.class);
        assertTrue(test);
    }

    @Data
    private static class Dog {
        private String name;
        private int age;
    }

}
