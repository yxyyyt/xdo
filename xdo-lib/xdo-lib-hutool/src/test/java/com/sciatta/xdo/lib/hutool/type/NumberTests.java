package com.sciatta.xdo.lib.hutool.type;

import cn.hutool.core.math.MathUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.NumberUtil;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rain on 2024/1/28<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * NumberTests
 */
public class NumberTests {
    @Test
    public void testRandom() {
        // 基于set的不可重复
        // [-8, 8)
        Integer[] integers = NumberUtil.generateBySet(-8, 8, 5);
        System.out.println(ArrayUtil.toString(integers));

        // 每次随机时，用最后一个数代替随机到的数，然后向前缩小一个位置
        // [-8, 8)
        int[] ints = NumberUtil.generateRandomNumber(-8, 8, 5);
        System.out.println(ArrayUtil.toString(ints));
    }

    @Test
    public void testP() {
        // 排列，和顺序相关
        // p(n,k) = n!/(n-k)!
        long size = MathUtil.arrangementCount(3, 2);
        assertEquals(6, size);

        // 全排列 p(n,n) = n!
        size = MathUtil.arrangementCount(3, 3);
        assertEquals(6, size);
    }

    @Test
    public void testC() {
        // 组合，和顺序无关
        // C(n,k) = n!/((n-k)!*k!)
        long size = MathUtil.combinationCount(3, 2);
        assertEquals(3, size);
    }


}
