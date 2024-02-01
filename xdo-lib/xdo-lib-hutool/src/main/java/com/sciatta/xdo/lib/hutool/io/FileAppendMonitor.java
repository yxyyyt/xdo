package com.sciatta.xdo.lib.hutool.io;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.Tailer;

/**
 * Created by Rain on 2024/1/28<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * FileAppendMonitor
 */
public class FileAppendMonitor {
    public static void main(String[] args) {
        Tailer tailer = new Tailer(FileUtil.file("example.properties"),
                Tailer.CONSOLE_HANDLER,
                2);
        tailer.start();
    }
}
