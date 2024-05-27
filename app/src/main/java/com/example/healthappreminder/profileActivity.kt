package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var editText : EditText
    lateinit var editText2 : EditText
    lateinit var editText3 : EditText
    lateinit var editText4 : EditText
    lateinit var btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.`profile_main.xml`)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets



        }
        editText = findViewById(R.id.full_name)
        editText2 = findViewById(R.id.profile_username)
        editText3 = findViewById(R.id.profile_Age)
        editText4 = findViewById(R.id.profile_email)
        btn  = findViewById(R.id.editbutton)
        btn.setOnClickListener(this)

        }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}
}
