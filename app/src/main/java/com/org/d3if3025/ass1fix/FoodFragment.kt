package com.org.d3if3025.ass1fix

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.org.d3if3025.ass1fix.databinding.FragmentFoodBinding
import com.org.d3if3025.ass1fix.db.FoodDb
import com.org.d3if3025.ass1fix.network.ApiStatus
import android.content.pm.PackageManager



@SuppressLint("NotifyDataSetChanged")
class FoodFragment : Fragment(), View.OnClickListener {
    private val viewModel: MainViewModel by lazy {
        val db = FoodDb.getInstance(requireContext())
        ViewModelProvider(this, MainViewModelFactory(db.dao))[MainViewModel::class.java]
    }
    private lateinit var binding: FragmentFoodBinding
    private lateinit var foodAdapter: FoodAdapter
//    private val list = listOf<Food>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodBinding.inflate(layoutInflater, container, false)

//        list = ArrayList()
//        list.addAll(getData())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Food"

        viewModel.getStatus().observe(viewLifecycleOwner) {
            updateProgress(it)
        }
        viewModel.getData().observe(viewLifecycleOwner) {
            foodAdapter = FoodAdapter(it)
            
            with(binding.recyclerView) {
                adapter = foodAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }

            foodAdapter.run { notifyDataSetChanged() }

        }
    }

    private fun updateProgress(status: ApiStatus) {
        when (status) {
            ApiStatus.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            ApiStatus.SUCCESS -> {
                binding.progressBar.visibility = View.GONE
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    requestNotificationPermission()
                }

            }
            ApiStatus.FAILED -> {
                binding.progressBar.visibility = View.GONE
                binding.networkError.visibility = View.VISIBLE
            }
        }
    }


//    private fun getData(): ArrayList<Food> {
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
//            )
//        )
//    }


    override fun onClick(oala: View?) {

    }
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun requestNotificationPermission() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                ActivityMenuMain.PERMISSION_REQUEST_CODE
            )
        }
    }
}