package com.sciatta.xdo.jdk.jvm.strpool;

import cn.hutool.core.lang.Assert;
import lombok.Data;

/**
 * Created by Rain on 2024/2/15<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * StrPool
 */
public class StrPool {
    public static void main(String[] args) {
        // 双引号括起来的字符串置入字符串常量池
        String str1 = "hello str";
        String str2 = "hello str";
        Assert.isTrue(str1 == str2);

        // new字符串实例不会置入字符串常量池
        String str3 = new String("hello str");
        Assert.isFalse(str1 == str3);

        // 运算符+两边是字符串常量，结果仍是字符串常量；如果一个是new字符串实例，则结果不是字符串常量
        String str4 = "hello" + " " + "str";
        Assert.isTrue(str1 == str4);

        String str5 = "hello" + " " + new String("str");
        Assert.isFalse(str5 == str1);

        // 可以通过 String.intern() 方法将字符串置入字符串常量池，返回值在常量池中，原str3仍是堆中的对象
        String str6 = str3.intern();
        Assert.isTrue(str6 == str1);
        Assert.isFalse(str3 == str1);
    }
}
