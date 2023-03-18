package com.android.demo.serivce

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.util.Random

class MyService : Service() {
    var randomNumber:Int? =null
    override fun onBind(intent: Intent?): IBinder? {
        Log.e(MainActivity.TAG, "onBind() called")
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread.sleep(1000)
        Log.e(MainActivity.TAG, "onStartCommand() called ${intent?.getStringExtra("myKey")?:"NO DATA"}")
        for (i in 1..10){
            Thread.sleep(1000)
            randomNumber = Random().nextInt(100)
            Log.e(MainActivity.TAG, "RandomNumber: $randomNumber")
        }
        stopSelf()
        return START_STICKY
    }

    override fun onDestroy() {
        Log.e(MainActivity.TAG, "onDestroy() called")
        super.onDestroy()
    }
}