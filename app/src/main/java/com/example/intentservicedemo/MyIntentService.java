package com.example.intentservicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import androidx.annotation.Nullable;

public class MyIntentService extends IntentService {
    public static final String TAG = "MyIntentService";


    public MyIntentService(String name) {
        super(name);
        Log.i(TAG, "MyIntentService Constructor: " + Thread.currentThread().getName());
    }

    public MyIntentService() {
        super("Hello");
        Log.i(TAG, "MyIntentService Constructor: " + Thread.currentThread().getName());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: " + Thread.currentThread().getName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG, "onHandleIntent: " + Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: " + Thread.currentThread().getName());
        EventBus.getDefault().post(new Pojo());
    }
}
