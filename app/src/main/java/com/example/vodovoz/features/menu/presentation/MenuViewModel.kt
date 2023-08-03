package com.example.vodovoz.features.menu.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vodovoz.features.menu.domain.VodovozInteractor
import com.example.vodovoz.features.menu.domain.model.Vodovoz
import com.example.vodovoz.utils.ViewState
import com.example.vodovoz.utils.asLiveData
import com.example.vodovoz.utils.asViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val vodovozInteractor: VodovozInteractor
): ViewModel() {

    private val _isVisible = MutableLiveData(false)
    val isVisible get() = _isVisible.asLiveData()

    private val _vodovoz = MutableLiveData<ViewState<Vodovoz>>()
    val vodovoz get() = _vodovoz.asLiveData()

    init {
        getData()
    }

    private fun getData(){
        _isVisible.value = true
        viewModelScope.launch {
            _vodovoz.value = vodovozInteractor.getData().asViewState()
            _isVisible.value = false
        }
    }
}