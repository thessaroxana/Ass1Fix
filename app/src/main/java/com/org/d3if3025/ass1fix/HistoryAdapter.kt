package com.org.d3if3025.ass1fix

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.org.d3if3025.ass1fix.databinding.ItemHistoryBinding
import com.org.d3if3025.ass1fix.db.FoodEntity
import java.text.SimpleDateFormat
import java.util.*

class HistoryAdapter : ListAdapter<FoodEntity, HistoryAdapter.ViewHolder>(DIFF_CALLBACK) {
        companion object {
            private val DIFF_CALLBACK =
                object : DiffUtil.ItemCallback<FoodEntity>() {
                    override fun areItemsTheSame(
                        oldItem: FoodEntity, newItem: FoodEntity
                    ): Boolean {
                        return oldItem.id == newItem.id
                    }

                    @SuppressLint("DiffUtilEquals")
                    override fun areContentsTheSame(
                        oldItem: FoodEntity,
                        newItem: FoodEntity
                    ): Boolean {
                        return oldItem == newItem
                    }
                }
        }

        class ViewHolder(private val binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root) {
            private val dateFormatter = SimpleDateFormat("dd MMMM yyyy", Locale("id", "ID"))

            @SuppressLint("StringFormatInvalid")
            fun bind(item: FoodEntity) {
                binding.tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
                binding.textView.text = binding.root.context.getString(
                    R.string.data_x, item.name
                )
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemHistoryBinding.inflate(inflater, parent, false)
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val user = getItem(position)
            holder.bind(user)
        }
    }
