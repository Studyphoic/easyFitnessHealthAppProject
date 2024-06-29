package com.example.harp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.harp.databinding.ActivityForgotPasswordBinding
import com.google.firebase.auth.FirebaseAuth
import com.jakewharton.rxbinding2.widget.RxTextView

@SuppressLint("CheckResult")
class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
  //Auth
        auth = FirebaseAuth.getInstance()
//Email Validation
        val emailStream = RxTextView.textChanges(binding.etFpwEmail)
            .skipInitialValue()
            .map { email ->
                !Patterns.EMAIL_ADDRESS.matcher(email).matches()
            }
        emailStream.subscribe{
            showEmailValidAlert(it)
        }

        binding.btnSendEmailFpw.setOnClickListener{
            val email = binding.etFpwEmail.text.toString().trim()

            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(this) { reset ->
                    if (reset.isSuccessful){
                        Intent(this, MainActivity::class.java).also{
                            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(it)
                            Toast.makeText(this, "Check your email to reset password", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this, reset.exception?.message, Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
    private fun showEmailValidAlert(isNotValid: Boolean) {
        if (isNotValid){
            binding.etFpwEmail.error = "Unvalid Email"
            binding.btnSendEmailFpw.isEnabled = false
            binding.btnSendEmailFpw.backgroundTintList = ContextCompat.getColorStateList(this, android.R.color.darker_gray)
        } else {
            binding.etFpwEmail.error = null
            binding.btnSendEmailFpw.isEnabled = true
            binding.btnSendEmailFpw.backgroundTintList = ContextCompat.getColorStateList(this, R.color.primary_color)
        }
    }
}