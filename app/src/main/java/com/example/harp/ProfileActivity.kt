package com.example.harp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.harp.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnLogout.setOnClickListener{
            auth.signOut()
            Intent(this, MainActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
                Toast.makeText(this, "You're Logged Out", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnHomepageInProf.setOnClickListener{
            startActivity(Intent(this, HomeActivity::class.java))
        }
        binding.btnProgramInProf.setOnClickListener{
            startActivity(Intent(this, ProgramActivity::class.java))
        }
    }
}