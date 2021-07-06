package com.ufuoma.week5recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FlowerActivity : AppCompatActivity() {


            private val flowerViewModel by viewModels<FlowerViewModel> {
                FlowerViewModelFactory(this)
            }

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.floweractivity)

                var currentFlowerId: Long? = null

                /* Connect variables to UI elements. */
                val flowerName: TextView = findViewById(R.id.flower_name)
                val flowerImage: ImageView = findViewById(R.id.flower_image)
                val flowerDescription: TextView = findViewById(R.id.flowerdescription)
                val removeFlowerButton: Button = findViewById(R.id.remove_button)

                val bundle: Bundle? = intent.extras
                if (bundle != null) {
                    currentFlowerId = bundle.getLong(FLOWER_ID)
                }

                /* If currentFlowerId is not null, get corresponding flower and set name, image and
                description */
                currentFlowerId?.let {
                    val currentFlower = flowerDetailViewModel.getFlowerForId(it)
                    flowerName.text = currentFlower?.name
                    if (currentFlower?.image == null) {
                        flowerImage.setImageResource(R.drawable.rose)
                    } else {
                        flowerImage.setImageResource(currentFlower.image)
                    }
                    flowerDescription.text = currentFlower?.description

                    removeFlowerButton.setOnClickListener {
                        if (currentFlower != null) {
                            flowerDetailViewModel.removeFlower(currentFlower)
                        }
                        finish()
                    }
            }