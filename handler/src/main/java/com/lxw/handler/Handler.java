package com.lxw.handler;

/**
 * <pre>
 *     author : lxw
 *     e-mail : lsw@tairunmh.com
 *     time   : 2018/07/16
 *     desc   :
 * </pre>
 */
public class Handler {
    private MessageQueue mQueue;
    private Looper mLooper;

    public Handler() {
        mLooper = Looper.MyLooper();
        System.out.println("Handler："+ mLooper);
        mQueue = mLooper.mQueue;
    }

    public void handleMessage(Message message) {

    }

    public void sendMessage(Message message) {
        message.target = this;
        mQueue.enqueue(message);
    }


}
