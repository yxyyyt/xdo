package com.sciatta.xdo.algo.zcy._01_system._01;

import com.sciatta.xdo.algo.zcy.support.ArrayUtil;
import com.sciatta.xdo.algo.zcy.support.ExecuteUtil;
import com.sciatta.xdo.algo.zcy.support.RandomUtil;

import java.util.Arrays;

/**
 * Created by Rain on 2024/2/2<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * 选择排序
 */
public class SelectionSort {

    public static void actual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                minIndex = nums[minIndex] < nums[j] ? minIndex : j;
            }
            ArrayUtil.swap(nums, i, minIndex);
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

            ArrayUtil.equal(actualNums, actualNums, nums);

        }, 1, ExecuteUtil.A_MILLION_TIMES, SelectionSort.class);
    }

}
