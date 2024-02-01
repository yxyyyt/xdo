package com.sciatta.xdo.lib.hutool.bean;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.DynaBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rain on 2024/1/29<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * DynaBeanTests
 */
public class DynaBeanTests {
    @Test
    public void testDyna() {
        DynaBean bean = DynaBean.create(Dog.class);
        bean.set("name", "lucky");
        bean.set("age", 5);

        assertEquals("lucky", bean.get("name"));
        assertEquals(Integer.valueOf(5), bean.get("age"));

        Dog dog = bean.getBean();
        assertEquals("lucky", dog.getName());
        assertEquals(5, dog.getAge());

        String nameValue = (String) bean.invoke("getName");
        assertEquals("lucky", nameValue);
    }

    @Test
    public void testFillBean() {
        Dog myDog = new Dog();
        HashMap<String, Object> dogMap = new LinkedHashMap<>();
        dogMap.put("name", "lucky");
        dogMap.put("age", 5);

        Dog dog = BeanUtil.fillBeanWithMap(dogMap, myDog, false);
        assertEquals("lucky", dog.getName());
        assertEquals(5, dog.getAge());
    }

    @Test
    public void testBeanPath() {
        HashMap<String, Dog> dogs = new LinkedHashMap<>();
        dogs.put("myDog", new Dog("l", 5));

        String name = BeanUtil.getProperty(dogs, "myDog.name");
        assertEquals("l", name);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Dog {
        private String name;
        private int age;
    }
}
