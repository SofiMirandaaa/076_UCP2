package com.example.ucp2

import androidx.lifecycle.ViewModel
import com.example.ucp2.data.SkripUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewModel:ViewModel() {
    private val _stateUI = MutableStateFlow(SkripUIState())
    val stateUI : StateFlow<SkripUIState> = _stateUI.asStateFlow()

}