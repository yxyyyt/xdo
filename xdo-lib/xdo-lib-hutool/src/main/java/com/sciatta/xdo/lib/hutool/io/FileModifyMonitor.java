package com.sciatta.xdo.lib.hutool.io;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.watch.SimpleWatcher;
import cn.hutool.core.io.watch.WatchMonitor;
import cn.hutool.core.io.watch.Watcher;
import cn.hutool.core.io.watch.watchers.DelayWatcher;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.WatchEvent;

/**
 * Created by Rain on 2024/1/27<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * FileModifyMonitor
 */
public class FileModifyMonitor {
    public static void main(String[] args) {
        File file = FileUtil.file("example.properties");
        if (!file.exists()) {
            System.err.println("example.properties not exists");
        }

        Watcher watcher = new SimpleWatcher() {
            @Override
            public void onModify(WatchEvent<?> event, Path currentPath) {
                System.out.println("Modify: " + currentPath + "->" + event.context());
            }
        };

        // 关注所有事件
        WatchMonitor.createAll(file, new DelayWatcher(watcher, 2000)).start();
    }
}
