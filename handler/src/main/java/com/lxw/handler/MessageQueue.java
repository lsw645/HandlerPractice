package com.lxw.handler;

/**
 * <pre>
 *     author : lxw
 *     e-mail : lsw@tairunmh.com
 *     time   : 2018/07/16
 *     desc   :
 * </pre>
 */
public class MessageQueue {

    private Message current;
    private boolean isQuiet = false;

    public Message next() {
        synchronized (this) {
            Message p = current;
            for (; ; ) {
                if (isQuiet) {
                    return null;
                }


                if (p != null) {
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            current = current.next;
            return p;
        }

    }


//    public void enqueue(Message msg) {
//        synchronized (this) {
//            if (isQuiet) {
//                return;
//            }
//            Message p = current;
//            if (p == null) {
//                p = msg;
//            }
//            for (; ; ) {
//                p = p.next;
//                if (p.next == null) {
//                    break;
//                }
//            }
//        }
//        p.next = msg;
//        notify();
//    }
//}

    public void enqueue(Message msg) {
        synchronized (this) {
            if (isQuiet) {
                return;
            }
            Message p = current;
            if (p == null) {
//                p = msg;
                current = msg;
            } else {
                Message prev;
                for (; ; ) {
                    prev = p;
                    p = p.next;
                    if (null == p) {
                        break;
                    }
                }
                prev.next = msg;
//                while (p.next != null) {
//                    p = p.next;
//                }
//                p.next = msg;
            }
            notify();
        }
    }

    public void quiet() {
        isQuiet = true;

    }

}
