package net.usepower.study.c01;

/**
 * 线程安全版本
 * @author liu yucheng
 * @date 2018/11/11
 */
public class SafeSequence implements Sequence {
    private int sequence;

    @Override
    public synchronized int getNext() {
        return sequence++;
    }

}
