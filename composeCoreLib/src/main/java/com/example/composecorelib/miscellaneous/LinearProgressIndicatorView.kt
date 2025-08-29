/*
 * Copyright (C) 2025 Cameron Fisher - All Rights Reserved
 * You may use, distribute and modify this Open Source Project
 */
package com.example.composecorelib.miscellaneous

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LinearProgressIndicatorView(
    modifier: Modifier = Modifier,
    progress: Float = 0.0f,
    color: Color = Color.Red
) {
    LinearProgressIndicator(
        progress = { progress },
        color = color,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun LinearProgressIndicatorViewPreview() {
    LinearProgressIndicatorView(modifier = Modifier.background(Color.LightGray))
}