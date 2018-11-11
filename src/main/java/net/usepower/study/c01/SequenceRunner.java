package net.usepower.study.c01;

/**
 * @author liu yucheng
 * @date 2018/11/11
 */
public class SequenceRunner {

    public static void main(String[] args) {
        boolean singleFlag = false;
        Sequence sequence = getSequence(false);
        if (singleFlag) {
            singleInvoke(sequence);
        } else {
            multiInvoke(sequence);
        }
    }

    private static Sequence getSequence(boolean safeSequenceFlag) {
        return safeSequenceFlag ? new SafeSequence() : new UnsafeSequence();
    }

    /**
     * 单线程
     * @param sequence 序列对象
     */
    private static void singleInvoke(Sequence sequence) {
        invoke(sequence);
    }

    /**
     * 多线程
     * @param sequence 序列对象
     */
    private static void multiInvoke(Sequence sequence) {
        Runnable runnable = () -> invoke(sequence);
        for (int i = 0; i< 10; i++) {
            new Thread(runnable).start();
        }
    }

    private static void invoke(Sequence sequence) {
        for (int i = 0; i < 100000; i++) {
            System.out.println("sequence: " + sequence.getNext());
        }
    }
}
