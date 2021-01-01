package com.udacity.shoestore.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R

class ShoeListViewModel : ViewModel() {

    val shoeList = MutableLiveData<MutableList<Shoe>>()

    init {
        shoeList.value = ArrayList()
        initFakeData()
    }

    fun addShoe(name: String, size: Double, company: String, description: String) {

        shoeList.value?.add(
            Shoe(
                name,
                size,
                company,
                description,
                R.drawable.shoe_placeholder
            )
        )
        shoeList.value = shoeList.value
    }

    private fun initFakeData() {
        addShoe("Moby", 29.0, "Adidas", "The best sport casual")
        addShoe("Gazelle", 21.0, "Adidas", "The best sport casual")
        addShoe("Superstar", 29.0, "Adidas", "The legendary sport casual")
        addShoe("Gazelle", 10.0, "Adidas", "The best sport casual")
    }
}