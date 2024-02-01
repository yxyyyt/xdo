package com.sciatta.xdo.lib.hutool.tool;

import cn.hutool.core.lang.Console;
import cn.hutool.http.HttpUtil;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by Rain on 2024/1/31<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * HttpTests
 */
public class HttpTests {
    @Test
    public void testGet() {
        String s = HttpUtil.get("https://www.baidu.com");
        Console.log(s);
    }

    @Test
    public void testPost() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("city", "北京");

        String s = HttpUtil.post("https://www.baidu.com", paramMap);
        Console.log(s);
    }
}
