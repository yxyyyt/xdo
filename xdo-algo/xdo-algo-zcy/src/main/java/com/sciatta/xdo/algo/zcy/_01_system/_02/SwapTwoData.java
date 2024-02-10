package com.sciatta.xdo.algo.zcy._01_system._02;

import com.sciatta.xdo.algo.zcy.support.ArrayUtil;
import com.sciatta.xdo.algo.zcy.support.ExecuteUtil;
import com.sciatta.xdo.algo.zcy.support.PrintUtil;
import com.sciatta.xdo.algo.zcy.support.RandomUtil;

/**
 * Created by Rain on 2024/2/6<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * 不用额外变量交换两个数
 */
public class SwapTwoData {
    public static void actual(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void expected(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        ExecuteUtil.execute(() -> {
            int[] nums = RandomUtil.randomIntNumberArray(100, 100);

            if (nums.length < 2) return;

            int size = nums.length - 1;
            int i = RandomUtil.randomPositiveIntNumber(size);
            int j;
            do {
                j = RandomUtil.randomPositiveIntNumber(size);
            } while (i == j);

            int[] actual = ArrayUtil.copy(nums);
            int[] expected = ArrayUtil.copy(nums);

            try {
                actual(actual, i, j);
            } catch (Exception e) {
                PrintUtil.error("numbers={} size={} swap {} and {} catch exception {}",
                        ArrayUtil.toString(nums), nums.length, i, j, e);
                ExecuteUtil.shutdown();
            }

            expected(expected, i, j);


            if (!ArrayUtil.equal(actual, expected)) {
                PrintUtil.error("numbers={} size={} swap {} and {} expected={} but actual={}",
                        ArrayUtil.toString(nums), nums.length, i, j, expected, actual);
                ExecuteUtil.shutdown();
            }

        }, 1, ExecuteUtil.A_MILLION_TIMES, SwapTwoData.class);
    }
}
