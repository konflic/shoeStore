package com.udacity.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
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
            val name = shoe_name_input.text ?: ""
            val size =
                if (shoe_size_input.text == null || shoe_size_input.text.toString() == "") 0.toDouble()
                else shoe_size_input.text.toString().toDouble()
            val description = shoe_description_input.text ?: ""
            val company = shoe_company_input.text ?: ""

            // Assumed that input is always correct
            if (!viewModel.addShoe(
                    name.toString(),
                    size,
                    company.toString(),
                    description.toString()
                )
            ) {
                Toast.makeText(
                    context,
                    "Can't create Shoe with empty values",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }

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