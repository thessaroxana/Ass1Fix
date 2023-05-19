//package com.org.d3if3025.ass1fix
//
//import android.annotation.SuppressLint
//import android.os.Bundle
//import android.util.Log
//import android.view.Menu
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.appcompat.widget.SearchView
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.org.d3if3025.ass1fix.databinding.ActivityMainBinding
//import java.util.Locale.filter
//
//class MainActivity2 : AppCompatActivity() {
//
//    private lateinit var binding: ActivityMainBinding
//
//    //    private var foodList = arrayListOf<Food>()
//    private lateinit var fAdapter: FoodAdapter
//    private lateinit var list: ArrayList<Food>
//
//    @SuppressLint("NotifyDataChanged", "NotifyDataSetChanged")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        list = ArrayList()
//        list.addAll(initItems())
//        fAdapter = FoodAdapter(list)
//
//        with(binding.recyclerView) {
//            layoutManager = LinearLayoutManager(this@MainActivity2)
//            adapter = fAdapter
//        }
//        fAdapter.run { notifyDataSetChanged() }
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.menu_item, menu)
//
//        val menuItem = menu.findItem(R.id.search_action)
//        val searchView = menuItem.actionView as SearchView
//
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String): Boolean {
//                filter(newText)
//                return false
//            }
//        })
//
//        return true
//    }
//
//    private fun filter(text: String) {
//        val filteredList = arrayListOf<Food>()
//
//        for (item in list) {
//            if (item.name.lowercase().contains(text.lowercase())) {
//                filteredList.add(item)
//            }
//        }
//
//        if (filteredList.isEmpty()) {
//            Toast.makeText(this, "No Data Found!", Toast.LENGTH_SHORT).show()
//        } else {
//            fAdapter.filtering(filteredList)
//        }
//    }
//
//
//    private fun initItems(): ArrayList<Food> {
//        return arrayListOf(
//            Food(
//                "Bakso", R.drawable.bakso, "bahan-bahan :\n" +
//                        "        1 butir telur\n" +
//                        "        1 sdm garam\n" +
//                        "        1 sdt lada bubuk\n" +
//                        "        1/2 sdt bubuk pala\n" +
//                        "        1/2 sdt kaldu sapi bubuk\n" +
//                        "        100 gram tepung kanji\n" +
//                        "        3 siung bawang putih,\n" +
//                        "        haluskan 500 gram daging sapi\n" +
//                        "        Air secukupnya untuk merebus"
//            ),
//            Food(
//                "Nasi Goreng",
//                R.drawable.nasi_goreng,
//                "Cara membuat: Cuci udang lalu potong-potong\n" +
//                        "Potong-potong ayam panggang.\n" +
//                        "Panaskan minyak dalam wajan, masukkan udang dan ayam.\n" +
//                        "Masak sebentar hingga matang. Tiriskan.\n" +
//                        "Panaskan sedikit minyak dalam wajan.\n" +
//                        "Masukkan telur, aduk hingga bergumpal dan matang.\n" +
//                        "Masukkan nasi, aduk-aduk hingga terurai.\n" +
//                        "Tambahkan udang dan ayam panggang. Aduk rata.\n" +
//                        "Bumbu dengan garam, kaldu ayam bubuk dan kecap.\n" +
//                        "Aduk-aduk hingga rata lalu angkat.\n" +
//                        "\n" +
//                        "Baca artikel detikfood, \"Resep Cara Membuat Nasi Goreng Rumahan yang Gurih Enak\" selengkapnya https://food.detik.com/info-kuliner/d-4649204/resep-cara-membuat-nasi-goreng-rumahan-yang-gurih-enak.\n" +
//                        "\n" +
//                        "Download Apps Detikcom Sekarang https://apps.detik.com/detik/"
//            ),
//            Food(
//                "Rendang", R.drawable.rendang, "Cuci udang lalu potong-potong\n" +
//                        "Potong-potong ayam panggang.\n" +
//                        "Panaskan minyak dalam wajan, masukkan udang dan ayam.\n" +
//                        "Masak sebentar hingga matang. Tiriskan.\n" +
//                        "Panaskan sedikit minyak dalam wajan.\n" +
//                        "Masukkan telur, aduk hingga bergumpal dan matang.\n" +
//                        "Masukkan nasi, aduk-aduk hingga terurai.\n" +
//                        "Tambahkan udang dan ayam panggang. Aduk rata.\n" +
//                        "Bumbu dengan garam, kaldu ayam bubuk dan kecap.\n" +
//                        "Aduk-aduk hingga rata lalu angkat.\n" +
//                        "\n" +
//                        "Baca artikel detikfood, \"Resep Cara Membuat Nasi Goreng Rumahan yang Gurih Enak\" selengkapnya https://food.detik.com/info-kuliner/d-4649204/resep-cara-membuat-nasi-goreng-rumahan-yang-gurih-enak.\n" +
//                        "\n" +
//                        "Download Apps Detikcom Sekarang https://apps.detik.com/detik/"
//            ),
//            Food(
//                "Sate", R.drawable.sate, "Cuci udang lalu potong-potong\n" +
//                        "Potong-potong ayam panggang.\n" +
//                        "Panaskan minyak dalam wajan, masukkan udang dan ayam.\n" +
//                        "Masak sebentar hingga matang. Tiriskan.\n" +
//                        "Panaskan sedikit minyak dalam wajan.\n" +
//                        "Masukkan telur, aduk hingga bergumpal dan matang.\n" +
//                        "Masukkan nasi, aduk-aduk hingga terurai.\n" +
//                        "Tambahkan udang dan ayam panggang. Aduk rata.\n" +
//                        "Bumbu dengan garam, kaldu ayam bubuk dan kecap.\n" +
//                        "Aduk-aduk hingga rata lalu angkat.\n" +
//                        "\n" +
//                        "Baca artikel detikfood, \"Resep Cara Membuat Nasi Goreng Rumahan yang Gurih Enak\" selengkapnya https://food.detik.com/info-kuliner/d-4649204/resep-cara-membuat-nasi-goreng-rumahan-yang-gurih-enak.\n" +
//                        "\n" +
//                        "Download Apps Detikcom Sekarang https://apps.detik.com/detik/"
//            ),
//            Food(
//                "Soto", R.drawable.soto, "Cuci udang lalu potong-potong\n" +
//                        "Potong-potong ayam panggang.\n" +
//                        "Panaskan minyak dalam wajan, masukkan udang dan ayam.\n" +
//                        "Masak sebentar hingga matang. Tiriskan.\n" +
//                        "Panaskan sedikit minyak dalam wajan.\n" +
//                        "Masukkan telur, aduk hingga bergumpal dan matang.\n" +
//                        "Masukkan nasi, aduk-aduk hingga terurai.\n" +
//                        "Tambahkan udang dan ayam panggang. Aduk rata.\n" +
//                        "Bumbu dengan garam, kaldu ayam bubuk dan kecap.\n" +
//                        "Aduk-aduk hingga rata lalu angkat.\n" +
//                        "\n" +
//                        "Baca artikel detikfood, \"Resep Cara Membuat Nasi Goreng Rumahan yang Gurih Enak\" selengkapnya https://food.detik.com/info-kuliner/d-4649204/resep-cara-membuat-nasi-goreng-rumahan-yang-gurih-enak.\n" +
//                        "\n" +
//                        "Download Apps Detikcom Sekarang https://apps.detik.com/detik/"
//            ),
//        )
//    }
//}