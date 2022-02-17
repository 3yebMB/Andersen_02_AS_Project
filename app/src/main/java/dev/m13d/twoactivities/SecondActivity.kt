package dev.m13d.twoactivities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import dev.m13d.twoactivities.databinding.ActivitySecondBinding

private val LOG_TAG = SecondActivity::class.java.simpleName

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    private fun resultIntent(id: Int): Intent {
        var res: String = ""
        when (id) {
            R.id.button1 -> res = binding.tvElement1.text.toString()
            R.id.button2 -> res = binding.tvElement2.text.toString()
            R.id.button3 -> res = binding.tvElement3.text.toString()
            R.id.button4 -> res = binding.tvElement4.text.toString()
            R.id.button5 -> res = binding.tvElement5.text.toString()
            R.id.button6 -> res = binding.tvElement6.text.toString()
            R.id.button7 -> res = binding.tvElement7.text.toString()
            R.id.button8 -> res = binding.tvElement8.text.toString()
            R.id.button9 -> res = binding.tvElement9.text.toString()
            R.id.button10 -> res = binding.tvElement10.text.toString()
        }
        return Intent().putExtra(EXTRA_STUFF, res)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }

    override fun onBackPressed() {
        setResult(RESULT_CANCELED, resultIntent(0))
        super.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    fun addProduct(view: View) {
        setResult(RESULT_OK, resultIntent(view.id))
        finish()
    }

    class Contract : ActivityResultContract<String, String>() {

        override fun createIntent(context: Context, input: String?) =
            Intent(context, SecondActivity::class.java).apply {
                putExtra(EXTRA_INPUT, input)
            }
        override fun parseResult(resultCode: Int, intent: Intent?): String? {
            if (intent == null) return null
            return intent.getStringExtra(EXTRA_STUFF)
        }
    }

    companion object {
        const val EXTRA_INPUT = "dev.m13d.twoactivities.extra.MESSAGE"
        const val EXTRA_STUFF = "dev.m13d.twoactivities.extra.STUFF"
    }
}
