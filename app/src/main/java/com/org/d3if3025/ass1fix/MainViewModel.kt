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
        data.value = initItems()
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            try {
                val result = FoodApi.service.getHewan()
                Log.d("MainViewModel", "Success: $result")
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
            }
        }
    }
    private fun initItems(): ArrayList<Food> {
        return arrayListOf(
            Food(
                "Bakso", R.drawable.bakso, "bahan-bahan :\n" +
                        "        1 butir telur\n" +
                        "        1 sdm garam\n" +
                        "        1 sdt lada bubuk\n" +
                        "        1/2 sdt bubuk pala\n" +
                        "        1/2 sdt kaldu sapi bubuk\n" +
                        "        100 gram tepung kanji\n" +
                        "        3 siung bawang putih,\n" +
                        "        haluskan 500 gram daging sapi\n" +
                        "        Air secukupnya untuk merebus"
            ),
            Food(
                "Nasi Goreng",
                R.drawable.nasi_goreng,
                "Cara membuat: Cuci udang lalu potong-potong\n" +
                        "Potong-potong ayam panggang.\n" +
                        "Panaskan minyak dalam wajan, masukkan udang dan ayam.\n" +
                        "Masak sebentar hingga matang. Tiriskan.\n" +
                        "Panaskan sedikit minyak dalam wajan.\n" +
                        "Masukkan telur, aduk hingga bergumpal dan matang.\n" +
                        "Masukkan nasi, aduk-aduk hingga terurai.\n" +
                        "Tambahkan udang dan ayam panggang. Aduk rata.\n" +
                        "Bumbu dengan garam, kaldu ayam bubuk dan kecap.\n" +
                        "Aduk-aduk hingga rata lalu angkat.\n" +
                        "\n" +
                        "Baca artikel detikfood, \"Resep Cara Membuat Nasi Goreng Rumahan yang Gurih Enak\" selengkapnya https://food.detik.com/info-kuliner/d-4649204/resep-cara-membuat-nasi-goreng-rumahan-yang-gurih-enak.\n" +
                        "\n" +
                        "Download Apps Detikcom Sekarang https://apps.detik.com/detik/"
            ),
            Food(
                "Rendang", R.drawable.rendang, "Cuci udang lalu potong-potong\n" +
                        "Potong-potong ayam panggang.\n" +
                        "Panaskan minyak dalam wajan, masukkan udang dan ayam.\n" +
                        "Masak sebentar hingga matang. Tiriskan.\n" +
                        "Panaskan sedikit minyak dalam wajan.\n" +
                        "Masukkan telur, aduk hingga bergumpal dan matang.\n" +
                        "Masukkan nasi, aduk-aduk hingga terurai.\n" +
                        "Tambahkan udang dan ayam panggang. Aduk rata.\n" +
                        "Bumbu dengan garam, kaldu ayam bubuk dan kecap.\n" +
                        "Aduk-aduk hingga rata lalu angkat.\n" +
                        "\n" +
                        "Baca artikel detikfood, \"Resep Cara Membuat Nasi Goreng Rumahan yang Gurih Enak\" selengkapnya https://food.detik.com/info-kuliner/d-4649204/resep-cara-membuat-nasi-goreng-rumahan-yang-gurih-enak.\n" +
                        "\n" +
                        "Download Apps Detikcom Sekarang https://apps.detik.com/detik/"
            ),
            Food(
                "Sate", R.drawable.sate, "Cuci udang lalu potong-potong\n" +
                        "Potong-potong ayam panggang.\n" +
                        "Panaskan minyak dalam wajan, masukkan udang dan ayam.\n" +
                        "Masak sebentar hingga matang. Tiriskan.\n" +
                        "Panaskan sedikit minyak dalam wajan.\n" +
                        "Masukkan telur, aduk hingga bergumpal dan matang.\n" +
                        "Masukkan nasi, aduk-aduk hingga terurai.\n" +
                        "Tambahkan udang dan ayam panggang. Aduk rata.\n" +
                        "Bumbu dengan garam, kaldu ayam bubuk dan kecap.\n" +
                        "Aduk-aduk hingga rata lalu angkat.\n" +
                        "\n" +
                        "Baca artikel detikfood, \"Resep Cara Membuat Nasi Goreng Rumahan yang Gurih Enak\" selengkapnya https://food.detik.com/info-kuliner/d-4649204/resep-cara-membuat-nasi-goreng-rumahan-yang-gurih-enak.\n" +
                        "\n" +
                        "Download Apps Detikcom Sekarang https://apps.detik.com/detik/"
            ),
            Food(
                "Soto", R.drawable.soto, "Cuci udang lalu potong-potong\n" +
                        "Potong-potong ayam panggang.\n" +
                        "Panaskan minyak dalam wajan, masukkan udang dan ayam.\n" +
                        "Masak sebentar hingga matang. Tiriskan.\n" +
                        "Panaskan sedikit minyak dalam wajan.\n" +
                        "Masukkan telur, aduk hingga bergumpal dan matang.\n" +
                        "Masukkan nasi, aduk-aduk hingga terurai.\n" +
                        "Tambahkan udang dan ayam panggang. Aduk rata.\n" +
                        "Bumbu dengan garam, kaldu ayam bubuk dan kecap.\n" +
                        "Aduk-aduk hingga rata lalu angkat.\n" +
                        "\n" +
                        "Baca artikel detikfood, \"Resep Cara Membuat Nasi Goreng Rumahan yang Gurih Enak\" selengkapnya https://food.detik.com/info-kuliner/d-4649204/resep-cara-membuat-nasi-goreng-rumahan-yang-gurih-enak.\n" +
                        "\n" +
                        "Download Apps Detikcom Sekarang https://apps.detik.com/detik/"
            ),
        )
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