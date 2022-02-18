package dev.m13d.twoactivities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEachIndexed
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dev.m13d.twoactivities.databinding.ActivityMainBinding

private val LOG_TAG = MainActivity::class.java.simpleName

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val setStuff = mutableSetOf<String>()
    private val stuffLauncher = registerForActivityResult(SecondActivity.Contract()) {
        setStuff.add(it)
            binding.root.forEachIndexed { index, view ->
                if (view !is TextView) return@forEachIndexed
                if (index == setStuff.size) return@registerForActivityResult
                if ((view as TextView).text == "") view.text = setStuff.elementAt(index)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        restoreState(savedInstanceState)

        setListeners()
    }

    private fun setListeners() {
        with(binding) {
            btnGoods.setOnClickListener { stuffLauncher.launch("") }
            btnMap.setOnClickListener { openLocation() }
        }
    }

    private fun openLocation() {
        val loc = binding.etMap.text.toString()
        val address = Uri.parse("geo:0,0?q=$loc")
        val intent = Intent(Intent.ACTION_VIEW, address)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "Can't handle this intent!", Toast.LENGTH_SHORT).show()
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }

    private fun restoreState(savedInstanceState: Bundle?) {
        val listStuff = savedInstanceState?.getStringArrayList("STUFF")
        binding.root.forEachIndexed { index: Int, view: View ->
            if (view is FloatingActionButton) return
            if (index == listStuff?.size || listStuff == null) return
            if ((view as TextView).text == "") view.text = listStuff.elementAt(index)
        }
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList("STUFF", ArrayList(setStuff))
        Log.e(LOG_TAG, setStuff.toString())
    }

}
