package com.example.sampleposui.states

import com.example.sampleposui.data.MenuUIOptions

data class MainScreenUIState(
    val stateName: String = "Sample POS UI",
    val currentOption: MenuUIOptions = MenuUIOptions.HOME,
)