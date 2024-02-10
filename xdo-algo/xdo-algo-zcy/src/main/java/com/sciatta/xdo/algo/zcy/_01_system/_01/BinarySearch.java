package com.sciatta.xdo.algo.zcy._01_system._01;

import com.sciatta.xdo.algo.zcy.support.ArrayUtil;
import com.sciatta.xdo.algo.zcy.support.ExecuteUtil;
import com.sciatta.xdo.algo.zcy.support.PrintUtil;
import com.sciatta.xdo.algo.zcy.support.RandomUtil;

import java.util.Arrays;

/**
 * Created by Rain on 2024/2/4<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * 在一个有序数组中，找某个数是否存在
 */
public class BinarySearch {
    public static int actual(int[] nums, int num) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);   // + 优先与 >>

            if (nums[mid] == num) {
                return mid;
            } else if (nums[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -(l + 1);
    }

    public static int expected(int[] nums, int num) {
        return Arrays.binarySearch(nums, num);
    }

    public static void main(String[] args) {
        ExecuteUtil.execute(() -> {
            int[] nums = RandomUtil.randomIntNumberArrayWithSort(100, 100);
            int num = RandomUtil.randomIntNumber(100);

            int a = actual(nums, num);
            int e = expected(nums, num);

            if (a != e) {
                PrintUtil.error("search {} from {}, expected is {}, but actual is {}",
                        num, ArrayUtil.toString(nums), e, a);
                ExecuteUtil.shutdown();
            }

        }, 1, ExecuteUtil.A_MILLION_TIMES, BinarySearch.class);
    }
}
