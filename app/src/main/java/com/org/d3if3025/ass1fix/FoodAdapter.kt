package com.org.d3if3025.ass1fix

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.org.d3if3025.ass1fix.databinding.ItemBinding

class FoodAdapter(val list:ArrayList<Food>)
    : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>(){

    var onItemClick : ((Food) -> Unit)? = null

        class FoodViewHolder(val itemBinding : ItemBinding):RecyclerView.ViewHolder(itemBinding.root) {

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.itemBinding.imageView.setImageResource(list[position].image)
        holder.itemBinding.textView.text = list[position].name

        holder.itemView.setOnClickListener {
            var invoke = onItemClick?.invoke(Food)
        }
    }
}
