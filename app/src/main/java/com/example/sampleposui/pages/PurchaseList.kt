package com.example.sampleposui.pages

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sampleposui.data.Invoice

@Composable
fun PurchaseList(itemList:List<Invoice>) {
    LazyColumn(modifier = Modifier.fillMaxSize().fillMaxWidth()){
        item {
            Row {
                Text(text = "Date")
                Text(text = "Invoice No")
                Text(text = "QTY")
                Text(text = "Amount")
            }
        }
        items(itemList){
            Row {
               Text(text = it.invoiceDate)
                Text(text = it.invoiceNo)
                Text(text = it.quantity.toString())
                Text(text = it.amount.toString())
            }
        }
    }
}