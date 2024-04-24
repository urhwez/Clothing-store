package com.example.opros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.opros.databinding.ActivityHomeBinding
import com.example.opros.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view : ConstraintLayout = binding.root
        setContentView(view)

        val homeButton: ImageButton = findViewById(R.id.imageHome)
        val catalogButton: ImageButton = findViewById(R.id.imageCatalog)
        val peopleButton: ImageButton = findViewById(R.id.imagePeople)
        val basketButton: ImageButton = findViewById(R.id.imageBasket)
        val mainText: TextView = findViewById(R.id.mainText)
        val imageMan: ImageView = findViewById(R.id.imageMan)
        val imageWoman: ImageView = findViewById(R.id.imageWoman)
        val textMan: TextView = findViewById(R.id.textMan)
        val textWoman: TextView = findViewById(R.id.textWoman)

        imageMan.setOnClickListener{
            val intent = Intent(this, ItemsActivity::class.java)
            startActivity(intent)
        }


    }



}