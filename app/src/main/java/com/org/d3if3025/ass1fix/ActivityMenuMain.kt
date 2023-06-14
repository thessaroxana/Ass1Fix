package com.org.d3if3025.ass1fix

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import com.org.d3if3025.ass1fix.databinding.ActivityMenuMainBinding
import com.org.d3if3025.ass1fix.fragment.AboutFragment

class ActivityMenuMain : AppCompatActivity() {

    companion object {
        const val CHANNEL_ID = "updater"
    }

    private lateinit var binding: ActivityMenuMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        addFragment(FoodFragment())


        binding.navBotton.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> addFragment(FoodFragment())
                R.id.navigation_lihat_resep -> addFragment(ResepFragment())
                R.id.requestResep -> addFragment(FragmentInputRequest())
                R.id.menu_histori -> addFragment(HistoryFragment())
                R.id.about -> addFragment(AboutFragment())

                else -> {

                }
            }
            true
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description = getString(R.string.channel_desc)
            val manager = getSystemService(Context.NOTIFICATION_SERVICE)
                    as NotificationManager?
            manager?.createNotificationChannel(channel)
        }

    }

    private fun addFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.page, fragment)
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
//    private lateinit var binding : ActivityMenuMainBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMenuMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        addFragment(FoodFragment())
//
////        binding.navBotton.setOnItemSelectedListener {
////            when(it.itemId) {
////                R.id.about -> addFragment(AboutFragment())
////                R.id.menu_histori -> addFragment(HistoryFragment())
////
////                else->{
////
////                }
////            }
////            true
////        }
//
//    }
//
//    fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu)
//        inflater.inflate(R.menu.menu_item, menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.about) {
//            findNavController(R.id.action_food_to_aboutFragment)
//            return true
//        } else{
//            findNavController(R.id.action_food_to_historyFragment)
//            return true
//        }
//        return super.onOptionsItemSelected(item)
//    }
//
//    private fun addFragment(fragment: Fragment) {
//
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.page,fragment)
//        fragmentTransaction.commit()
//    }
//
//    fun showUpButton() {
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//    }
//
//    fun hideUpButton() {
//        supportActionBar?.setDisplayHomeAsUpEnabled(false)
//    }
//
//    fun clickUpButton() {
//
//        addMenuProvider(object : MenuProvider {
//            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
//                return
//            }
//
//            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
//                return when (menuItem.itemId) {
//                    android.R.id.home -> {
//                        supportFragmentManager.popBackStack()
//                        true
//                    }
//                    else -> false
//                }
//            }
//        })
//    }
