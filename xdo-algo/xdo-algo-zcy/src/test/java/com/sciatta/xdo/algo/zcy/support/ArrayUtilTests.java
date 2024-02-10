package com.sciatta.xdo.algo.zcy.support;

import org.junit.Test;

/**
 * Created by Rain on 2024/2/7<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * ArrayUtilTests
 */
public class ArrayUtilTests {
    @Test
    public void testShuffle() {
        ExecuteUtil.execute(() -> {
            int seed = 10;

            int[] nums = RandomUtil.randomIntNumberArray(seed, seed);

            int[] ans = ArrayUtil.copy(nums);
            ArrayUtil.shuffle(ans);

            PrintUtil.log("nums={}, after shuffle nums={}",
                    ArrayUtil.toString(nums), ArrayUtil.toString(ans));

        }, 1, 10, ArrayUtilTests.class);


    }
}
