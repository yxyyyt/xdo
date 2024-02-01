package com.sciatta.xdo.lib.hutool.tool;

import cn.hutool.core.convert.Converter;
import cn.hutool.core.convert.ConverterRegistry;
import lombok.Builder;
import lombok.Data;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rain on 2024/1/27<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * ConverterRegistryTests
 */
public class ConverterRegistryTests {
    @Test
    public void testCustomConvert() {
        ConverterRegistry.getInstance().putCustom(Dog.class, DogConverter.class);

        Cat cat = Cat.builder().name("mimi").build();
        Dog dog = ConverterRegistry.getInstance().convert(
                Dog.class,
                cat,
                Dog.builder().name("lucky").build()
        );

        assertEquals("mimi", dog.getName());
    }

    private static class DogConverter implements Converter<Dog> {

        @Override
        public Dog convert(Object value, Dog defaultValue) throws IllegalArgumentException {
            if (value instanceof Cat) {
                Cat cat = (Cat) value;
                return Dog.builder().name(cat.name).build();
            }
            return null;
        }
    }

    @Data
    @Builder
    private static class Dog {
        private String name;
    }

    @Data
    @Builder
    private static class Cat {
        private String name;
    }
}
