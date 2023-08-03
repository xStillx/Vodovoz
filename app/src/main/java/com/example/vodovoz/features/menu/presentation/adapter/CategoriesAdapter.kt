package com.example.vodovoz.features.menu.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.vodovoz.R
import com.example.vodovoz.databinding.ItemCategoryBinding
import com.example.vodovoz.features.menu.domain.model.Tovary

class CategoriesAdapter(
    private val tovary: List<Tovary>,
    private val context: Context,
    private val onCategoryClick: (category: Int) -> Unit
): RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    private var selectedItem: Int = 0

    class CategoriesViewHolder(view: View): ViewHolder(view) {

        internal val viewBinding: ItemCategoryBinding by viewBinding(ItemCategoryBinding::bind)

        fun bind(tovary: Tovary, context: Context){
            viewBinding.tvCategory.setTextColor(context.resources.getColor(R.color.black))
            viewBinding.clCategory.setBackgroundResource(R.drawable.category_background)
            viewBinding.clCategory.elevation = 8F
            viewBinding.tvCategory.text = tovary.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val cellForRow = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoriesViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.bind(tovary[position], context)
        if (selectedItem == position){
            holder.itemView.elevation = 0F
            holder.itemView.setBackgroundResource(R.drawable.categories_selected_background)
            holder.viewBinding.tvCategory.setTextColor(context.resources.getColor(R.color.purple_500))
        }
        holder.itemView.setOnClickListener {
            onCategoryClick.invoke(position)
            val previousItem = selectedItem
            selectedItem = position
            notifyItemChanged(previousItem)
            notifyItemChanged(selectedItem)
        }
    }

    override fun getItemCount(): Int {
        return tovary.size
    }
}