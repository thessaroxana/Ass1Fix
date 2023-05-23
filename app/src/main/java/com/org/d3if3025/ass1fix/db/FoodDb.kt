package com.org.d3if3025.ass1fix.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FoodEntity::class], version = 2, exportSchema = false)

abstract class FoodDb : RoomDatabase() {

    abstract val dao: FoodDao
    companion object {
        @Volatile
        private var INSTANCE: FoodDb? = null
        fun getInstance(context: Context): FoodDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FoodDb::class.java,
                        "Food.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}