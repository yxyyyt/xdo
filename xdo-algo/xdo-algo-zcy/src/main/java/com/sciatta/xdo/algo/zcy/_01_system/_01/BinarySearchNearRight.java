package com.sciatta.xdo.algo.zcy._01_system._01;

import com.sciatta.xdo.algo.zcy.support.ArrayUtil;
import com.sciatta.xdo.algo.zcy.support.ExecuteUtil;
import com.sciatta.xdo.algo.zcy.support.PrintUtil;
import com.sciatta.xdo.algo.zcy.support.RandomUtil;

/**
 * Created by Rain on 2024/2/4<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * 在一个有序数组中，找 <= 某个数最右侧的位置
 */
public class BinarySearchNearRight {
    public static int actual(int[] nums, int num) {
        int l = 0;
        int r = nums.length - 1;

        int ans = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 2);
            if (nums[mid] <= num) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    public static int expected(int[] nums, int num) {
        int nearRight = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= num) {
                nearRight = i;
            } else {
                break;
            }
        }

        return nearRight;
    }

    public static void main(String[] args) {
        ExecuteUtil.execute(() -> {
            int[] nums = RandomUtil.randomIntNumberArrayWithSort(100, 100);
            int num = RandomUtil.randomIntNumber(100);

            int a = actual(nums, num);
            int e = expected(nums, num);

            if (a != e) {
                PrintUtil.log("search <= {} near right from {}, expected is {}, but actual is {}",
                        num, ArrayUtil.toString(nums), e, a);
                ExecuteUtil.shutdown();
            }

        }, 1, ExecuteUtil.A_MILLION_TIMES, BinarySearchNearRight.class);

    }
}
