package com.org.d3if3025.ass1fix

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.org.d3if3025.ass1fix.db.FoodDao

class HistoryViewModelFactory (
    private val db: FoodDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HistoriViewModel::class.java)) {
            return HistoriViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
