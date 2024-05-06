package io.seoj17.android_14th_compose_zzik.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.seoj17.android_14th_compose_zzik.data.BitRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bitRepository: BitRepository
) : ViewModel() {

    init {
        getMarketCodeList()
    }

    private fun getMarketCodeList() {
        viewModelScope.launch {
            bitRepository.getMarketCodeList().collect { marketCodeList ->
                marketCodeList.forEach {
                    Log.d("psj", it.market + ": " + it.korName)
                }
            }
        }
    }
}
