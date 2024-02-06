package com.sciatta.xdo.algo.zcy._01_system._01;

import com.sciatta.xdo.algo.zcy.support.ArrayUtil;
import com.sciatta.xdo.algo.zcy.support.ExecuteUtil;
import com.sciatta.xdo.algo.zcy.support.PrintUtil;
import com.sciatta.xdo.algo.zcy.support.RandomUtil;

import java.util.Arrays;

/**
 * Created by Rain on 2024/2/4<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * 插入排序
 */
public class InsertSort {
    public static void actual(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int comp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > comp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = comp;
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

        }, 1, ExecuteUtil.A_MILLION_TIMES, InsertSort.class);
    }
}
