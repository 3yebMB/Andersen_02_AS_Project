package dev.m13d.twoactivities

import android.content.Intent
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

    fun returnReply(view: android.view.View) {
        val reply = binding.editTextSecond.text.toString()
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        finish()
    }

    companion object {
        const val EXTRA_REPLY = "dev.m13d.twoactivities.extra.REPLY"
    }
}
