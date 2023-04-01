package com.org.d3if3025.ass1fix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.org.d3if3025.ass1fix.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: ArrayList<Food>
    private lateinit var binding: ActivityMainBinding
    private lateinit var tempArrayList: ArrayList<Food>
    private lateinit var menu :Menu
    var newArrayList = arrayListOf<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.setHasFixedSize(true)

        foodList = ArrayList()
        tempArrayList = arrayListOf()

        foodList.add(Food(R.drawable.bakso, "Bakso"))
        foodList.add(Food(R.drawable.rendang, "Rendang"))
        foodList.add(Food(R.drawable.sate, "Sate"))
        foodList.add(Food(R.drawable.soto, "Soto"))
        foodList.add(Food(R.drawable.nasi_goreng, "Nasi Goreng"))
        foodList.add(Food(R.drawable.bakso, "Bakso"))
        foodList.add(Food(R.drawable.rendang, "Rendang"))
        foodList.add(Food(R.drawable.sate, "Sate"))
        foodList.add(Food(R.drawable.soto, "Soto"))
        foodList.add(Food(R.drawable.nasi_goreng, "Nasi Goreng"))

        getUserdata(foodList)

        adapter = FoodAdapter(foodList) {
            val intent = Intent(this, DetailedActivity::class.java)
            intent.putExtra("food", it)
            startActivity(intent)
        }
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_item, menu)
        val item = menu?.findItem(R.id.search_action)

        val searchView = item?.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                tempArrayList.clear()
                val searchText = newText!!.lowercase(Locale.getDefault())
                if (searchText.isNotEmpty()) {
                    newArrayList.forEach {
                        if (it.name!!.lowercase().contains(searchText.lowercase())) {
                            tempArrayList.add(it)
                        }
                    }
//                    binding.recyclerView.adapter!!.notifyDataSetChanged()
                } else {
                    tempArrayList.clear()
                    tempArrayList.addAll(newArrayList)
//                    binding.recyclerView.adapter!!.notifyDataSetChanged()
//                    binding.recyclerView.adapter?.notifyDataSetChanged()
                }

                return false
            }
        })

        return super.onCreateOptionsMenu(menu)

    }

    private fun getUserdata(list: ArrayList<Food>) {
        for (i in list) {
            val food = Food(i.image, i.name)
            val newArrayList = arrayListOf<Food>()
            newArrayList.add(food)
        }

        tempArrayList.addAll(newArrayList)
        val adapter = FoodAdapter(newArrayList) {it ->

        }
        val swipegesture = object : SwipeGesture(this) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder):

                    val from_pos = viewHolder.adapterPosition
                    val to_pos = target.adapterPosition

            Collections.swap(newArrayList, from_pos, to_pos)
            adapter.notifyItemMoved(from_pos, to_pos)

            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            when(direction) {
                ItemTouchHelper.LEFT ->{
                    adapter.deleteItem(viewHolder.adapterPosition)
                }
            }
        }
    }
}