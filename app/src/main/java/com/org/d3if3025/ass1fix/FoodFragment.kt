import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.org.d3if3025.ass1fix.Food
import com.org.d3if3025.ass1fix.FoodAdapter
import com.org.d3if3025.ass1fix.R
import com.org.d3if3025.ass1fix.databinding.FragmentFoodBinding

//package com.org.d3if3025.ass1fix
//
//import android.os.Bundle
//import android.view.*
//import androidx.core.content.ContextCompat
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.ViewModelProvider
//import androidx.lifecycle.lifecycleScope
//import androidx.navigation.fragment.findNavController
//import androidx.recyclerview.widget.DividerItemDecoration
//import androidx.recyclerview.widget.GridLayoutManager
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.org.d3if3025.ass1fix.data.SettingDataStore
//import com.org.d3if3025.ass1fix.data.dataStore
//import com.org.d3if3025.ass1fix.databinding.FragmentFoodBinding
//import com.org.d3if3025.ass1fix.db.FoodDb
//import kotlinx.coroutines.launch
//
//class FoodFragment : Fragment() {
//
//    private val layoutDataStore: SettingDataStore by lazy {
//        SettingDataStore(requireContext().dataStore)
//    }
//
//    private val viewModel: FoodViewModel by lazy {
//        val db = FoodDb.getInstance(requireContext())
//        val factory = FoodViewModelFactory(db.dao)
//        ViewModelProvider(this, factory)[FoodViewModel::class.java]
//    }
//    private lateinit var myAdapter: FoodAdapter
//    private lateinit var binding: FragmentFoodBinding
//    private var isLinearLayout = true
//    companion object {
//        const val EXTRA_MESSAGE = "com.example.myapp.MESSAGE"
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentFoodBinding.inflate(layoutInflater, container, false)
//        myAdapter = FoodAdapter()
//        with(binding.recyclerView) {
//            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
//            adapter = myAdapter
//            setHasFixedSize(true)
//        }
//        setHasOptionsMenu(true)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel.getData().observe(viewLifecycleOwner) {
//            myAdapter.updateData(it)
//        }
//        //val messageTextView = findViewById<TextView>(R.id.messageTextView)
//        //val message = context.getStringExtra(EXTRA_MESSAGE)
//        //messageTextView.text = message
//        with(binding.recyclerView) {
//            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
//            //adapter = MainAdapter(getData())
//            setHasFixedSize(true)
//        }
//        layoutDataStore.preferenceFlow.asLiveData().observe(viewLifecycleOwner) {
//            isLinearLayout = it
//            setLayout()
//            activity?.invalidateOptionsMenu()
//        }
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.menu_item, menu)
//        inflater.inflate(R.menu.menu_main, menu)
//        val menuItem = menu.findItem(R.id.action_switch_layout)
//        setIcon(menuItem)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.action_switch_layout) {
//            lifecycleScope.launch {
//                layoutDataStore.saveLayout(!isLinearLayout, requireContext())
//            }
//            return true
//        }
//        when(item.itemId) {
//            R.id.menu_history -> {
//                findNavController().navigate(
//                    R.id.action_food_to_historyFragment4
//                )
//                return true
//            }
//            R.id.about -> {
//                findNavController().navigate(
//                    R.id.action_food_to_aboutFragment
//                )
//                return true
//            }
//        }
//        return super.onOptionsItemSelected(item) }
//
//    private fun setLayout() {
//        binding.recyclerView.layoutManager = if (isLinearLayout)
//            LinearLayoutManager(context)
//        else
//            GridLayoutManager(context, 2)
//    }
//
//    private fun setIcon(menuItem: MenuItem) {
//        val iconId = if (isLinearLayout)
//            R.drawable.baseline_grid_view_24
//        else
//            R.drawable.baseline_view_list_24
//        menuItem.icon = ContextCompat.getDrawable(requireContext(), iconId)
//    }
//
//}
@SuppressLint("NotifyDataSetChanged")
class FoodFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentFoodBinding
    private lateinit var foodAdapter: FoodAdapter
    private lateinit var list: ArrayList<Food>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodBinding.inflate(layoutInflater, container, false)

        list = ArrayList()
        list.addAll(getData())
        foodAdapter = FoodAdapter(list)

        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = foodAdapter
        }

        foodAdapter.run { notifyDataSetChanged() }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Newser"
//        (activity as FoodFragment).hideUpButton()

        binding.addRequest.setOnClickListener {
            findNavController().navigate(
                R.id.action_food_to_fragmentInputRequest)
        }

    }

    private fun getData(): ArrayList<Food> {
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
            )
        )
    }

    override fun onClick(oala: View?) {

    }
}