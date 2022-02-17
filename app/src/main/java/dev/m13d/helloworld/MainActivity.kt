package dev.m13d.helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.m13d.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private var mCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonIncrease.setOnClickListener {
            mCount++
            binding.tvCounter.text = mCount.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("COUNTER", mCount)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
            binding.tvCounter.text = savedInstanceState.getInt("COUNTER", 0).toString()
    }
}
