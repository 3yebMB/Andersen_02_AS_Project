package dev.m13d.twoactivities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity
import dev.m13d.twoactivities.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    private val resultIntent: Intent
        get() = Intent().apply {
            putExtra(EXTRA_REPLY, binding.editTextSecond.text.toString())
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val message = intent.getStringExtra(EXTRA_INPUT)
        binding.textMessage.text = message

        if (message != "")
            binding.textHeader.visibility = View.VISIBLE

        binding.buttonSecond.setOnClickListener { onSavePressed() }
    }

    private fun onSavePressed() {
        setResult(RESULT_OK, resultIntent)
        finish()
    }

    class Contract : ActivityResultContract<String, String>() {

        override fun createIntent(context: Context, input: String?) =
            Intent(context, SecondActivity::class.java).apply {
                putExtra(EXTRA_INPUT, input)
            }

        override fun parseResult(resultCode: Int, intent: Intent?): String? {
            if (intent == null) return null
            return intent.getStringExtra(EXTRA_REPLY)
        }
    }

    companion object {
        const val EXTRA_INPUT = "dev.m13d.twoactivities.extra.MESSAGE"
        const val EXTRA_REPLY = "dev.m13d.twoactivities.extra.REPLY"
    }
}
