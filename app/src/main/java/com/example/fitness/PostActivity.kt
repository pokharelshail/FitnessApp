package com.example.fitness

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.text.style.TypefaceSpan
import android.text.style.UnderlineSpan
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.text.getSpans


class PostActivity : AppCompatActivity() {

    private lateinit var boldButton: Button
    private  lateinit var italicsButton: Button
    private lateinit var underlineButton: Button
    private  lateinit var postText: EditText
    private lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        boldButton = findViewById(R.id.boldButton)
        italicsButton= findViewById(R.id.italicsButton)
        underlineButton = findViewById(R.id.underLineButton)
        postText = findViewById(R.id.postText)
        clearButton = findViewById(R.id.clearButton)

        boldButton.setOnClickListener{
            val spannableString = SpannableStringBuilder(postText.text)
            var start = postText.selectionStart;
            var end = postText.selectionStart;

            val ss = spannableString.getSpans(start,end, Annotation::class.java)
            spannableString.setSpan(StyleSpan(Typeface.BOLD),
                postText.selectionStart,postText.selectionEnd, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
            postText.text = spannableString
        }
        italicsButton.setOnClickListener{
            val spannableString = SpannableStringBuilder(postText.text)
            spannableString.setSpan(StyleSpan(Typeface.ITALIC),
                postText.selectionStart,postText.selectionEnd, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
            postText.text = spannableString
        }
        underlineButton.setOnClickListener{
                val spannableString = SpannableStringBuilder(postText.text)
                spannableString.setSpan(UnderlineSpan(),
                    postText.selectionStart,postText.selectionEnd, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
                postText.text = spannableString

        }

        clearButton.setOnClickListener{
            val str = postText.text.toString()
            postText.setText(str)
        }

    }
}