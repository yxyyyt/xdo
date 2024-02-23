package com.sciatta.xdo.jdk.concurrency;

/**
 * Created by Rain on 2024/2/23<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * WaitExample
 */
public class WaitExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        int i = 0;
                        while (true) {
                            System.out.println("start waiting " + ++i);
                            wait(2000); // 阻塞同时释放锁；即使没有线程notify，超时会重新去抢锁
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        t.start();
        t.join();
    }
}
