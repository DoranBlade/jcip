package net.usepower.study.c03;

/**
 * 可见性
 * 通过volatile保持可见性
 * @author liu yucheng
 * @date 2018/11/13
 */
public class VolatileVisible {

    private volatile static boolean ready = true;

    private static boolean getReady() {
        return VolatileVisible.ready;
    }

    private static void setReady(boolean ready) {
        VolatileVisible.ready = ready;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable readRunner = () -> {
            while (VolatileVisible.getReady()) {
                // 只有cpu一直被占用时，才会让变量的同步不及时
//                    System.out.println(ready);
            }
        };
        new Thread(readRunner).start();
        Thread.sleep(1000);
        new Thread(() -> VolatileVisible.setReady(false)).start();
    }
}
