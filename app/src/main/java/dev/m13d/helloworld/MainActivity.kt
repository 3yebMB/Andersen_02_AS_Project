package dev.m13d.helloworld

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.m13d.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var mCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()
    }

    private fun setListeners() {
        with(binding) {
            openWebsiteButton.setOnClickListener { openWebsite() }
            openLocationButton.setOnClickListener { openLocation() }
            shareTextButton.setOnClickListener { shareText() }
        }
    }

    private fun openWebsite() {
        val url = binding.websiteEdittext.text.toString()
        val webpage = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)

        startIntent(intent)
    }

    private fun openLocation() {
        val loc = binding.locationEdittext.text.toString()
        val address = Uri.parse("geo:0,0?q=$loc")
        val intent = Intent(Intent.ACTION_VIEW, address)

        startIntent(intent)
    }

    private fun startIntent(intent: Intent) {
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "Can't handle this intent!", Toast.LENGTH_SHORT).show()
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }

    private fun shareText() {
        val txt = binding.shareEdittext.text.toString()
        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, txt)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(intent, null)
        startActivity(shareIntent)
    }
}
