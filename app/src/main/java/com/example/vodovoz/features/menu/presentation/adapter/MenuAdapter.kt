package com.example.vodovoz.features.menu.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.vodovoz.R
import com.example.vodovoz.databinding.ItemProductBinding
import com.example.vodovoz.features.menu.domain.model.Data
import com.example.vodovoz.utils.Constants.Companion.BASE_URL

class MenuAdapter(
    private val data: List<Data>
): RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    class MenuViewHolder(view: View): ViewHolder(view) {

        private val viewBinding: ItemProductBinding by viewBinding(ItemProductBinding::bind)

        fun bind(data: Data){
            Glide.with(viewBinding.ivProduct).load(BASE_URL + data.detailPicture).into(viewBinding.ivProduct)
            viewBinding.tvPrice.text = data.extendedPrice[0].price.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val cellForProduct = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return MenuViewHolder(cellForProduct)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}