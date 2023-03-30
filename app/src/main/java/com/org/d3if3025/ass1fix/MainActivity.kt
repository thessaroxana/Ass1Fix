package com.org.d3if3025.ass1fix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.org.d3if3025.ass1fix.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: ArrayList<Food>
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.setHasFixedSize(true)

        foodList = ArrayList()
        foodList.add(Food(R.drawable.bakso , "Bakso"))
        foodList.add(Food(R.drawable.rendang , "Rendang"))
        foodList.add(Food(R.drawable.sate , "Sate"))
        foodList.add(Food(R.drawable.soto , "Soto"))
        foodList.add(Food(R.drawable.nasi_goreng , "Nasi Goreng"))

        adapter = FoodAdapter(foodList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.onItemClick = {
            val intent = Intent(this, DetailedActivity::class.java)
            intent.putExtra("food", it)
            startActivity(intent)
        }
    }
}