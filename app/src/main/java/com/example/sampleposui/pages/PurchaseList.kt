package com.example.sampleposui.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sampleposui.data.Invoice

@Composable
fun PurchaseList(itemList: List<Invoice>, totalQty: Int, totalAmount: Double) {
    Column() {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .weight(1F),
        ) {
            TableCell(label = "Date", true, modifier = Modifier.weight(1F))
            TableCell(label = "Invoice No", true, modifier = Modifier.weight(1F))
            TableCell(label = "QTY", true, modifier = Modifier.weight(1F))
            TableCell(label = "Amount", true, modifier = Modifier.weight(1F))
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .weight(15F)
        ) {
            items(itemList) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxWidth(),
                ) {
                    TableCell(label = it.invoiceDate, modifier = Modifier.weight(1F))
                    TableCell(label = it.invoiceNo, modifier = Modifier.weight(1F))
                    TableCell(label = it.quantity.toString(), modifier = Modifier.weight(1F))
                    TableCell(label = it.amount.toString(), modifier = Modifier.weight(1F))
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .background(Color.Gray)
                .weight(1.5F),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ActionButtons(modifier = Modifier.weight(2F))
            Text(
                totalQty.toString(),
                modifier = Modifier.weight(1F),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.End,
            )
            Text(
                totalAmount.toString(),
                modifier = Modifier.weight(1F),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.End,
            )
        }
    }
}

@Composable
fun ActionButtons(modifier: Modifier) {
    Row(modifier = modifier) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = com.example.sampleposui.R.drawable.baseline_add_24),
                contentDescription = null
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = com.example.sampleposui.R.drawable.baseline_edit_24),
                contentDescription = null
            )
        }
    }
}

@Composable
fun TableCell(label: String, isTitle: Boolean = false, modifier: Modifier) {
    Surface(
        modifier = modifier
            .border(
                BorderStroke(1.dp, Color.LightGray),
            ),
        color = if (isTitle) Color.Gray else Color.White
    ) {
        Text(
            text = label,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 10.dp),
            fontWeight = if (isTitle) FontWeight.Bold else FontWeight.Normal,
            color = if (isTitle) Color.White else Color.Black
        )
    }
}
