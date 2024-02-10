package com.sciatta.xdo.algo.zcy._01_system._02;

import com.sciatta.xdo.algo.zcy.support.ExecuteUtil;
import com.sciatta.xdo.algo.zcy.support.PrintUtil;
import com.sciatta.xdo.algo.zcy.support.RandomUtil;

/**
 * Created by Rain on 2024/2/7<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * 怎么把一个int类型的数，提取出最右侧的1
 */
public class RightMost1 {
    public static int actual(int num) {
        return num & (-num);
    }

    public static int expected(int num) {
        int i = Integer.numberOfTrailingZeros(num);

        return 1 << i;
    }

    public static void main(String[] args) {
        ExecuteUtil.execute(() -> {
            int number = RandomUtil.randomIntNumber(Integer.MAX_VALUE);

            int actual = actual(number);
            int expected = expected(number);

            if (actual != expected) {
                PrintUtil.error("number get right most 1, expected is {}, but actual is",
                        number, expected, actual);
                ExecuteUtil.shutdown();
            }

        }, 1, ExecuteUtil.A_MILLION_TIMES, RightMost1.class);
    }
}
