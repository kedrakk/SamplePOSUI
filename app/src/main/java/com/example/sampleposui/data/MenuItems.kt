package com.example.sampleposui.data

data class MenuItems(val title:String,val isActive:Boolean,val menuUIOptions: MenuUIOptions)

val allMenuItems:List<MenuItems> = listOf(
    MenuItems("Setup",false,MenuUIOptions.SETUP),
    MenuItems("Purchase",true,MenuUIOptions.PURCHASE),
    MenuItems("Sales",false,MenuUIOptions.SALES),
    MenuItems("Report",false,MenuUIOptions.REPORT),
)
