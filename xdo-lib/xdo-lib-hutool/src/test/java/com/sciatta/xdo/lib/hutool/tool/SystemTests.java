package com.sciatta.xdo.lib.hutool.tool;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.RuntimeUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.system.SystemUtil;
import cn.hutool.system.UserInfo;
import cn.hutool.system.oshi.CpuInfo;
import cn.hutool.system.oshi.OshiUtil;
import org.junit.Test;
import oshi.hardware.GlobalMemory;

/**
 * Created by Rain on 2024/1/31<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * SystemTests
 */
public class SystemTests {
    @Test
    public void testExecuteCommand() {
        String s = RuntimeUtil.execForStr("ipconfig");
        System.out.println(s);
    }

    @Test
    public void testShutdownHook() {
        RuntimeUtil.addShutdownHook(() -> System.out.println("game over!"));
    }

    @Test
    public void testMemoryInfo() {
        String str = StrUtil.format("jvm free {}m, jvm max {}m, jvm usable {}m, jvm total {}m",
                RuntimeUtil.getFreeMemory() / 1000 / 1000,
                RuntimeUtil.getMaxMemory() / 1000 / 1000,
                RuntimeUtil.getUsableMemory() / 1000 / 1000,
                RuntimeUtil.getTotalMemory() / 1000 / 1000);
        System.out.println(str);
    }

    @Test
    public void testUserInfo() {
        UserInfo userInfo = SystemUtil.getUserInfo();
        Console.log(userInfo);
    }

    @Test
    public void testUserDir() {
        // 项目根目录
        Console.log(SystemUtil.get(SystemUtil.USER_DIR));

        // OS用户目录
        Console.log(SystemUtil.get(SystemUtil.USER_HOME));

        // 项目类路径 target\test-classes、target\classes
        Console.log(SystemUtil.get(SystemUtil.CLASS_PATH));
    }

    @Test
    public void testOshi() {
        Console.log("========================================");
        CpuInfo cpuInfo = OshiUtil.getCpuInfo();
        Console.log(cpuInfo);

        Console.log("========================================");
        GlobalMemory memory = OshiUtil.getMemory();
        Console.log(memory);
    }
}
