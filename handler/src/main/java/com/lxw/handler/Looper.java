package com.lxw.handler;

/**
 * <pre>
 *     author : lxw
 *     e-mail : lsw@tairunmh.com
 *     time   : 2018/07/16
 *     desc   :
 * </pre>
 */
public class Looper {
    private static ThreadLocal<Looper> sThreadLocal = new ThreadLocal<>();
    public MessageQueue mQueue;

    private Looper() {
        mQueue = new MessageQueue();
    }

    public static Looper MyLooper() {
        return sThreadLocal.get();
    }

    public static void preare() {
        sThreadLocal.set(new Looper());
    }

    public static void loop() {
        Looper looper = MyLooper();
        System.out.println("loop "+looper);
        if (looper == null) {
            throw new NullPointerException("you shoule use Looper preare first");
        }

        MessageQueue queue = looper.mQueue;
        for (; ; ) {
            Message next = queue.next();
//            if (next == null) {
//                break;
//            }
            next.target.handleMessage(next);

        }
    }

}
