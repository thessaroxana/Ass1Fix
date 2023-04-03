package com.org.d3if3025.ass1fix

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.org.d3if3025.ass1fix.databinding.ItemBinding

class FoodAdapter(private var foodList: ArrayList<Food>) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>(), Filterable {

    class ViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Food) {
            Glide.with(binding.root)
                .load(food.image)
                .into(binding.imageView)

            with(binding) {
                textView.text = food.name
                //            imageView.setImageResource(food.image)
            }
        }
    }

    var filteredList: ArrayList<Food> = foodList

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(foodList[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = filteredList.size

    override fun getFilter(): Filter {
        return object : Filter() {

            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()

                filteredList = when {
                    charString.isEmpty() -> foodList
                    else -> {
                        val internalFilteredList = arrayListOf<Food>()
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
                filteredList = p1?.values as ArrayList<Food>
            }

        }
    }

}