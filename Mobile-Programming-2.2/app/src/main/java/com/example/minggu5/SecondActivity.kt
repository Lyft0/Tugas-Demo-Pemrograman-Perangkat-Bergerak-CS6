package com.example.minggu5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private val LOG_TAG = SecondActivity::class.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val messageTextView = findViewById<TextView>(R.id.textView)

        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        messageTextView.text = message

//        if (isVisible) {
//            messageTextView.setVisibility(view.VISIBLE)
//            messageTextView.text = it.getString("view_text")
//        }

    }

    override fun onStart(){
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    override fun onPause(){
        super.onPause()
        Log.d(LOG_TAG, "onPause")
    }

    override fun onRestart(){
        super.onRestart()
        Log.d(LOG_TAG, "onRestart")
    }

    override fun onResume(){
        super.onResume()
        Log.d(LOG_TAG, "onResume")
    }

    override fun onStop(){
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
        Log.d(LOG_TAG, "your session is ended")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val messageTextView = findViewById<TextView>(R.id.textView)
        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        messageTextView.text = message
    }
}