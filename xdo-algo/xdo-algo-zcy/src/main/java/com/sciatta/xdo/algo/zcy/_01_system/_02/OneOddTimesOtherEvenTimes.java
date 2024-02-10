package com.sciatta.xdo.algo.zcy._01_system._02;

import com.sciatta.xdo.algo.zcy.support.ArrayUtil;
import com.sciatta.xdo.algo.zcy.support.ExecuteUtil;
import com.sciatta.xdo.algo.zcy.support.PrintUtil;
import com.sciatta.xdo.algo.zcy.support.RandomUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Rain on 2024/2/6<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数
 */
public class OneOddTimesOtherEvenTimes {
    public static int actual(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    public static int expected(int[] nums) {
        Map<Integer, Integer> helpMap = new HashMap<>();
        for (int j : nums) {
            if (helpMap.get(j) == null) {
                helpMap.put(j, 1);
            } else {
                int v = helpMap.get(j);
                helpMap.put(j, ++v);
            }
        }

        for (Integer key : helpMap.keySet()) {
            if (helpMap.get(key) % 2 != 0) {
                return key;
            }
        }

        // not reach
        return -1;
    }

    public static int[] getNums(int maxKind, int maxSizeOneKind, int maxNumber) {
        int totalSize = 0;

        // 至少一种数
        int kind;
        do {
            kind = RandomUtil.randomPositiveIntNumber(maxKind);
        } while (kind < 1);

        // 为每一种数预分配空间
        int[] sizeOneKinds = new int[kind];
        // 一种奇数
        sizeOneKinds[0] = RandomUtil.randomPositiveIntOddNumber(maxSizeOneKind);
        totalSize += sizeOneKinds[0];
        // 其他偶数
        for (int i = 1; i < kind; i++) {
            sizeOneKinds[i] = RandomUtil.randomPositiveIntEvenNumber(maxSizeOneKind);
            totalSize += sizeOneKinds[i];
        }

        int[] ans = new int[totalSize];
        int index = 0;
        Set<Integer> onlyOne = new HashSet<>();
        // 填数
        for (int i = 0; i < kind; i++) {
            int num;
            // 保证出现的唯一性
            do {
                num = RandomUtil.randomIntNumber(maxNumber);
            } while (!onlyOne.add(num));

            for (int j = 0; j < sizeOneKinds[i]; j++) {
                ans[index++] = num;
            }
        }

        // 洗牌
        ArrayUtil.shuffle(ans);
        return ans;
    }

    public static void main(String[] args) {
        ExecuteUtil.execute(() -> {
            int maxKind = 5;
            int maxSizeOneKind = 10;
            int maxNumber = 100;
            int[] nums = getNums(maxKind, maxSizeOneKind, maxNumber);

            int[] actualNums = ArrayUtil.copy(nums);
            int[] expectedNums = ArrayUtil.copy(nums);

            int actual = actual(actualNums);
            int expected = expected(expectedNums);

            if (actual != expected) {
                PrintUtil.error("nums={}, expected odd num={}, but odd num={}",
                        ArrayUtil.toString(nums), expected, actual);
                ExecuteUtil.shutdown();
            }

        }, 1, ExecuteUtil.A_MILLION_TIMES, OneOddTimesOtherEvenTimes.class);
    }
}
