package net.usepower.study.c03;

import net.usepower.study.utils.ThreadRunner;

/**
 * volatile仅能保证可见性，不能保证自增操作的原子性
 * @author liu yucheng
 * @date 2018/11/13
 */
public class VolatileUnSafeCount {

    private volatile long count;

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
        VolatileUnSafeCount volatileUnSafeCount = new VolatileUnSafeCount();
        Runnable runnable = () -> {
            for (int i = 0; i < 100000; i++) {
                volatileUnSafeCount.count();
                System.out.println(Thread.currentThread().getName() + "-count: " + volatileUnSafeCount.getCount());
            }
        };
        ThreadRunner.of().start(runnable, false);
    }
}
