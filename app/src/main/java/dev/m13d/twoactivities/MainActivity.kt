package dev.m13d.twoactivities

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import dev.m13d.twoactivities.databinding.ActivityMainBinding

private val LOG_TAG = MainActivity::class.java.simpleName

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val sendMessage = registerForActivityResult(SecondActivity.Contract()) {
        if (it != null && it != "") {
            with(binding) {
                textHeaderReply.visibility = View.VISIBLE
                textMessageReply.visibility = View.VISIBLE
                textMessageReply.text = it
            }
        } else {
            with(binding) {
                textHeaderReply.visibility = View.INVISIBLE
                textMessageReply.visibility = View.INVISIBLE
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonMain.setOnClickListener { launchSecondActivity() }
    }

    private fun launchSecondActivity() {
        Log.d(LOG_TAG, "Button clicked!")
        sendMessage.launch(binding.editTextMain.text.toString())
    }

}
