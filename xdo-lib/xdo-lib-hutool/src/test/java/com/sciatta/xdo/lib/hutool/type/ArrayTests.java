package com.sciatta.xdo.lib.hutool.type;

import cn.hutool.core.util.ArrayUtil;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rain on 2024/1/28<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * ArrayTests
 */
public class ArrayTests {
    @Test
    public void testNewArray() {
        String[] strings = ArrayUtil.newArray(String.class, 3);
        strings[0] = "hello";
        System.out.println(ArrayUtil.toString(strings));
    }

    @Test
    public void testRange() {
        int[] range = ArrayUtil.range(1, 8, 2);
        assertArrayEquals(new int[]{1, 3, 5, 7}, range);
    }
}
