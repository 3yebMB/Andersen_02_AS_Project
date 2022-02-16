package dev.m13d.twoactivities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.m13d.twoactivities.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        binding.textMessage.text = message
    }
}
