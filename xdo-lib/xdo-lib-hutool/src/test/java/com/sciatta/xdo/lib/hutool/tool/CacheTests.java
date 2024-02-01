package com.sciatta.xdo.lib.hutool.tool;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.FIFOCache;
import cn.hutool.core.date.DateUnit;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rain on 2024/1/31<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * CacheTests
 */
public class CacheTests {
    @Test
    public void testFIFOCache() {
        FIFOCache<String, String> cache = CacheUtil.newFIFOCache(3);
        cache.put("a", "1", DateUnit.SECOND.getMillis() * 3);
        cache.put("b", "2", DateUnit.SECOND.getMillis() * 3);
        cache.put("c", "3", DateUnit.SECOND.getMillis() * 3);

        assertEquals(3, cache.size());
        assertEquals("1", cache.get("a"));

        cache.put("d", "4", DateUnit.SECOND.getMillis() * 3);

        assertEquals(3, cache.size());
        assertNull(cache.get("a"));
    }
}
