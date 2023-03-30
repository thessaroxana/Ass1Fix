package com.org.d3if3025.ass1fix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.org.d3if3025.ass1fix.databinding.ActivityDetailedBinding

class DetailedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val food = intent.getParcelableExtra<Food>("food")
        if (food !=null) {
            val textView : TextView = findViewById(R.id.detailedActivityTv)
            val imageView : ImageView = findViewById(R.id.detailedActivityIv)

            textView.text = food.name
            imageView.setImageResource(food.image)

        }


    }
}