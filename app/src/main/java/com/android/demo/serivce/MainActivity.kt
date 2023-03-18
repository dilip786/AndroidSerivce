package com.android.demo.serivce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startMyService()
    }

    private fun startMyService(){
        Log.e(TAG,"startMyService() called in Activity")
        val intent = Intent(this, MyService::class.java)
        intent.putExtra("myKey", "myValue")
        startService(intent)
        Thread.sleep(2000)
        stopService(Intent(this, MyService::class.java))
    }

    companion object {
        const val TAG = "ServiceDemo"
    }
}