package com.example.harp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.harp.databinding.Viewdetailbf1Binding

class ViewDetailbf1 : AppCompatActivity() {

    private lateinit var binding: Viewdetailbf1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Viewdetailbf1Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}