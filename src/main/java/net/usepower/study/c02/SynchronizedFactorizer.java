package net.usepower.study.c02;

import net.usepower.study.utils.ThreadRunner;

/**
 *
 * @author liu yucheng
 * @date 2018/11/13
 */
public class SynchronizedFactorizer {

    private long number = 0;
    private long value = 0;

    public void compute() {
        // 内置锁保持多个操作的一致性
        synchronized (this) {
            number++;
            value = number * 2;
            checkAndPrint();
        }
    }

    public void checkAndPrint() {
        if (value / number != 2) {
            System.out.println(Thread.currentThread().getName() + "-number:" + number + ",-value:" + value);
        }
    }

    public static void main(String[] args) {
        SynchronizedFactorizer synchronizedFactorizer = new SynchronizedFactorizer();
        Runnable runnable = () -> {
            for (int i = 0; i < 100000; i++) {
                synchronizedFactorizer.compute();
            }
        };
        ThreadRunner.of().start(runnable, false);
    }

}
