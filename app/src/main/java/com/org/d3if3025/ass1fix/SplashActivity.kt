//package com.org.d3if3025.ass1fix
//
//import android.content.Intent
//import android.os.Bundle
//import android.os.Handler
//import androidx.appcompat.app.AppCompatActivity
//k  ty                                                                                                                     ?//////////////////////////////////////////////////// ?//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  b
//class SplashActivity : AppCompatActivity() {
//    private val SPLASH_DELAY: Long = 3000 // Durasi tampilan splash screen dalam milidetik
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_splash)
//
//        Handler().postDelayed({
//            // Menjalankan intent untuk menuju ke aktivitas utama setelah splash screen ditampilkan
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }, SPLASH_DELAY)
//    }
//}