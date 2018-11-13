package net.usepower.study.c02;

/**
 * 内置锁可重入
 * @author liu yucheng
 * @date 2018/11/13
 */
public class Widget {

    private static int count = 0;

    public synchronized void invoke() {
        System.out.println("widget invoke");
        count++;
        if (count < 2) {
            OtherWidget.of(new Widget()).invoke();
        }
    }

    public static void main(String[] args) {
        new Widget().invoke();
    }
}

class OtherWidget {

    private Widget widget;

    private OtherWidget(Widget widget) {
        this.widget = widget;
    }

    public static OtherWidget of(Widget first) {
        return new OtherWidget(first);
    }

    public synchronized void invoke() {
        System.out.println("OtherWidget invoke");
        widget.invoke();
    }
}
