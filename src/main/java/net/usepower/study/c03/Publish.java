package net.usepower.study.c03;

import net.usepower.study.utils.ThreadRunner;

/**
 * 发布和逸出
 * @author liu yucheng
 * @date 2018/11/13
 */
public class Publish {

    // 共有静态变量属于发布
    public static Integer value1 = 0;
    private static Integer value2 = 0;

    // 作为返回值发布
    public static Integer pub() {
        return value2;
    }

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 100000; i++) {
                // 发布的变量多线程环境下的使用方易造成安全性
                Publish.value1++;
                System.out.println(Thread.currentThread().getName() + "-count: " + Publish.value1);
            }
        };
        ThreadRunner.of().start(runnable, false);
    }

}
