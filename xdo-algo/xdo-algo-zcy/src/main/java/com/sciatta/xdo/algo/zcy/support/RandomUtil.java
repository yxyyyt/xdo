package com.sciatta.xdo.algo.zcy.support;

import java.util.Arrays;

/**
 * Created by Rain on 2024/2/2<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * RandomUtil
 */
public class RandomUtil {
    public static int randomIntNumber(int maxNumber) {
        return (int) (Math.random() * (maxNumber + 1)) - (int) (Math.random() * (maxNumber + 1));
    }

    public static int randomPositiveIntNumber(int maxNumber) {
        return (int) (Math.random() * (maxNumber + 1));
    }

    public static int[] randomIntNumberArray(int maxSize, int maxNumber) {
        int size = randomPositiveIntNumber(maxSize);
        int[] nums = new int[size];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = randomIntNumber(maxNumber);
        }
        return nums;
    }

    public static int[] randomPositiveIntNumberArray(int maxSize, int maxNumber) {
        int[] nums = randomIntNumberArray(maxSize, maxNumber);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] < 0 ? -nums[i] : nums[i];
        }

        return nums;
    }

    public static int[] randomIntNumberArrayWithAdjacentDifferent(int maxSize, int maxNumber) {
        int[] nums = randomIntNumberArray(maxSize, maxNumber);

        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                while (nums[i] == nums[i + 1]) {
                    nums[i] = randomIntNumber(maxNumber);
                }
            } else if (i == (nums.length - 1)) {
                while (nums[i] == nums[i - 1]) {
                    nums[i] = randomIntNumber(maxNumber);
                }
            } else {
                while (nums[i] == nums[i - 1] || nums[i] == nums[i + 1]) {
                    nums[i] = randomIntNumber(maxNumber);
                }
            }
        }

        return nums;
    }

    public static int[] randomIntNumberArrayWithSort(int maxSize, int maxNumber) {
        int[] nums = randomIntNumberArray(maxSize, maxNumber);
        Arrays.sort(nums);
        return nums;
    }

}
