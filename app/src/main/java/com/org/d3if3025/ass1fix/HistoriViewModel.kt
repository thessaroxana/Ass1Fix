package com.org.d3if3025.ass1fix

import androidx.lifecycle.ViewModel
import com.org.d3if3025.ass1fix.db.FoodDao

class HistoriViewModel (db: FoodDao) : ViewModel() {
    val data = db.getLastFood()
}