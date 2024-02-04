package com.sciatta.xdo.algo.zcy._01_system._01;

import com.sciatta.xdo.algo.zcy.support.ArrayUtil;
import com.sciatta.xdo.algo.zcy.support.ExecuteUtil;
import com.sciatta.xdo.algo.zcy.support.RandomUtil;

import java.util.Arrays;

/**
 * Created by Rain on 2024/2/4<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * 插入排序
 */
public class InsertSort {
    public static void actual(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int comp = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > comp) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = comp;
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

        }, 1, ExecuteUtil.MILLION_TIMES, InsertSort.class);
    }
}
