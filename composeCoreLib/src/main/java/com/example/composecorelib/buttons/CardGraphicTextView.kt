/*
 * Copyright (C) 2025 Cameron Fisher - All Rights Reserved
 * You may use, distribute and modify this Open Source Project
 */
package com.example.composecorelib.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecorelib.graphics.CoinGraphic

@Composable
fun CardGraphicTextView(
    modifier: Modifier = Modifier,
    text: String = "",
    graphic: @Composable (() -> Unit),
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .wrapContentSize()
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 20.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        )
    ) {
        Column(
            modifier
                .width(200.dp)
                .height(150.dp)
                .clickable { onClick() },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            graphic()
            Spacer(modifier = modifier.padding(vertical = 5.dp))
            Text(
                text = text,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardGraphicTextViewPreview() {
    CardGraphicTextView(
        modifier = Modifier.background(Color.LightGray),
        text = "Check-In",
        graphic = {
            CoinGraphic()
        }
    ) {

    }
}