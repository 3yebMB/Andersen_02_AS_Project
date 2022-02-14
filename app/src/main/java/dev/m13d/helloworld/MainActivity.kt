package dev.m13d.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dev.m13d.helloworld.databinding.ActivityMainBinding
import android.widget.Toast

private val LOG_TAG = MainActivity::class.java.simpleName

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private var mCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(LOG_TAG, "Hello World")
    }

    fun showToast(view: android.view.View) {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
    }

    fun countUp(view: android.view.View) {
        mCount++
        binding.showCount.text = mCount.toString()
    }
}
