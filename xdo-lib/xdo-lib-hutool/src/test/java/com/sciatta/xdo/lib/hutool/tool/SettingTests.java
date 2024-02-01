package com.sciatta.xdo.lib.hutool.tool;

import cn.hutool.setting.Setting;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rain on 2024/1/30<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * SettingTests
 */
public class SettingTests {
    @Test
    public void testSetting() {
        Setting setting = new Setting("example.setting");
        setting.autoLoad(true);

        Integer i = setting.getInt("test", "app");
        assertEquals(Integer.valueOf(1), i);

        String str = setting.getStr("name", "app", null);
        assertEquals("hi", str);

        i = setting.getInt("global");
        assertEquals(Integer.valueOf(100), i);
    }
}
