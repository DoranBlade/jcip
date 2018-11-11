package net.usepower.study.c01;

/**
 * 线程不安全版本
 * @author liu yucheng
 * @date 2018/11/11
 */
public class UnsafeSequence implements Sequence {

    private int sequence;

    @Override
    public int getNext() {
        return sequence++;
    }

}
