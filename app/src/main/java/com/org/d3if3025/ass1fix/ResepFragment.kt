package com.org.d3if3025.ass1fix

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.org.d3if3025.ass1fix.databinding.FragmentResepBinding

class ResepFragment : Fragment() {

    private lateinit var binding: FragmentResepBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResepBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonShare.setOnClickListener{showResep()}
    }

//    private fun showResep(){
//        val message = "Bagikan Resep"
//        val bagikanIntent = Intent(Intent.ACTION_SEND)
//        bagikanIntent.setType("Plain").putExtra(Intent.EXTRA_TEXT, message)
//        if (bagikanIntent.resolveActivity(
//                requireActivity().packageManager) !=null) {
//            startActivity(bagikanIntent)
//        }
//    }
    fun showResep(){
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, requireActivity().getString(R.string.app_name))
        sharingIntent.putExtra(Intent.EXTRA_TEXT, "Ayo Lihat Resep dengan Foodie!")
        requireActivity().startActivity(Intent.createChooser(sharingIntent, "Bagikan Melalui"))
    }
}

