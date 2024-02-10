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
 * Created by Rain on 2024/2/7<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * 一个数组中有一种数出现了K次，其他数都出现了M次，其中 M>1，K<M。找到出现了K次的数。要求 额外空间复杂度O(1)，时间复杂度O(N)
 */
public class OneKTimesOtherMTimes {
    private static int kind;
    private static int m;
    private static int k;

    public static int actual(int[] nums, int k, int m) {
        int[] times = new int[32];

        for (int i = 0; i < times.length; i++) {
            for (int num : nums) {
                times[i] += ((num >> i) & 1);
            }
        }

        int ans = 0;
        for (int i = 0; i < times.length; i++) {
            // 注意此处如果k是0次，m一定不为0 ，则出现m次的数位如果是1，则%m是0，等于k；如果出现m次的数位如果是0，则%m是0，等于k
            // 则结果是 1111.........1111，即为-1，则和expected逻辑一致
            if (times[i] % m == k) {
                ans |= 1 << i;
            }
        }

        return ans;
    }

    public static int expected(int[] nums, int k, int m) {
        Map<Integer, Integer> helpMap = new HashMap<>();

        for (int num : nums) {
            if (helpMap.get(num) == null) {
                helpMap.put(num, 1);
            } else {
                int v = helpMap.get(num);
                helpMap.put(num, ++v);
            }
        }

        for (int key : helpMap.keySet()) {
            if (helpMap.get(key) == k) {
                return key;
            }
        }

        // 出现k次的数没有出现，即k是0
        return -1;
    }

    public static int[] getNums(int maxKind, int maxSizeOneKind, int maxNumber) {
        int totalSize = 0;

        // 至少一种数，这种数出现了m次
        do {
            kind = RandomUtil.randomPositiveIntNumber(maxKind);
        } while (kind < 1);

        // 计算k和m
        do {
            m = RandomUtil.randomPositiveIntNumber(maxSizeOneKind);
        } while (m <= 1);

        if (kind == 1) {
            k = 0;
        } else {
            k = RandomUtil.randomPositiveIntNumber(m - 1);
        }

        // 为每一种数预分配空间
        int[] sizeOneKinds = new int[kind];
        if (kind == 1) {
            // 如果只有一种数，这个数一定出现m次
            sizeOneKinds[0] = m;
            totalSize += sizeOneKinds[0];
        } else {
            // 如果出现一种数以上，则一种出现k次，其他出现m次
            sizeOneKinds[0] = k;
            totalSize += sizeOneKinds[0];
            for (int i = 1; i < kind; i++) {
                sizeOneKinds[i] = m;
                totalSize += sizeOneKinds[i];
            }
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

            int actual = actual(nums, k, m);

            int expected = expected(nums, k, m);

            if (actual != expected) {
                PrintUtil.error("nums={}, k={}, m={}, kind={}, The number of occurrences of k expected is {}, but actual is {}",
                        ArrayUtil.toString(nums), k, m, kind, expected, actual);
                ExecuteUtil.shutdown();
            }

        }, 1, ExecuteUtil.A_MILLION_TIMES, OneKTimesOtherMTimes.class);
    }
}
