package com.sciatta.xdo.lib.hutool.tool;

import cn.hutool.core.clone.Cloneable;
import cn.hutool.core.util.ObjectUtil;
import lombok.Builder;
import lombok.Data;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

/**
 * Created by Rain on 2024/1/27<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * CloneTests
 */
public class CloneTests {
    @Test
    public void testClone() {
        Cat cat = Cat.builder().master(new Master()).build();
        Cat clone = cat.clone();

        // 浅克隆对象不相同，但引用的对象是同一个
        assertNotSame(cat, clone);
        assertSame(cat.getMaster(), clone.getMaster());
    }

    @Test
    public void testDeepClone() {
        Dog dog = Dog.builder().master(new Master()).build();
        Dog clone = ObjectUtil.clone(dog);

        // 深克隆对象不相同，引用的对象也不是同一个
        assertNotSame(dog, clone);
        assertNotSame(dog.getMaster(), clone.getMaster());
    }

    @Builder
    @Data
    private static class Cat implements Cloneable<Cat> {
        private Master master;

        @Override
        public Cat clone() {
            try {
                return (Cat) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Builder
    @Data
    private static class Dog implements Serializable {  // 深克隆需要实现Serializable接口
        private static final long serialVersionUID = 7352116818713965234L;
        private Master master;
    }

    private static class Master implements Serializable {
        private static final long serialVersionUID = -5623263737621455217L;
    }
}
