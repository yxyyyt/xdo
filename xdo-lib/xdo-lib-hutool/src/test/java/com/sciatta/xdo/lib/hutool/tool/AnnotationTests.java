package com.sciatta.xdo.lib.hutool.tool;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ClassUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import static org.junit.Assert.*;

import java.lang.annotation.*;

/**
 * Created by Rain on 2024/1/30<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * AnnotationTests
 */
public class AnnotationTests {
    @Test
    public void testGetAnnotation() {
        Dog dog = new Dog("test");
        Console.log(dog.sayHello());

        String v = AnnotationUtil.getAnnotationValue(Dog.class /* AnnotatedElement */, Anno.class /* Annotation */);
        assertEquals("lucky", v);

        String home = AnnotationUtil.getAnnotationValue(Dog.class, Anno.class, "home");
        assertEquals("lx", home);

        Annotation[] annotations = AnnotationUtil.getAnnotations(Dog.class, false);
        assertEquals(1, annotations.length);
        assertTrue(annotations[0] instanceof Anno);

        v = AnnotationUtil.getAnnotationValue(ClassUtil.getPublicMethod(Dog.class, "sayHello"), Anno.class);
        assertEquals("say-hello", v);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Anno(value = "lucky", home = "lx")
    private static class Dog {
        private String name;

        @Anno(value = "say-hello", home = "lx")
        public String sayHello() {
            return "hello, " + name;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD, ElementType.TYPE})
    private @interface Anno {
        String value();

        String home();
    }
}
