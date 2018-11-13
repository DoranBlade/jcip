package net.usepower.study.c02;

import net.usepower.study.utils.ThreadRunner;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程安全对象保持原子一致性
 * @author liu yucheng
 * @date 2018/11/13
 */
public class CountingFactorizer {

    // 线程安全对象来管理状态
    private final AtomicLong count = new AtomicLong(0);

    public AtomicLong getCount() {
        return count;
    }

    public void count() {
        count.incrementAndGet();
    }

    public static void main(String[] args) {
        CountingFactorizer countingFactorizer = new CountingFactorizer();
        Runnable runnable = () -> {
          for (int i = 0; i < 100000; i++) {
              countingFactorizer.count();
              System.out.println(Thread.currentThread().getName() + "-count: " + countingFactorizer.getCount().get());
          }
        };
        ThreadRunner.of().start(runnable, false);
    }


}
