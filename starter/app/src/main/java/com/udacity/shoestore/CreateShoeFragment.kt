package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.databinding.FragmentCreateShoeBinding
import com.udacity.shoestore.models.ShoeListViewModel
import kotlinx.android.synthetic.main.fragment_create_shoe.*


class CreateShoeFragment : Fragment() {

    private lateinit var binding: FragmentCreateShoeBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_create_shoe,
            container,
            false
        )

        binding.saveShoeButton.setOnClickListener {

            // Assumed that input is always correct
            viewModel.addShoe(
                shoe_name_input.text.toString(),
                shoe_size_input.text.toString().toDouble(),
                shoe_size_input.text.toString(),
                shoe_description_input.text.toString()
            )

            NavHostFragment.findNavController(this)
                .navigate(R.id.action_createShoeFragment_to_shoeListFragment)

        }

        binding.cancelEditShoeButton.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_createShoeFragment_to_shoeListFragment)
        }

        setHasOptionsMenu(true)

        return binding.root
    }


}