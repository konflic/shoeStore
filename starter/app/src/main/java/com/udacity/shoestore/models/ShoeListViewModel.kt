package com.udacity.shoestore.models

import androidx.lifecycle.ViewModel

class ShoeListViewModel : ViewModel() {

	val shoeList: List<Shoe> = listOf(
		Shoe("Gazelle", 29.0, "Adidas", "The best sport casual", listOf("gazelle1.png", "gazelle2.png")),
		Shoe("Gazelle", 29.0, "Adidas", "The best sport casual", listOf("gazelle1.png", "gazelle2.png")),
		Shoe("Gazelle", 29.0, "Adidas", "The best sport casual", listOf("gazelle1.png", "gazelle2.png")),
		Shoe("Gazelle", 29.0, "Adidas", "The best sport casual", listOf("gazelle1.png", "gazelle2.png")),
		Shoe("Gazelle", 29.0, "Adidas", "The best sport casual", listOf("gazelle1.png", "gazelle2.png"))
	)
}