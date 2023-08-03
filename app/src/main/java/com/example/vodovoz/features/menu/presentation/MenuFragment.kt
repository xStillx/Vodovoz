package com.example.vodovoz.features.menu.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.vodovoz.R
import com.example.vodovoz.databinding.FragmentMenuBinding
import com.example.vodovoz.features.menu.presentation.adapter.CategoriesAdapter
import com.example.vodovoz.features.menu.presentation.adapter.MenuAdapter
import com.example.vodovoz.utils.ViewState
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment: Fragment(R.layout.fragment_menu) {

    private val viewBinding: FragmentMenuBinding by viewBinding(FragmentMenuBinding::bind)
    private val viewModel: MenuViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observe()
    }

    private fun observe() {
        viewModel.isVisible.observe(viewLifecycleOwner){
            viewBinding.pbProgress.isVisible = it
        }
        viewModel.vodovoz.observe(viewLifecycleOwner){ vodovoz ->
            when(vodovoz){
                ViewState.Empty -> {
                    Snackbar.make(viewBinding.clMenu, getString(R.string.empty), Snackbar.LENGTH_SHORT).show()
                }
                is ViewState.Error -> {
                    Snackbar.make(viewBinding.clMenu, getString(R.string.error), Snackbar.LENGTH_SHORT).show()
                }
                is ViewState.Show -> {
                    if (vodovoz.data.status == "Success"){
                        viewBinding.rvCategories.adapter = CategoriesAdapter(vodovoz.data.tovary, requireContext()){
                            viewBinding.rvProducts.adapter = MenuAdapter(vodovoz.data.tovary[it].data)
                        }
                        viewBinding.rvProducts.adapter = MenuAdapter(vodovoz.data.tovary[0].data)
                    }else{
                        viewBinding.rvCategories.isVisible = false
                        viewBinding.rvProducts.isVisible = false
                    }
                }
            }
        }
    }

    private fun initViews() {
        viewBinding.rvCategories.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        viewBinding.rvProducts.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }
}