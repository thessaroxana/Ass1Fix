package com.org.d3if3025.ass1fix

import android.Manifest.*
import android.annotation.SuppressLint
import android.content.pm.PackageManager
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


@SuppressLint("NotifyDataSetChanged")
class FoodFragment : Fragment(), View.OnClickListener {
    private val viewModel: MainViewModel by lazy {
        val db = FoodDb.getInstance(requireContext())
        ViewModelProvider(this, MainViewModelFactory(db.dao))[MainViewModel::class.java]
    }
    private lateinit var binding: FragmentFoodBinding
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodBinding.inflate(layoutInflater, container, false)
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
        viewModel.scheduleUpdater(requireActivity().application)
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

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun requestNotificationPermission() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(permission.POST_NOTIFICATIONS),
                ActivityMenuMain.PERMISSION_REQUEST_CODE
            )
        }
    }


    override fun onClick(oala: View?) {
    }
}
