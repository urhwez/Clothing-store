package com.example.opros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.opros.databinding.ActivityItemsBinding

class ItemsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityItemsBinding
    private val viewModel by lazy { dbHelper(Dependencies.dbrepository) }

        override fun onCreate(savedInstanceState: Bundle?) {
            Dependencies.init(applicationContext)
            super.onCreate(savedInstanceState)
            binding = ActivityItemsBinding.inflate(layoutInflater).also { setContentView(it.root)
                val homeButton: ImageButton = findViewById(R.id.imageHome)
                val catalogButton: ImageButton = findViewById(R.id.imageCatalog)
                val peopleButton: ImageButton = findViewById(R.id.imagePeople)
                val basketButton: ImageButton = findViewById(R.id.imageBasket)

            }
            //val view: ConstraintLayout = binding.root
            //setContentView(view)


            viewModel.ManProducts.observe(this){ ManProducts ->
                val adapter = ProductAdapter(this)
                adapter.data = ManProducts

                binding.rcView.adapter = adapter
                binding.rcView.layoutManager = GridLayoutManager(this@ItemsActivity, 2)

            }

        }
}


