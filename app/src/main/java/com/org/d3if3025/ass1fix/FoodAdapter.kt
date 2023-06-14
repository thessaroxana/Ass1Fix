package com.org.d3if3025.ass1fix

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.org.d3if3025.ass1fix.databinding.ItemResepBinding
import com.org.d3if3025.ass1fix.network.FoodApi

class FoodAdapter(private var foodList: List<Food>) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ItemResepBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Food) {
            Glide.with(binding.ivCategoryThumb.context)
                .load(FoodApi.getFoodUrl(food.image))
                .error(R.drawable.baseline_broken_image_24)
                .into(binding.ivCategoryThumb)

            with(binding) {
                tvCategoryName.text = food.name
                tvCategoryNameResep.text = food.resep
            }
        }
    }

    private val data = mutableListOf<Food>()
    fun updateData(newData: List<Food>) { data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(foodList[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemResepBinding.inflate(
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