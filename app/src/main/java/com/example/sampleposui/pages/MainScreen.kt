package com.example.sampleposui.pages

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sampleposui.R
import com.example.sampleposui.data.*
import com.example.sampleposui.states.MainScreenViewModel

@Composable
fun MainScreen(mainScreenViewModel: MainScreenViewModel = viewModel()) {
    var expanded by remember {
        mutableStateOf(false)
    }
    val mainScreenUIState by mainScreenViewModel.uiState.collectAsState()
    val items = allMenuItems
    val context = LocalContext.current
    val invoices = invoiceList
    Column {
        MyAppBar(
            onIconClick = { expanded = !expanded },
            expanded = expanded,
            closeDropDown = { expanded = false },
            onClickDropDown = {
                expanded = false
                if (it.isActive) {
                    mainScreenViewModel.onMenuItemSelectChanged(it)
                } else {
                    Toast.makeText(
                        context,
                        "This ${it.title} feature is coming soon",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            items = items,
            title = mainScreenUIState.stateName,
        )
        MyBody(
            menuUIOptions = mainScreenUIState.currentOption,
            invoices,
            mainScreenViewModel.totalQty(invoices),
            mainScreenViewModel.totalAmount(invoices),
        )
    }
}

@Composable
fun MyAppBar(
    onIconClick: () -> Unit,
    expanded: Boolean,
    closeDropDown: () -> Unit,
    onClickDropDown: (item: MenuItems) -> Unit,
    items: List<MenuItems>,
    title: String
) {
    TopAppBar {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { onIconClick() }) {
                Box {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_menu_24),
                        contentDescription = null
                    )
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            closeDropDown()
                        }
                    ) {
                        // adding items
                        items.forEachIndexed { _, itemValue ->
                            DropdownMenuItem(
                                onClick = {
                                    onClickDropDown(itemValue)
                                },
                            ) {
                                Text(text = itemValue.title)
                            }
                        }
                    }
                }

            }
            Text(text = title)
        }
    }
}

@Composable
fun MyBody(
    menuUIOptions: MenuUIOptions,
    invoices: List<Invoice>,
    totalQty: Int,
    totalAmount: Double,
) {
    if (menuUIOptions == MenuUIOptions.PURCHASE) {
        PurchaseList(itemList = invoices, totalQty, totalAmount)
    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Text(text = "Welcome To Sample POS")

        }
    }


}
