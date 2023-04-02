package com.org.d3if3025.ass1fix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.org.d3if3025.ass1fix.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var foodList: ArrayList<Food> = ArrayList()
    private lateinit var fAdapter: FoodAdapter
    lateinit var recyclerView: androidx.recyclerview.widget.RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerView

        foodList.shuffle()

        fAdapter = FoodAdapter(foodList)

        with(recyclerView) {
            adapter = FoodAdapter(initItems())
            setHasFixedSize(true)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)

        val menuItem = menu?.findItem(R.id.recyclerView)
        val searchView: SearchView = menuItem?.actionView as SearchView
        performSearch(searchView)

        return super.onCreateOptionsMenu(menu)
    }

    private fun performSearch(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                fAdapter.filter.filter(newText)
                return true
            }


        })
    }

    private fun initItems(): List<Food> {
        return listOf(
            Food("Bakso", R.drawable.bakso),
            Food("Nasi Goreng", R.drawable.nasi_goreng),
            Food("Rendang", R.drawable.rendang),
            Food("Sate", R.drawable.sate),
            Food("Soto", R.drawable.soto),
        )
    }
}