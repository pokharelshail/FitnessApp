package com.example.fitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginButton = findViewById(R.id.loginButton)
        loginButton.setOnClickListener{
            val toast = Toast.makeText(this,"Login", Toast.LENGTH_SHORT)
            toast.show()
            val change = Intent(this, PostActivity::class.java)
            startActivity(change)

        }
    }








}