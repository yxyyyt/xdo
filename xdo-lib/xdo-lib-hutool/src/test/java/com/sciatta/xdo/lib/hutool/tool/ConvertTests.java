package com.sciatta.xdo.lib.hutool.tool;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Rain on 2024/1/27<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * ConvertTests
 */
public class ConvertTests {
    @Test
    public void testToStr() {
        int i = 1;
        String str = Convert.toStr(i);
        assertEquals("1", str);
    }

    @Test
    public void testGenericTypes() {
        // 泛型类型转换
        Object[] data = {"1", "2", "3"};
        List<String> convert = Convert.convert(new TypeReference<List<String>>() {
        }, data);
        assertArrayEquals(data, convert.toArray());
    }

    @Test
    public void testToUnicode() {
        String hello = "你好";
        String s = Convert.strToUnicode(hello);
        System.out.println(s);

        String s1 = Convert.unicodeToStr(s);
        assertEquals(hello, s1);
    }

    @Test
    public void testToHex() {
        String hello = "hello";
        String hex = Convert.toHex(hello, Charset.defaultCharset());
        System.out.println(hex);

        String s = Convert.hexToStr(hex, Charset.defaultCharset());
        assertEquals(hello, s);
    }

    @Test
    public void testToTime() {
        // 1s（秒） = 1000ms（毫秒）
        long l = Convert.convertTime(1000, TimeUnit.MILLISECONDS, TimeUnit.SECONDS);
        assertEquals(1, l);

        // 1ms（毫秒） = 1000μs（微妙）
        l = Convert.convertTime(1000, TimeUnit.MICROSECONDS, TimeUnit.MILLISECONDS);
        assertEquals(1, l);

        // 1μs（微妙） = 1000ns（纳秒）
        l = Convert.convertTime(1000, TimeUnit.NANOSECONDS, TimeUnit.MICROSECONDS);
        assertEquals(1, l);
    }

    @Test
    public void testToChineseCredit() {
        double credit = 1.21;
        String s = Convert.digitToChinese(credit);
        System.out.println(s);

        int f1 = Convert.chineseToNumber("一千零一十二");
        System.out.println(f1);
    }

}
