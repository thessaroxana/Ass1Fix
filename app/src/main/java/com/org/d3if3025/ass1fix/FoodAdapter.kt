package com.org.d3if3025.ass1fix

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.org.d3if3025.ass1fix.databinding.ItemBinding

class FoodAdapter(private var foodList: ArrayList<Food>) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
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

    override fun getItemCount() = foodList.size

    @SuppressLint("NotifyDataSetChanged")
    fun filtering(filter: ArrayList<Food>) {
        foodList = filter
        notifyDataSetChanged()
    }
}