package com.sciatta.xdo.algo.zcy._01_system._02;

import com.sciatta.xdo.algo.zcy.support.ArrayUtil;
import com.sciatta.xdo.algo.zcy.support.ExecuteUtil;
import com.sciatta.xdo.algo.zcy.support.PrintUtil;
import com.sciatta.xdo.algo.zcy.support.RandomUtil;

import java.util.*;

/**
 * Created by Rain on 2024/2/7<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数
 */
public class TwoOddTimesOtherEvenTimes {
    public static int[] actual(int[] nums) {
        int c = 0;
        for (int num : nums) {
            c ^= num;
        }

        int t = c & (-c);

        int a = 0;
        for (int num : nums) {
            if ((t & num) != 0) {
                a ^= num;
            }
        }

        int b = c ^ a;

        int[] ans = {a, b};

        Arrays.sort(ans);
        return ans;
    }

    public static int[] expected(int[] nums) {
        int[] ans = new int[2];

        Map<Integer, Integer> helpMap = new HashMap<>();
        for (int j : nums) {
            if (helpMap.get(j) == null) {
                helpMap.put(j, 1);
            } else {
                int v = helpMap.get(j);
                helpMap.put(j, ++v);
            }
        }

        int index = 0;
        for (int key : helpMap.keySet()) {
            if (helpMap.get(key) % 2 != 0) {
                ans[index++] = key;
                if (index >= 2)
                    break;
            }
        }

        Arrays.sort(ans);
        return ans;
    }

    public static int[] getNums(int maxKind, int maxSizeOneKind, int maxNumber) {
        int totalSize = 0;

        // 至少2种数
        int kind;
        do {
            kind = RandomUtil.randomPositiveIntNumber(maxKind);
        } while (kind < 2);

        // 为每一种数预分配空间
        int[] sizeOneKinds = new int[kind];
        // 两种奇数
        sizeOneKinds[0] = RandomUtil.randomPositiveIntOddNumber(maxSizeOneKind);
        totalSize += sizeOneKinds[0];
        sizeOneKinds[1] = RandomUtil.randomPositiveIntOddNumber(maxSizeOneKind);
        totalSize += sizeOneKinds[1];
        // 其他偶数
        for (int i = 2; i < kind; i++) {
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

            int[] actual = actual(actualNums);
            int[] expected = expected(expectedNums);

            if (!ArrayUtil.equal(actual, expected)) {
                PrintUtil.error("nums={}, expected two odd nums={}, but two odd nums={}",
                        ArrayUtil.toString(nums), ArrayUtil.toString(expected), ArrayUtil.toString(actual));
                ExecuteUtil.shutdown();
            }

        }, 1, ExecuteUtil.A_MILLION_TIMES, OneOddTimesOtherEvenTimes.class);
    }
}
