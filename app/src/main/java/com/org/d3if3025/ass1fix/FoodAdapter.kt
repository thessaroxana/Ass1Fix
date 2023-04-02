package com.org.d3if3025.ass1fix

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.Filter
import android.widget.Filterable


class FoodAdapter( private var foodList: List<Food>) : RecyclerView.Adapter<FoodAdapter.ViewHolder>(), Filterable {

    class ViewHolder (private val binding : ListItemBinding ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Food) = with(binding) {
            name.text = food.name
            imageView.setImageResource(food.image)
        }
    }

    var filteredList: List<Food> = foodList

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(filteredList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {

            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()

                filteredList = when {
                    charString.isEmpty() -> foodList
                    else -> {
                        val internalFilteredList: MutableList<Food> = mutableListOf()
                        for (data in foodList) {
                            if (data.name.contains(charString, ignoreCase = true)) {
                                internalFilteredList.add(data)
                            }
                        }
                        internalFilteredList
                    }
                }

                val filteredResults = FilterResults()
                filteredResults.values = filteredList
                return filteredResults
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                filteredList = p1?.values as List<Food>
                notifyDataSetChanged()
            }

        }
    }

}