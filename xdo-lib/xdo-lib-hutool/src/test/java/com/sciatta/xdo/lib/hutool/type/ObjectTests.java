package com.sciatta.xdo.lib.hutool.type;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import lombok.Data;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

/**
 * Created by Rain on 2024/1/28<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * ObjectTests
 */
public class ObjectTests {
    @Test
    public void testLength() {
        int[] data = new int[]{1, 2, 3, 4, 5};
        int length = ObjectUtil.length(data);
        assertEquals(5, length);
    }

    @Test
    public void testBasicType() {
        Integer i = 1;
        assertTrue(ObjectUtil.isBasicType(i));

        Object obj = new Object();
        assertFalse(ObjectUtil.isBasicType(obj));
    }

    @Test
    public void testGetMethod() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<Cat> cons = ReflectUtil.getConstructor(Cat.class, String.class);
        Cat cat = cons.newInstance("lucky");

        assertNotNull(cat);
        assertEquals("lucky", cat.getName());
    }

    @Test
    public void testGetPackage() {
        String aPackage = ClassUtil.getPackage(ObjectTests.class);
        assertEquals("com.sciatta.xdo.lib.hutool.type", aPackage);
    }

    @Data
    private static class Cat {
        private String name;
        private int age;

        public Cat() {
            this("null");
        }

        private Cat(String name) {
            this(name, 0);
        }

        public Cat(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
