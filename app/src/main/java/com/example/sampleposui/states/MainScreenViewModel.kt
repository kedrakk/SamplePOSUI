package com.example.sampleposui.states

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainScreenViewModel:ViewModel(){
    private val _uiState = MutableStateFlow(MainScreenUIState())
    val uiState: StateFlow<MainScreenUIState> = _uiState.asStateFlow()

    fun onMenuItemSelectChanged(newItem:String){
        _uiState.value=MainScreenUIState(stateName = newItem)
    }
}