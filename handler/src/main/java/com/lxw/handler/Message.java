package com.lxw.handler;

/**
 * <pre>
 *     author : lxw
 *     e-mail : lsw@tairunmh.com
 *     time   : 2018/07/16
 *     desc   :
 * </pre>
 */
public class Message {
    public Message next;
    public int what;
    public Object object;
    public Handler target;

    public Message(int what, Object object) {
        this.what = what;
        this.object = object;
    }

    public void recycle() {
        what = 0;
        next = null;
        object = null;
        target = null;
    }
}
