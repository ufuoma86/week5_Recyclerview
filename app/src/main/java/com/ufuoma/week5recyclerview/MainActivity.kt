package com.ufuoma.week5recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ufuoma.week5recyclerview.flowerDetail.FlowerModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        private lateinit var binding: ActivityMainBinding
        private lateinit var myflowerAdapter: ShoppingAdapter
        private lateinit var myFlowerActivity: FlowerActivityList: MutableList<FlowerModel>

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            myFlowerActivityList = mutableListOf()
            myflowerAdapterAdapter = FlowerAdapterAdapter(myFlowerActivityList)
            binding.recyclerView.adapter = myflowerAdapterAdapter

            binding.button.setOnClickListener {
                val category : String = binding.editText.text.toString()
                val description :String = binding.editText2.text.toString()

                val shoppingItem = FlowerModelModel(category,description)
                myFlowerActivityList.add(shoppingItem)
                myflowerAdapterAdapter.notifyDataSetChanged()
            }
        }
    }
