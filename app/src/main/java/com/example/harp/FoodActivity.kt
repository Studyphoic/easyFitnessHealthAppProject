    package com.example.harp

    import android.content.Intent
    import android.os.Bundle
    import androidx.appcompat.app.AppCompatActivity
    import androidx.core.view.ViewCompat
    import androidx.core.view.WindowInsetsCompat
    import com.example.harp.databinding.ActivityFoodBinding


    class FoodActivity : AppCompatActivity() {

        private lateinit var binding: ActivityFoodBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityFoodBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.foodBackBtn.setOnClickListener{
                startActivity(Intent(this, HomeActivity::class.java))
            }

            binding.btnBrkfst1.setOnClickListener{
                startActivity(Intent(this, ViewDetailbf1::class.java))
            }

            binding.btnLunch1.setOnClickListener{
                startActivity(Intent(this, Viewdetail_Lnch1::class.java))
            }
            binding.btnLunch2.setOnClickListener{
                startActivity(Intent(this, ViewDetail_Lnch2::class.java))
            }

        }
    }
