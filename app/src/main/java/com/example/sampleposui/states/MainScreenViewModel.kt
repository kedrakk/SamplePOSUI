package com.example.sampleposui.states

import androidx.lifecycle.ViewModel
import com.example.sampleposui.data.Invoice
import com.example.sampleposui.data.MenuItems
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainScreenViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MainScreenUIState())
    val uiState: StateFlow<MainScreenUIState> = _uiState.asStateFlow()

    fun onMenuItemSelectChanged(newMenu: MenuItems) {
        _uiState.value =
            MainScreenUIState(stateName = newMenu.title, currentOption = newMenu.menuUIOptions)
    }

    fun totalQty(invoices:List<Invoice> ):Int{
        return invoices.sumOf { it.quantity };
    }

    fun totalAmount(invoices:List<Invoice> ):Double{
        return invoices.sumOf { it.amount };
    }
}