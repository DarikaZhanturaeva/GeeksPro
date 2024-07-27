package com.example.geekspro.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.geekspro.model.CarsModel
import com.example.geekspro.databinding.ItemCarBinding
import com.example.geekspro.ext.loadImage

class CarsAdapter(
    private var characterList: List<CarsModel>,
    private val onClick: (model: CarsModel) -> Unit) :
    RecyclerView.Adapter<CarsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCarBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = characterList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    inner class ViewHolder(private var binding: ItemCarBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(car: CarsModel) {
            binding.apply {
                tvCarName.text = car.name
                tvCarYear.text = car.year
                imgCars.loadImage(car.image)
                itemView.setOnClickListener() {
                    onClick(car)
                }
            }
        }
    }
}