package com.sciatta.xdo.algo.zcy._01_system._01;

import com.sciatta.xdo.algo.zcy.support.ArrayUtil;
import com.sciatta.xdo.algo.zcy.support.ExecuteUtil;
import com.sciatta.xdo.algo.zcy.support.RandomUtil;

import java.util.Arrays;

/**
 * Created by Rain on 2024/2/2<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * 选择排序
 */
public class SelectionSort {

    public static void actual(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                minIndex = data[minIndex] < data[j] ? minIndex : j;
            }
            ArrayUtil.swap(data, i, minIndex);
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

        }, 1, ExecuteUtil.MILLION_TIMES);
    }

}
