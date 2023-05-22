package com.org.d3if3025.ass1fix

import FoodFragment
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.org.d3if3025.ass1fix.databinding.ActivityMenuMainBinding

class ActivityMenuMain : AppCompatActivity() {
    private lateinit var binding : ActivityMenuMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addFragment(FoodFragment())

//        binding.navBotton.setOnItemSelectedListener {
//            when(it.itemId) {
//                R.id.about -> addFragment(AboutFragment())
//                R.id.menu_histori -> addFragment(HistoryFragment())
//
//                else->{
//
//                }
//            }
//            true
//        }

    }

    fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu)
        inflater.inflate(R.menu.menu_item, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.about) {
            findNavController(R.id.action_food_to_aboutFragment)
            return true
        } else{
            findNavController(R.id.action_food_to_historyFragment)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.page,fragment)
        fragmentTransaction.commit()
    }

    fun showUpButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun hideUpButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    fun clickUpButton() {

        addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                return
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    android.R.id.home -> {
                        supportFragmentManager.popBackStack()
                        true
                    }
                    else -> false
                }
            }
        })
    }
}