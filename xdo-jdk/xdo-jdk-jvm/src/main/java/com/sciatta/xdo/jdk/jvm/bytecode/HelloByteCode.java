package com.sciatta.xdo.jdk.jvm.bytecode;

/**
 * Created by Rain on 2024/2/13<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * HelloByteCode
 */
public class HelloByteCode {
    public void sayHi() {
        System.out.println("Hello, byte code!");
    }

    public static void main(String[] args) {
        HelloByteCode byteCode = new HelloByteCode();
        byteCode.sayHi();
    }
}
