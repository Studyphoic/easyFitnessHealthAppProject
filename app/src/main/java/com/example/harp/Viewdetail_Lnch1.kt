package com.example.harp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.harp.databinding.ViewdetailLnch1Binding

class Viewdetail_Lnch1 : AppCompatActivity() {

    private lateinit var binding: ViewdetailLnch1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ViewdetailLnch1Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}