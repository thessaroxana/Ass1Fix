package com.org.d3if3025.ass1fix.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FoodDao {

    @Insert
    fun insert(food: FoodEntity)

    @Query("SELECT * FROM food ORDER BY id DESC")
    fun getLastFood(): LiveData<List<FoodEntity>>

    @Query("DELETE FROM food")
    fun clearData()
}