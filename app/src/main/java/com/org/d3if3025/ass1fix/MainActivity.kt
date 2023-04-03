package com.org.d3if3025.ass1fix

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.org.d3if3025.ass1fix.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var foodList = arrayListOf<Food>()
    private lateinit var fAdapter: FoodAdapter
    private val list = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        foodList.addAll(initItems())
        fAdapter = FoodAdapter(foodList)

        for (i in foodList.indices) {
            list.add(foodList[i].name)
        }

        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = fAdapter
            setHasFixedSize(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)

        val menuItem = menu.findItem(R.id.search_action)
        val searchView = menuItem.actionView as SearchView
        performSearch(searchView)

        return super.onCreateOptionsMenu(menu)
    }

    private fun performSearch(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                for (i in list.indices) {
                    Log.wtf("AAAA", "onQueryTextSubmit: ${list[i]}")

                    if (list[i].contains(query!!)) {
                        fAdapter.filter.filter(query)
                    }
                }

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                fAdapter.filter.filter(newText)
                return true
            }
        })
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