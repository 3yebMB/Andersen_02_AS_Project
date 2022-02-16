package dev.m13d.twoactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.content.Intent
import dev.m13d.twoactivities.databinding.ActivityMainBinding

private val LOG_TAG = MainActivity::class.java.simpleName
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun launchSecondActivity(view: android.view.View) {
        Log.d(LOG_TAG, "Button clicked!")
        val intent = Intent(this, SecondActivity::class.java)
        val message = binding.editTextMain.text.toString()
        intent.putExtra(Companion.EXTRA_MESSAGE, message)
        startActivity(intent)
    }

    companion object {
        const val EXTRA_MESSAGE = "dev.m13d.twoactivities.extra.MESSAGE"
    }
}
