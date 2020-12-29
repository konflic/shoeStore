package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.models.ShoeListViewModel


class ShoeListFragment : Fragment() {

	private lateinit var viewModel: ShoeListViewModel

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		val binding: FragmentLoginBinding = DataBindingUtil.inflate(
			inflater, R.layout.fragment_shoe_list, container, false
		)
		viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
		return binding.root
	}
}