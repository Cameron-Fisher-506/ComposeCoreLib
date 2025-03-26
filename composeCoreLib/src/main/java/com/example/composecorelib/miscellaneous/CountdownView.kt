/*
 * Copyright (C) 2025 Cameron Fisher - All Rights Reserved
 * You may use, distribute and modify this Open Source Project
 */
package com.example.composecorelib.miscellaneous

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.compose.LifecycleResumeEffect
import kotlinx.coroutines.delay

@Composable
fun CountdownView(targetTime: Int, content: @Composable (timeLeft: Int) -> Unit) {
    var timeLeft by remember { mutableIntStateOf(targetTime) }

    content.invoke(timeLeft)

    var isRunning by remember { mutableStateOf(false) }
    LifecycleResumeEffect(Unit) {
        isRunning = true
        onPauseOrDispose { isRunning = false }
    }

    LaunchedEffect(isRunning) {
        while (timeLeft > 0) {
            delay(1000L)
            timeLeft--
        }
    }
}