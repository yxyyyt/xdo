package com.sciatta.xdo.lib.hutool.tool;

import cn.hutool.core.lang.Validator;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rain on 2024/1/28<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * ValidateTests
 */
public class ValidatorTests {
    @Test
    public void testValidate() {
        boolean ans = Validator.isEmail("123");
        assertFalse(ans);
    }
}
