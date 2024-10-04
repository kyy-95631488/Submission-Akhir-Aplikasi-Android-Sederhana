package com.callcenter.dicodingpemula

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        // Setup Toolbar
        val toolbar: Toolbar = findViewById(R.id.aboutToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)  // Tampilkan tombol back
        supportActionBar?.title = "About"  // Judul pada toolbar
    }

    // Fungsi untuk menangani tombol back di toolbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()  // Kembali ke activity sebelumnya
        return true
    }
}
