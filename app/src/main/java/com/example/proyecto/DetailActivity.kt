package com.example.proyecto

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    lateinit var textViewNombre: TextView
    lateinit var url: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val bundle = intent.extras
        val nombre = bundle?.getString("nombre")
        val escudo = bundle?.getString("escudo")
        textViewNombre = findViewById(R.id.textViewNombre)
        url = findViewById(R.id.imageViewUrl)
        textViewNombre.text = nombre
        Glide.with(applicationContext).load(escudo).into(url)
    }
}