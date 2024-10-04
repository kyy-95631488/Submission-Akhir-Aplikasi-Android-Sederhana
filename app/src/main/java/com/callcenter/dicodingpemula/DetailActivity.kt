package com.callcenter.dicodingpemula

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DetailActivity : AppCompatActivity() {

    private lateinit var detailImageView: ImageView
    private lateinit var detailTitle: TextView
    private lateinit var detailOverview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Setup Toolbar
        val toolbar: Toolbar = findViewById(R.id.detailToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)  // Tampilkan tombol back
        supportActionBar?.title = "Detail"  // Judul pada toolbar

        detailImageView = findViewById(R.id.detailImageView)
        detailTitle = findViewById(R.id.detailTitle)
        detailOverview = findViewById(R.id.detailOverview)

        // Mengambil data dari intent
        val title = intent.getStringExtra("title")
        val overview = intent.getStringExtra("overview")
        val imageUri = intent.getStringExtra("imageUri")

        // Menampilkan data
        detailTitle.text = title
        detailOverview.text = overview

        if (imageUri != null) {
            detailImageView.setImageURI(android.net.Uri.parse(imageUri))
        }
    }

    // Fungsi untuk menangani tombol back di toolbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()  // Kembali ke activity sebelumnya
        return true
    }
}
