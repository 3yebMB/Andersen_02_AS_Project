package dev.m13d.helloworld

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.m13d.helloworld.databinding.ActivityMainBinding

private val LOG_TAG = MainActivity::class.java.simpleName
private const val DEFAULT_BUTTON_COLOR = "#FF6200EE"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var mCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonReset.setBackgroundColor(Color.GRAY)

    }

    fun showToast(view: android.view.View) {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
    }

    fun countUp(view: android.view.View) {
        mCount++
        with(binding) {
            if (mCount == 1) buttonCount.setBackgroundColor(Color.GREEN)
            showCount.text = mCount.toString()
            buttonReset.isEnabled = mCount > 0
            buttonReset.setBackgroundColor(Color.MAGENTA)
        }
    }

    fun resetCount(view: android.view.View) {
        mCount = 0
        with(binding) {
            showCount.text = mCount.toString()
            buttonReset.setBackgroundColor(Color.GRAY)
            buttonCount.setBackgroundColor(Color.parseColor(DEFAULT_BUTTON_COLOR))
        }
    }

}
