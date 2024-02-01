package com.sciatta.xdo.lib.hutool.type;

import cn.hutool.core.net.url.UrlBuilder;
import cn.hutool.core.util.HashUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rain on 2024/1/28<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * StrTests
 */
public class StrTests {
    @Test
    public void testFormat() {
        String format = StrUtil.format("{}, my name is {}.", "hi", "rain");
        assertEquals("hi, my name is rain.", format);
    }

    @Test
    public void testHash() {
        int i = HashUtil.javaDefaultHash("hello");
        System.out.println(i);
    }

    @Test
    public void testURLCode() {
        String url = "https://192.168.8.100/hello.你好";
        String encode = URLUtil.encode(url);
        System.out.println(encode);

        assertEquals(url, URLUtil.decode(encode));
    }

    @Test
    public void testURLBuilder() {
        String url = UrlBuilder.of()
                .setScheme("https")
                .setHost("yxyyyt.github.io")
                .addPath("/aaa")
                .addPath("/bbb")
                .addQuery("user", "lucky")
                .addQuery("age", 5)
                .build();

        assertEquals("https://yxyyyt.github.io/aaa/bbb?user=lucky&age=5", url);

        UrlBuilder urlBuilder = UrlBuilder.ofHttp(url);

        assertEquals("https", urlBuilder.getScheme());
        assertEquals("yxyyyt.github.io", urlBuilder.getHost());
        assertEquals("bbb", urlBuilder.getPath().getSegment(1));
        assertEquals("lucky", urlBuilder.getQuery().get("user"));
    }
}
