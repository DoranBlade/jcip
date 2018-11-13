package net.usepower.study.c03;

/**
 * 可见性
 * 变量没有及时同步
 * @author liu yucheng
 * @date 2018/11/13
 */
public class NoVisible {

    private static boolean ready = true;

    private static boolean getReady() {
        return NoVisible.ready;
    }

    private static void setReady(boolean ready) {
        NoVisible.ready = ready;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable readRunner = () -> {
            while (NoVisible.getReady()) {
                // 只有cpu一直被占用时，才会让变量的同步不及时
//                    System.out.println(ready);
            }
        };
        new Thread(readRunner).start();
        Thread.sleep(1000);
        new Thread(() -> NoVisible.setReady(false)).start();
    }

}
