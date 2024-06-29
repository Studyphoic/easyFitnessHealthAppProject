package com.example.harp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.harp.databinding.ActivityWaterBinding

class WaterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWaterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWaterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.waterBackBtn.setOnClickListener{
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}