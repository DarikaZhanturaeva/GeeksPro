package com.example.geekspro.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geekspro.model.CarsModel
import com.example.geekspro.utils.Keys
import com.example.geekspro.databinding.FragmentCarsDetailBinding
import com.example.geekspro.ext.loadImage

class CarsDetailFragment : Fragment() {

    private lateinit var binding: FragmentCarsDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCarsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() {
        val model = arguments?.getSerializable(Keys.KEY_FOR_CAR) as CarsModel
        binding.apply {
            tvCarName.text = model.name
            tvCarYear.text = model.year
            imgCars.loadImage(model.image)
        }
    }

}