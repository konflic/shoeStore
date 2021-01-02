package com.udacity.shoestore.models

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R

class ShoeListViewModel : ViewModel() {

    val shoeList = MutableLiveData<MutableList<Shoe>>()

    init {
        shoeList.value = ArrayList()
        initFakeData()
    }

    fun addShoe(name: String, size: Double, company: String, description: String): Boolean {

        return if (name != "" && company != "" && description != "" && size != 0.0) {
            shoeList.value?.add(
                Shoe(
                    name,
                    size,
                    company,
                    description,
                    image = R.drawable.shoe_placeholder
                )
            )
            shoeList.value = shoeList.value
            true
        } else {
            false
        }
    }

    private fun initFakeData() {
        addShoe("Moby", 29.0, "Adidas", "The best sport casual")
        addShoe("Gazelle", 21.0, "Adidas", "The best sport casual")
        addShoe("Superstar", 29.0, "Adidas", "The legendary sport casual")
        addShoe("Gazelle", 10.0, "Adidas", "The best sport casual")
    }
}