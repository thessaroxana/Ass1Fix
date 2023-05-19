package com.org.d3if3025.ass1fix.db

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query

interface FoodDao {

    @Insert
    fun insert(bmi: FoodEntity)

    @Query("SELECT * FROM food ORDER BY id DESC")
    fun getLastFood(): LiveData<List<FoodEntity>>
}