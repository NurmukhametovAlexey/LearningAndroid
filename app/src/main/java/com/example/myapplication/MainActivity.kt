package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.concurrent.ThreadLocalRandom

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.countButton).setOnClickListener(::countMe)
        findViewById<Button>(R.id.toastButton).setOnClickListener(::toastMe)
        findViewById<Button>(R.id.randomButton).setOnClickListener(::randomMe)
    }

    private fun toastMe(view: View) {
        val myToast = Toast.makeText(this, "Hello, Toast!", Toast.LENGTH_SHORT)
        myToast.show()
    }

    private fun countMe(view: View) {
        val countTextView = findViewById<TextView>(R.id.countTextView)
        val countString = countTextView.text.toString()
        val count = Integer.parseInt(countString) + 1
        countTextView.text = count.toString()
    }

    private fun randomMe(view: View) {
        val countTextView = findViewById<TextView>(R.id.countTextView)
        val count = Integer.parseInt(countTextView.text.toString())

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(SecondActivity.TOTAL_COUNT, count)
        startActivity(intent)
    }
}