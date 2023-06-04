package com.example.mobile_programming_41

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun displayToast(message: String?) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    fun showBash(view: View?){
        displayToast(getString(R.string.bash))
    }
    fun showRubber(view: View?){
        displayToast(getString(R.string.rubber))
    }
    fun showWp(view: View?){
        displayToast(getString(R.string.wp))
    }
}