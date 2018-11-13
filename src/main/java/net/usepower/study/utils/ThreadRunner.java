package net.usepower.study.utils;

/**
 * @author liu yucheng
 * @date 2018/11/11
 */
public class ThreadRunner {

    private final static String THREAD_PREFIX = "thread-";
    private int count;

    private ThreadRunner() {
        this.count = 10;
    }

    private ThreadRunner(int count) {
        this.count = count;
    }

    public static ThreadRunner of() {
        return new ThreadRunner();
    }

    public static ThreadRunner of(int count) {
        return new ThreadRunner(count);
    }

    public void start(Runnable runnable, boolean singleFlag) {
        if (singleFlag) {
            runnable.run();
            return;
        }
        for (int i = 0; i< count; i++) {
            new Thread(runnable, THREAD_PREFIX + i).start();
        }
    }

}
