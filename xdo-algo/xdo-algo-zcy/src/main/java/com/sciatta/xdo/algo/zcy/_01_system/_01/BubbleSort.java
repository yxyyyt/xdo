package com.sciatta.xdo.algo.zcy._01_system._01;

import com.sciatta.xdo.algo.zcy.support.ArrayUtil;
import com.sciatta.xdo.algo.zcy.support.ExecuteUtil;
import com.sciatta.xdo.algo.zcy.support.RandomUtil;

import java.util.Arrays;

/**
 * Created by Rain on 2024/2/4<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * 冒泡排序
 */
public class BubbleSort {
    public static void actual(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1; j++) {
                if (data[j] > data[j + 1]) {
                    ArrayUtil.swap(data, j, j + 1);
                }
            }
        }
    }

    public static void expected(int[] data) {
        Arrays.sort(data);
    }

    public static void main(String[] args) {
        ExecuteUtil.execute(() -> {
            int[] data = RandomUtil.randomIntNumberArray(100, 100);

            int[] actualData = ArrayUtil.copy(data);
            int[] expectedData = ArrayUtil.copy(data);

            actual(actualData);
            expected(expectedData);

            ArrayUtil.equal(actualData, expectedData, data);

        }, 1, ExecuteUtil.MILLION_TIMES, BubbleSort.class);
    }
}
