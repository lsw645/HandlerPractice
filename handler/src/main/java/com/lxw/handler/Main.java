package com.lxw.handler;

public class Main {
    public static void main(String[] args) {
        Looper.preare();
        Looper.loop();
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message message) {
                super.handleMessage(message);
                System.out.println(message.what+"");
            }
        };

        handler.sendMessage(new Message(1, new Object()));
    }
}
