package net.usepower.study.c02;

import net.usepower.study.utils.ThreadRunner;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 多个线程安全对象操作的一致性
 * @author liu yucheng
 * @date 2018/11/13
 */
public class UnSafeCachingFactorizer {

    private AtomicLong lastNumber = new AtomicLong(0);
    private AtomicLong lastValue = new AtomicLong(0);

    public void compute() {
        // 两个线程安全对象操作也不能保证操作的一致性
        long number = lastNumber.incrementAndGet();
        lastValue.set(number * 2);
        checkAndPrint();
    }

    public void checkAndPrint() {
        long number = lastNumber.get();
        long value = lastValue.get();
        if (value / number != 2) {
            System.out.println(Thread.currentThread().getName() + "-number:" + number + ",-value:" + value);
        }
    }

    public static void main(String[] args) {
        UnSafeCachingFactorizer unSafeCachingFactorizer = new UnSafeCachingFactorizer();
        Runnable runnable = () -> {
            for (int i = 0; i < 100000; i++) {
                unSafeCachingFactorizer.compute();
            }
        };
        ThreadRunner.of().start(runnable, false);
    }
}
