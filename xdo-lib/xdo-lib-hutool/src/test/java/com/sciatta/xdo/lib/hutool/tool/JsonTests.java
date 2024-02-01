package com.sciatta.xdo.lib.hutool.tool;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rain on 2024/1/31<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * JsonTests
 */
public class JsonTests {
    @Test
    public void testJsonObject() {
        User user = new User("lucky");

        JSONObject jsonObject = JSONUtil.parseObj(user);
        System.out.println(jsonObject);
        assertEquals("lucky", jsonObject.getStr("name"));

        User beanFromJsonObject = JSONUtil.toBean(jsonObject, User.class);
        assertEquals("lucky", beanFromJsonObject.getName());

        User beanFromJsonStr = JSONUtil.toBean(jsonObject.toString(), User.class);
        assertEquals("lucky", beanFromJsonStr.getName());
    }

    @Test
    public void testJsonArray() {
        ArrayList<User> users = CollUtil.newArrayList(new User("a"), new User("b"));

        JSONArray jsonArray = JSONUtil.parseArray(users);
        System.out.println(jsonArray);

        List<User> list = JSONUtil.toList(jsonArray, User.class);
        assertEquals(2, list.size());
    }

    @Test
    public void testInherit() {

        Nodes nodes = new Nodes();
        nodes.getNodes().add(new File("file"));
        nodes.getNodes().add(new Directory("directory"));

        assertEquals(2,nodes.getNodes().size());

        JSONObject jsonObject = JSONUtil.parseObj(nodes);
        System.out.println(jsonObject);

        Nodes bean = JSONUtil.toBean(jsonObject, Nodes.class);
        List<Node> list = bean.getNodes();
        Console.log(list);

        // json序列化抽象类型，反序列化时具体类型丢失。是否支持注册抽象类型，或者把具体类型序列化到json中。
        // assertTrue(list.get(0) instanceof File);
        // assertTrue(list.get(1) instanceof Directory);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class User {
        private String name;
    }

    @Data
    private static class Nodes {
        private List<Node> nodes = new ArrayList<>();
    }

    @AllArgsConstructor
    @Data
    private static class Node {
        protected String name;
    }

    private static class File extends Node {

        public File(String name) {
            super(name);
        }
    }

    private static class Directory extends Node {

        public Directory(String name) {
            super(name);
        }
    }
}
