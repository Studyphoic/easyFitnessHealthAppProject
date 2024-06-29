package com.example.harp

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Observable
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.CheckResult
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.harp.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.jakewharton.rxbinding2.widget.RxTextView


@SuppressLint("CheckResult")
class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
//Auth
        auth = FirebaseAuth.getInstance()

//Username Validation
        val usernameStream = RxTextView.textChanges(binding.etSuUsername)
            .skipInitialValue()
            .map { username ->
                username.length < 6
            }
        usernameStream.subscribe{
            showTextMinimalAlert(it, "Username")
        }

//Email Validation
        val emailStream = RxTextView.textChanges(binding.etSuEmail)
            .skipInitialValue()
            .map { email ->
                !Patterns.EMAIL_ADDRESS.matcher(email).matches()
            }
        emailStream.subscribe{
            showEmailValidAlert(it)
        }

//Passwrod Validation
        val passwordStream = RxTextView.textChanges(binding.etSuPassword)
            .skipInitialValue()
            .map { password ->
                password.length < 6
            }
        passwordStream.subscribe{
            showTextMinimalAlert(it, "Password")
        }
//Passwrod Confirm Validation
        val passwordConfirmStream = io.reactivex.Observable.merge(
            RxTextView.textChanges(binding.etSuPassword)
                .skipInitialValue()
                .map { password ->
                    password.toString() != binding.etSuPassword.text.toString()
                },
            RxTextView.textChanges(binding.etSuReenterPassword)
                .skipInitialValue()
                .map { confirmPassword ->
                    confirmPassword.toString() != binding.etSuPassword.text.toString()
                })
        passwordConfirmStream.subscribe {
            showPasswordConfirmAlert(it)
        }


//Button enable true or false
        val invalidFieldStream = io.reactivex.Observable.combineLatest(
            usernameStream,
            emailStream,
            passwordStream,
            passwordConfirmStream,
            { usernameInvalid: Boolean, emailInvalid: Boolean, passwordInvalid: Boolean, passwordConfirmInvalid: Boolean ->
                !usernameInvalid && !emailInvalid && !passwordInvalid && !passwordConfirmInvalid
            })
        invalidFieldStream.subscribe{ isValid ->
            if (isValid){
                binding.btnSignup.isEnabled = true
                binding.btnSignup.backgroundTintList = ContextCompat.getColorStateList(this, R.color.primary_color)
            } else {
                binding.btnSignup.isEnabled = false
                binding.btnSignup.backgroundTintList = ContextCompat.getColorStateList(this, android.R.color.darker_gray)
            }
        }



//Click

        binding.btnSignup.setOnClickListener{
            val email = binding.etSuEmail.text.toString().trim()
            val password = binding.etSuPassword.text.toString().trim()
            registerUser(email,password)
        }
        binding.gotoSigninBtn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun showNameExistAlert(isNotValid: Boolean){
        binding.etSuUsername.error = if (isNotValid) "Username can't be empty" else null
    }

    private fun showTextMinimalAlert(isNotValid: Boolean, text: String){
        if (text == "Username")
            binding.etSuUsername.error = if (isNotValid) "$text must more than 6 letter!" else null
        else if (text == "Password")
            binding.etSuPassword.error = if (isNotValid) "$text must more than 8 letter!" else null
    }
    private fun showEmailValidAlert(isNotValid: Boolean){
        binding.etSuEmail.error = if (isNotValid) "Email is unvalid!" else null
    }

    private fun showPasswordConfirmAlert(isNotValid: Boolean){
        binding.etSuReenterPassword.error = if (isNotValid) "Password not match!" else null
    }
    private fun registerUser(email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful) {
                    startActivity(Intent(this, MainActivity::class.java))
                    Toast.makeText(this, "Sign Up successful!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
    }
}