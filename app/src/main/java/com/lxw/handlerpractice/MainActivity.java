package com.lxw.handlerpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lxw.handler.Handler;
import com.lxw.handler.Looper;
import com.lxw.handler.Message;

public class MainActivity extends AppCompatActivity {
//    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Looper.preare();
        System.out.println(Looper.MyLooper());
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message message) {
//                super.handleMessage(message);
                System.out.println(message.what);
                System.out.println("handleMessage: "+Thread.currentThread().getName());
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread: "+Thread.currentThread().getName());
                handler.sendMessage(new Message(2,new Object()));

            }
        }).start();
        Looper.loop();

//        Handler handler = new Handler(new Handler.Callback() {
//            @Override
//            public boolean handleMessage(Message msg) {
//                return false;
//            }
//        });
//        MessageQueue.IdleHandler
    }
}
