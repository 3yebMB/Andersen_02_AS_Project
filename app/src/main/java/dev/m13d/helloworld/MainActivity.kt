package dev.m13d.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dev.m13d.helloworld.databinding.ActivityMainBinding
import android.widget.Toast

private val LOG_TAG = MainActivity::class.java.simpleName

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var mCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(LOG_TAG, "Hello World")
    }

    fun showToast(view: android.view.View) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE, Message("Hello!", mCount))
        startActivity(intent)
    }

    fun countUp(view: android.view.View) {
        mCount++
        binding.showCount.text = mCount.toString()
        binding.buttonReset?.isEnabled = mCount > 0
    }

    fun resetCount(view: android.view.View) {
        mCount = 0
        binding.showCount.text = mCount.toString()
        binding.buttonReset?.isEnabled = false
    }

    companion object {
        const val EXTRA_MESSAGE = "dev.m13d.helloworld.MESSAGE"
    }
}
