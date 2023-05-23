package com.org.d3if3025.ass1fix

import androidx.lifecycle.*
import com.org.d3if3025.ass1fix.db.FoodDao
import com.org.d3if3025.ass1fix.db.FoodEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InputRequestViewModel(private val db: FoodDao) : ViewModel() {
    private val foodLiveData = MutableLiveData<FoodEntity>()

    fun getData(resep: String) {
        val dataResep = FoodEntity(name = resep)
        foodLiveData.value = dataResep

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataResep)
            }
        }
    }

    fun getLastFood(): LiveData<FoodEntity?> = foodLiveData
}
class InputRequestViewModelFactory(
    private val db: FoodDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InputRequestViewModel::class.java)) {
            return InputRequestViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class") }
}
