package com.sciatta.xdo.lib.hutool.io;

import cn.hutool.core.io.resource.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Rain on 2024/1/28<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * ResourceTests
 */
public class ResourceTests {
    public static void main(String[] args) throws IOException {
        ClassPathResource resource = new ClassPathResource("example.properties");
        Properties prop = new Properties();
        prop.load(resource.getStream());
        System.out.println(prop);
    }
}
