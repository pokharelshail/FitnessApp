package com.example.fitness

import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Html.*
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class PostActivity : AppCompatActivity() {

    private lateinit var boldButton: Button
    private lateinit var italicsButton: Button
    private lateinit var underlineButton: Button
    private lateinit var postText: EditText
    private lateinit var clearButton: Button
    private lateinit var leftButton: Button
    private lateinit var centerButton: Button
    private lateinit var rightButton: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        boldButton = findViewById(R.id.boldButton)
        italicsButton= findViewById(R.id.italicsButton)
        underlineButton = findViewById(R.id.underLineButton)
        postText = findViewById(R.id.postText)
        clearButton = findViewById(R.id.clearButton)
        leftButton = findViewById(R.id.leftButton)
        rightButton= findViewById(R.id.rightButton)
        centerButton = findViewById(R.id.centerButton)


        boldButton.setOnClickListener{
            val spannableString = SpannableStringBuilder(postText.text)


            // If already bolded remove bold
            var bolded = false
            val sss = spannableString.getSpans(
                postText.selectionStart, postText.selectionEnd,
                StyleSpan::class.java
            )
            for (i in sss.indices) {
                if (sss[i].style == Typeface.BOLD) {
                    bolded = true
                    spannableString.removeSpan(sss[i])
                }
            }
            if (bolded){
                postText.text= spannableString
            }

            // If un bolded then bold string
            if (!bolded) {
                val ss = spannableString.getSpans(postText.selectionStart, postText.selectionEnd, Annotation::class.java)
                spannableString.setSpan(
                    StyleSpan(Typeface.BOLD),
                    postText.selectionStart,
                    postText.selectionEnd,
                    Spannable.SPAN_EXCLUSIVE_INCLUSIVE
                )
                postText.text = spannableString
            }


        }
        italicsButton.setOnClickListener{
            val spannableString = SpannableStringBuilder(postText.text)
            var italicized = false

            // If already italicized remove italics
            val sss = spannableString.getSpans(
                postText.selectionStart, postText.selectionEnd,
                StyleSpan::class.java
            )

            for (i in sss.indices) {
                if (sss[i].style == Typeface.ITALIC) {
                    italicized = true
                    spannableString.removeSpan(sss[i])
                }
            }
            if (italicized){
                postText.text= spannableString
            }
            // If not italicized then italicize
            if (!italicized) {
                spannableString.setSpan(
                    StyleSpan(Typeface.ITALIC),
                    postText.selectionStart,
                    postText.selectionEnd,
                    Spannable.SPAN_EXCLUSIVE_INCLUSIVE
                )
                postText.text = spannableString
            }
        }
        underlineButton.setOnClickListener{
                val spannableString = SpannableStringBuilder(postText.text)
                var underlined = false

               if (!underlined) {
                    spannableString.setSpan(
                        UnderlineSpan(),
                        postText.selectionStart,
                        postText.selectionEnd,
                        Spannable.SPAN_EXCLUSIVE_INCLUSIVE
                    )
                    postText.text = spannableString
                }
        }

        clearButton.setOnClickListener{
            val str = postText.text.toString()
            postText.setText(str)
        }
        leftButton.setOnClickListener(){
            postText.gravity = Gravity.LEFT
        }
        centerButton.setOnClickListener(){
            postText.gravity = Gravity.CENTER_HORIZONTAL
        }
        rightButton.setOnClickListener(){
            postText.gravity = Gravity.RIGHT
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
               var htmlstr = Html.toHtml(postText.text,TO_HTML_PARAGRAPH_LINES_CONSECUTIVE)
                Log.i("PostActivity",htmlstr)
            }

        }



    }
}