package com.org.d3if3025.ass1fix

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.org.d3if3025.ass1fix.databinding.FragmentInputRequestBinding
import com.org.d3if3025.ass1fix.db.FoodDb

class FragmentInputRequest : Fragment() {

    companion object {
        const val RESEP = "Resep yang diinginkan"
    }

    private lateinit var binding: FragmentInputRequestBinding
    private val viewModel: InputRequestViewModel by lazy {
        val db = FoodDb.getInstance(requireContext())
        val factory = InputRequestViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[InputRequestViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInputRequestBinding.inflate(layoutInflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.buttonSubmit.setOnClickListener {
            val resep = binding.textField.text.toString()
            viewModel.getData(resep)
        }
    }
}

