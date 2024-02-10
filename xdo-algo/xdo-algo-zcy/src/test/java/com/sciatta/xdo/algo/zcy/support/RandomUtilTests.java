package com.sciatta.xdo.algo.zcy.support;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Rain on 2024/2/3<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * RandomUtilTests
 */
public class RandomUtilTests {
    @Test
    public void testRandomIntNumber() {
        AtomicInteger min = new AtomicInteger(Integer.MAX_VALUE);
        AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);

        ExecuteUtil.execute(() -> {
            int test = RandomUtil.randomIntNumber(100);
            min.set(Math.min(test, min.get()));
            max.set(Math.max(test, max.get()));
        }, 1, ExecuteUtil.A_MILLION_TIMES, RandomUtilTests.class);

        PrintUtil.log("min={}, max={}", min.get(), max.get());
    }

    @Test
    public void testRandomPositiveIntNumber() {
        AtomicInteger min = new AtomicInteger(Integer.MAX_VALUE);
        AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);

        ExecuteUtil.execute(() -> {
            int test = RandomUtil.randomPositiveIntNumber(100);
            min.set(Math.min(test, min.get()));
            max.set(Math.max(test, max.get()));
        }, 1, ExecuteUtil.A_MILLION_TIMES, RandomUtilTests.class);

        PrintUtil.log("min={}, max={}", min.get(), max.get());
    }

    @Test
    public void testRandomIntNumberArray() {
        AtomicInteger sizeMin = new AtomicInteger(Integer.MAX_VALUE);
        AtomicInteger sizeMax = new AtomicInteger(Integer.MIN_VALUE);
        AtomicInteger numberMin = new AtomicInteger(Integer.MAX_VALUE);
        AtomicInteger numberMax = new AtomicInteger(Integer.MIN_VALUE);

        ExecuteUtil.execute(() -> {
            int[] ans = RandomUtil.randomIntNumberArray(100, 100);
            sizeMin.set(Math.min(ans.length, sizeMin.get()));
            sizeMax.set(Math.max(ans.length, sizeMax.get()));

            for (int i : ans) {
                numberMin.set(Math.min(i, numberMin.get()));
                numberMax.set(Math.max(i, numberMax.get()));
            }
        }, 1, ExecuteUtil.A_MILLION_TIMES, RandomUtilTests.class);

        PrintUtil.log("sizeMin={}, sizeMax={}, numberMin={}, numberMax={}",
                sizeMin.get(), sizeMax.get(), numberMin.get(), numberMax.get());
    }

    @Test
    public void testRandomPositiveIntNumberArray() {
        AtomicInteger sizeMin = new AtomicInteger(Integer.MAX_VALUE);
        AtomicInteger sizeMax = new AtomicInteger(Integer.MIN_VALUE);
        AtomicInteger numberMin = new AtomicInteger(Integer.MAX_VALUE);
        AtomicInteger numberMax = new AtomicInteger(Integer.MIN_VALUE);

        ExecuteUtil.execute(() -> {
            int[] ans = RandomUtil.randomPositiveIntNumberArray(100, 100);
            sizeMin.set(Math.min(ans.length, sizeMin.get()));
            sizeMax.set(Math.max(ans.length, sizeMax.get()));

            for (int i : ans) {
                numberMin.set(Math.min(i, numberMin.get()));
                numberMax.set(Math.max(i, numberMax.get()));
            }
        }, 1, ExecuteUtil.A_MILLION_TIMES, RandomUtilTests.class);

        PrintUtil.log("sizeMin={}, sizeMax={}, numberMin={}, numberMax={}",
                sizeMin.get(), sizeMax.get(), numberMin.get(), numberMax.get());
    }

    @Test
    public void testRandomIntNumberArrayWithAdjacentDifferent() {
        ExecuteUtil.execute(() -> {
            int[] ans = RandomUtil.randomIntNumberArrayWithAdjacentDifferent(100, 100);

            if (ans.length == 0 || ans.length == 1) return;

            for (int i = 0; i < ans.length; i++) {
                if (i == 0) {
                    assertNotEquals(ans[i], ans[i + 1]);
                } else if (i == (ans.length - 1)) {
                    assertNotEquals(ans[i], ans[i - 1]);
                } else {
                    assertNotEquals(ans[i], ans[i - 1]);
                    assertNotEquals(ans[i], ans[i + 1]);
                }
            }
        }, 1, ExecuteUtil.A_MILLION_TIMES, RandomUtilTests.class);
    }

    @Test
    public void testRandomPositiveIntOddNumber() {
        ExecuteUtil.execute(() -> {
            int i = RandomUtil.randomPositiveIntOddNumber(100);
            PrintUtil.log(String.valueOf(i));
        }, 1, 10, RandomUtilTests.class);
    }

    @Test
    public void testRandomPositiveIntEvenNumber() {
        ExecuteUtil.execute(() -> {
            int i = RandomUtil.randomPositiveIntEvenNumber(100);
            PrintUtil.log(String.valueOf(i));
        }, 1, 10, RandomUtilTests.class);
    }

}
