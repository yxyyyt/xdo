package com.sciatta.xdo.algo.zcy._01_system._01;

import com.sciatta.xdo.algo.zcy.support.ArrayUtil;
import com.sciatta.xdo.algo.zcy.support.ExecuteUtil;
import com.sciatta.xdo.algo.zcy.support.PrintUtil;
import com.sciatta.xdo.algo.zcy.support.RandomUtil;

import java.util.Arrays;

/**
 * Created by Rain on 2024/2/4<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * 冒泡排序
 */
public class BubbleSort {
    public static void actual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    ArrayUtil.swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void expected(int[] nums) {
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        ExecuteUtil.execute(() -> {
            int[] nums = RandomUtil.randomIntNumberArray(100, 100);

            int[] actualNums = ArrayUtil.copy(nums);
            int[] expectedNums = ArrayUtil.copy(nums);

            actual(actualNums);
            expected(expectedNums);

            if (!ArrayUtil.equal(actualNums, expectedNums)) {
                PrintUtil.error("data: {}, actual: {}, expected: {}",
                        ArrayUtil.toString(nums),
                        ArrayUtil.toString(actualNums),
                        ArrayUtil.toString(expectedNums));
                ExecuteUtil.shutdown();
            }

        }, 1, ExecuteUtil.A_MILLION_TIMES, BubbleSort.class);
    }
}
