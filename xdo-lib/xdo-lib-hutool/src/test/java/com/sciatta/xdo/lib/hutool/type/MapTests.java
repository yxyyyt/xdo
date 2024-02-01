package com.sciatta.xdo.lib.hutool.type;

import cn.hutool.core.map.BiMap;
import cn.hutool.core.map.MapBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rain on 2024/1/30<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * MapTests
 */
public class MapTests {
    @Test
    public void testBiMap() {
        BiMap<String, Integer> map = new BiMap<>(new HashMap<>());
        map.put("aaa", 111);
        map.put("bbb", 222);

        assertEquals(Integer.valueOf(111), map.get("aaa"));
        assertEquals("bbb", map.getKey(222));
    }

    @Test
    public void testBuilder() {
        Map<String, Integer> map = MapBuilder.create(new HashMap<String, Integer>())
                .put("aaa", 111)
                .put("bbb", 222)
                .build();

        assertEquals(Integer.valueOf(111), map.get("aaa"));
        assertEquals(2, map.size());
    }
}
