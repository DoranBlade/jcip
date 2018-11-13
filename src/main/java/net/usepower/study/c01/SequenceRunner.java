package net.usepower.study.c01;

import net.usepower.study.utils.ThreadRunner;

/**
 * @author liu yucheng
 * @date 2018/11/11
 */
public class SequenceRunner {

    public static void main(String[] args) {
        Sequence sequence = getSequence(false);
        ThreadRunner.of(10).start(() -> invoke(sequence), false);
    }

    private static Sequence getSequence(boolean safeSequenceFlag) {
        return safeSequenceFlag ? new SafeSequence() : new UnsafeSequence();
    }

    private static void invoke(Sequence sequence) {
        for (int i = 0; i < 100000; i++) {
            System.out.println(Thread.currentThread().getName() + "-sequence: " + sequence.getNext());
        }
    }
}
