package com.udacity.shoestore

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.ShoeListViewModel


class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeListViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )

        binding.addShoeButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_shoeListFragment_to_createShoeFragment
            )
        )

        viewModel.shoeList.observe(viewLifecycleOwner) { shoeList ->

            for (shoe in shoeList) {
                val name = TextView(this.context)
                val size = TextView(this.context)
                val company = TextView(this.context)
                val description = TextView(this.context)
                val image = ImageView(this.context)

                name.text = shoe.name
                size.text = shoe.size.toString()
                company.text = shoe.company
                description.text = shoe.description
                image.setImageResource(R.drawable.shoe_placeholder)
                name.textSize = 25F
                name.textAlignment = View.TEXT_ALIGNMENT_CENTER
                size.textSize = 20F
                size.textAlignment = View.TEXT_ALIGNMENT_CENTER
                company.textSize = 20F
                company.textAlignment = View.TEXT_ALIGNMENT_CENTER
                description.textSize = 15F
                description.textAlignment = View.TEXT_ALIGNMENT_CENTER

                val shoeItemLayout = LinearLayout(this.context)

                shoeItemLayout.apply {
                    orientation = LinearLayout.VERTICAL
                    setPadding(5, 5, 5, 5)
                    setBackgroundColor(Color.LTGRAY)
                    addView(
                        image, LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            450
                        )
                    )
                    addView(name)
                    addView(size)
                    addView(company)
                    addView(description)
                }

                val shoeItemLayoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                shoeItemLayoutParams.setMargins(5, 0, 5, 10)
                binding.shoeList.addView(shoeItemLayout, shoeItemLayoutParams)
            }
        }

        setHasOptionsMenu(true)

        return binding.root
    }
}