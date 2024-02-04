package com.sciatta.xdo.algo.zcy.support;

import java.util.Arrays;

/**
 * Created by Rain on 2024/2/4<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * ArrayUtil
 */
public class ArrayUtil {
    public static int[] copy(int[] data) {
        return Arrays.copyOf(data, data.length);
    }

    public static String toString(int[] data) {
        return Arrays.toString(data);
    }

    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void equal(int[] actualData, int[] expectedData, int[] data) {
        if (!Arrays.equals(actualData, expectedData)) {
            PrintUtil.error("data: {}, actual: {}, expected: {}",
                    toString(data),
                    toString(actualData),
                    toString(expectedData));
            ExecuteUtil.shutdown();
        }
    }
}
