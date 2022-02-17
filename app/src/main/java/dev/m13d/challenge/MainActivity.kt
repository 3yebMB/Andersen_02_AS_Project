package dev.m13d.challenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import dev.m13d.challenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickButton(view: android.view.View) {
        var res = 0
        when(view.id) {
            R.id.button1 -> res = R.string.passage_1
            R.id.button2 -> res = R.string.passage_2
            R.id.button3 -> res = R.string.passage_3
        }
        launchSecondActivity(res)
    }

    private fun launchSecondActivity(res: Int) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE, res)
        startActivity(intent)
    }

    companion object {
        const val EXTRA_MESSAGE = "dev.m13d.challenge.MESSAGE"
    }
}
