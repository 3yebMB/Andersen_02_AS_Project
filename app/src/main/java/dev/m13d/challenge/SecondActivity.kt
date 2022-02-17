package dev.m13d.challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.m13d.challenge.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val res = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0)
        binding.textView.text = getString(res)
    }
}
