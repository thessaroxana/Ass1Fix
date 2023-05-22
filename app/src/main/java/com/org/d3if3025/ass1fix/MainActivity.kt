package com.org.d3if3025.ass1fix

import FoodFragment
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            object : Thread() {
                override fun run() {
                    sleep(3000)
                    startActivity(
                        Intent(
                            this@MainActivity,
                            MainActivity::class.java
                        )
                    )
                    finish()
                }
            }.start()
        } catch (ex: Exception) {
            Toast.makeText(
                this@MainActivity,
                "Failed to start app!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

