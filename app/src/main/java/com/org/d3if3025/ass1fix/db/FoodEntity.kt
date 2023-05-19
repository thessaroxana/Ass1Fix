package com.org.d3if3025.ass1fix.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food")
class FoodEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var name: String,
    var image: Int,
    var resep: String
    )
