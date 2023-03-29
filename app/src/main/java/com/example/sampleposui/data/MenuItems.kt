package com.example.sampleposui.data

data class MenuItems(val title:String,val isActive:Boolean)

val allMenuItems:List<MenuItems> = listOf(
    MenuItems("Setup",false),
    MenuItems("Purchase",true),
    MenuItems("Sales",false),
    MenuItems("Report",false),
)
