package com.org.d3if3025.ass1fix

import android.util.Log
import androidx.lifecycle.*
import com.org.d3if3025.ass1fix.db.FoodDao
import com.org.d3if3025.ass1fix.network.FoodApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (db: FoodDao) :  ViewModel() {

    private var data = MutableLiveData<ArrayList<Food>>()

    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            try {
                data.postValue(FoodApi.service.getFood())
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
            }
        }
    }

    fun getData() : LiveData<ArrayList<Food>> = data
}



class MainViewModelFactory(
    private val db: FoodDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class") }
}