package com.example.harp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.harp.databinding.ViewdetailLnch2Binding

class ViewDetail_Lnch2 : AppCompatActivity() {

    private lateinit var binding: ViewdetailLnch2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ViewdetailLnch2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}