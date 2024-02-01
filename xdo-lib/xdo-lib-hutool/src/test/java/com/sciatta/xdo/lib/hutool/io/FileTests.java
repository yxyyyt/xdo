package com.sciatta.xdo.lib.hutool.io;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileNameUtil;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.File;

/**
 * Created by Rain on 2024/1/28<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * FileTests
 */
public class FileTests {
    @Test
    public void testFileName() {
        File file = FileUtil.file("example.properties");
        String mainName = FileNameUtil.mainName(file);
        String extName = FileNameUtil.extName(file);

        assertEquals("example", mainName);
        assertEquals("properties", extName);
    }
}
