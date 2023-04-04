package com.org.d3if3025.ass1fix

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.org.d3if3025.ass1fix.databinding.ActivityMainBinding
import java.util.Locale.filter

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
//    private var foodList = arrayListOf<Food>()
    private lateinit var fAdapter: FoodAdapter
    private lateinit var list: ArrayList<Food>

    @SuppressLint("NotifyDataChanged", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList()
        list.addAll(initItems())
        fAdapter = FoodAdapter(list)

        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = fAdapter
        }
        fAdapter.run { notifyDataSetChanged() }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)

        val menuItem = menu.findItem(R.id.search_action)
        val searchView = menuItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filter(newText)
                return false
            }
        })

        return true
    }

    private fun filter(text: String) {
        val filteredList = arrayListOf<Food>()

        for (item in list) {
            if (item.name.lowercase().contains(text.lowercase())){
                filteredList.add(item)
            }
        }

        if (filteredList.isEmpty()) {
            Toast.makeText(this, "No Data Found!", Toast.LENGTH_SHORT).show()
        } else {
            fAdapter.filtering(filteredList)
        }
    }



    private fun initItems(): ArrayList<Food> {
        return arrayListOf(
            Food("Bakso", R.drawable.bakso),
            Food("Nasi Goreng", R.drawable.nasi_goreng),
            Food("Rendang", R.drawable.rendang),
            Food("Sate", R.drawable.sate),
            Food("Soto", R.drawable.soto),
        )
    }
}