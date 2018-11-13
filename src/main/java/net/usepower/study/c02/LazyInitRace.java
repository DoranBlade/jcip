package net.usepower.study.c02;

/**
 * 竞态条件
 * @author liu yucheng
 * @date 2018/11/11
 */
public class LazyInitRace {

    private static LazyInitRace instance = null;

    public LazyInitRace getInstance() {
        // 该检查-修改-写入操作不能保证原子性
        if (instance == null) {
            instance = new LazyInitRace();
        }
        return instance;
    }
}
