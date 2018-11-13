package net.usepower.study.c02;

import net.usepower.study.utils.ThreadRunner;

/**
 * 操作的原子性
 * @author liu yucheng
 * @date 2018/11/11
 */
public class UnSafeCount {

    private long count;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void count() {
        // 三个步骤：读取变量值，计算，写入变量值
        count++;
    }

    public static void main(String[] args) {
        UnSafeCount unSafeCount = new UnSafeCount();
        Runnable runnable = () -> {
            for (int i = 0; i < 100000; i++) {
                unSafeCount.count();
                System.out.println(Thread.currentThread().getName() + "-count: " + unSafeCount.getCount());
            }
        };
        ThreadRunner.of().start(runnable, false);
    }
}
