package com.ufuoma.week5recyclerview.flowerDetail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recyclersample.data.DataSource
import com.example.recyclersample.data.Flower

data class FlowerModel(private val datasource: DataSource): ViewModel() {

    /* Queries datasource to returns a flower that corresponds to an id. */
    fun getFlowerForId(id: Long) : Flower? {
        return datasource.getFlowerForId(id)
    }

    /* Queries datasource to remove a flower. */
    fun removeFlower(flower: Flower) {
        datasource.removeFlower(flower)
    }
}

class FlowerDetailViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FlowerDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FlowerDetailViewModel(
                datasource = DataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}