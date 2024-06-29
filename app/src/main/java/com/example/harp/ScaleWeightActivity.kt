package com.example.harp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.harp.databinding.ActivityScaleWeightBinding

class ScaleWeightActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScaleWeightBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScaleWeightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.scaleweightBackBtn.setOnClickListener{
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}