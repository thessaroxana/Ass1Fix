package com.org.d3if3025.ass1fix

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.org.d3if3025.ass1fix.db.FoodDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoriViewModel(private val db: FoodDao) : ViewModel() {
    val data = db.getLastFood()
    fun hapusData() = viewModelScope.launch { withContext(Dispatchers.IO) {
        db.clearData() }
    }
}