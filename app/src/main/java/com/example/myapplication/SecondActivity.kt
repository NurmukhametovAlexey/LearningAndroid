package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.random.Random

class SecondActivity : AppCompatActivity() {

    companion object {
        const val TOTAL_COUNT = "total_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        showRandomNumber()
    }

    fun showRandomNumber() {
        val count = intent.getIntExtra(TOTAL_COUNT, 0)
        val randomInt = when {
            count > 0 -> Random.nextInt(count + 1)
            else -> 0
        }
        findViewById<TextView>(R.id.randomNumber).text = randomInt.toString()
        findViewById<TextView>(R.id.randomNumberDescription).text = getString(R.string.random_number_description, count)
    }
}