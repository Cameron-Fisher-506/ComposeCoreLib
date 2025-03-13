/*
 * Copyright (C) 2025 Cameron Fisher - All Rights Reserved
 * You may use, distribute and modify this Open Source Project
 */
package com.example.composecorelib.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonView(
    modifier: Modifier = Modifier,
    title: String,
    shape: Shape = RectangleShape,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    onClick: () -> Unit
) {
    Surface(Modifier.wrapContentSize()) {
        Button(
            onClick = { onClick() },
            modifier = modifier
                .padding(20.dp, 10.dp)
                .fillMaxWidth(1f),
            shape = shape,
            colors = colors
        ) {
            Text(title)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewButtonView() {
    ButtonView(title = "Button") {}
}