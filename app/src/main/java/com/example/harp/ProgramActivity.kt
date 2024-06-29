package com.example.harp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.harp.databinding.ActivityProgramBinding

class ProgramActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProgramBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgramBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHomeInProgram.setOnClickListener{
            startActivity(Intent(this, HomeActivity::class.java))
        }
        binding.btnProfInProgram.setOnClickListener{
            startActivity(Intent(this, ProfileActivity::class.java))
        }
        binding.playVid1Img.setOnClickListener{
            startActivity(Intent(this, VideoView_activity::class.java))
        }
    }
}