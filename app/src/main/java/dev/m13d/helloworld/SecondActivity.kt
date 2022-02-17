package dev.m13d.helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.m13d.helloworld.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val res = intent.getParcelableExtra<Message>(MainActivity.EXTRA_MESSAGE)
        binding.titleView.text = res?.title
        binding.messageView.text = res?.counter.toString()
    }
}
