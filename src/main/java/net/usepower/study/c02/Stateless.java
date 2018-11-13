package net.usepower.study.c02;

/**
 * 无状态对象一定是线程安全
 * @author liu yucheng
 * @date 2018/11/11
 */
public class Stateless {

    public int add(int a, int b) {
        return a + b;
    }
}
