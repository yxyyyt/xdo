package com.sciatta.xdo.lib.hutool.tool;

import cn.hutool.core.convert.NumberWithFormat;
import cn.hutool.core.lang.Console;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTHeader;
import cn.hutool.jwt.JWTUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Rain on 2024/2/1<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * JwtTests
 */
public class JwtTests {
    @Test
    public void testVerify() {
        byte[] key = "1234567890".getBytes();

        Map<String, Object> map = new HashMap<String, Object>() {
            private static final long serialVersionUID = 1L;

            {
                put("uid", Integer.parseInt("123"));
                put("expire_time", System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15);
            }
        };

        String token = JWTUtil.createToken(map, key);
        Console.log(token);
        String str = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjEyMywiZXhwaXJlX3RpbWUiOjE3MDgwNTE5NzM1NzJ9.DSGER_4oaSMECA1R75JTsHjK7eSVfAeq6HrFogcV73Q";

        JWT jwt = JWTUtil.parseToken(str);
        NumberWithFormat uid = (NumberWithFormat) jwt.getPayload("uid");
        assertEquals(123, uid.intValue());

        Object header = jwt.getHeader(JWTHeader.TYPE);
        assertEquals("JWT", header);

        boolean verify = JWTUtil.verify(str, key);
        assertTrue(verify);
    }
}
