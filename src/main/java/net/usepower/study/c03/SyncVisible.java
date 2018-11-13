package net.usepower.study.c03;

/**
 * 可见性
 * 通过Synchronized同步变量，保持可见性
 * @author liu yucheng
 * @date 2018/11/13
 */
public class SyncVisible {

    private static boolean ready = true;

    private synchronized static boolean getReady() {
        return SyncVisible.ready;
    }

    private static void setReady(boolean ready) {
        SyncVisible.ready = ready;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable readRunner = () -> {
            while (SyncVisible.getReady()) {
                // 只有cpu一直被占用时，才会让变量的同步不及时
//                    System.out.println(ready);
            }
        };
        new Thread(readRunner).start();
        Thread.sleep(1000);
        new Thread(() -> SyncVisible.setReady(false)).start();
    }
}
