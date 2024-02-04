package com.sciatta.xdo.algo.zcy._01_system._01;

import com.sciatta.xdo.algo.zcy.support.ArrayUtil;
import com.sciatta.xdo.algo.zcy.support.ExecuteUtil;
import com.sciatta.xdo.algo.zcy.support.PrintUtil;
import com.sciatta.xdo.algo.zcy.support.RandomUtil;

/**
 * Created by Rain on 2024/2/4<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * 局部最小值问题。无序数组且任意相邻的数不相等，找到一个局部最小值返回
 */
public class LocalMinimum {
    public static int solve(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return -1;
        }

        if (nums[0] < nums[1]) {
            return 0;
        }

        if (nums[nums.length - 2] > nums[nums.length - 1]) {
            return nums.length - 1;
        }

        int l = 1;
        int r = nums.length - 2;    // 排除掉两边不符合条件的元素

        int ans = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid - 1] > nums[mid] && nums[mid + 1] > nums[mid]) {
                return mid;
            } else if (nums[mid - 1] < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    public static boolean test(int[] nums, int ans) {
        if (ans == -1) return true;

        if (ans == 0) {
            return nums[0] < nums[1];
        }

        if (ans == nums.length - 1) {
            return nums[nums.length - 2] > nums[nums.length - 1];
        }

        return nums[ans - 1] > nums[ans] && nums[ans + 1] > nums[ans];
    }

    public static void main(String[] args) {
        ExecuteUtil.execute(() -> {
            int[] nums = RandomUtil.randomIntNumberArrayWithAdjacentDifferent(100, 100);

            int ans = -1;
            try {
                ans = solve(nums);
            } catch (Exception e) {
                PrintUtil.error("exception [{}] occurred when solve in nums {}",
                        e, ArrayUtil.toString(nums));
                ExecuteUtil.shutdown();
            }

            if (!test(nums, ans)) {
                PrintUtil.error("index {} is not local minimum in nums {}",
                        ans, ArrayUtil.toString(nums));
                ExecuteUtil.shutdown();
            }

        }, 1, ExecuteUtil.A_MILLION_TIMES, LocalMinimum.class);
    }

}
