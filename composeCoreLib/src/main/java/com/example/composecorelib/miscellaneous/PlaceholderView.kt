/*
 * Copyright (C) 2025 Cameron Fisher - All Rights Reserved
 * You may use, distribute and modify this Open Source Project
 */
package com.example.composecorelib.miscellaneous

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PlaceholderView(
    modifier: Modifier = Modifier,
    text: String = "",
    lettersToDisplay: List<Char> = emptyList()
) {
    Surface(modifier.wrapContentSize()) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            text.toCharArray().forEach { character ->
                if (character != ' ') {
                    val filteredCharacter: Char = lettersToDisplay.firstOrNull {
                        character.equals(it, true)
                    } ?: '_'

                    if (!filteredCharacter.equals('_', true)) {
                        Text(
                            text = filteredCharacter.uppercase(),
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleLarge
                        )
                    } else {
                        Text(
                            text = " _ ",
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                } else {
                    Text(
                        text = "  ",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlaceholderViewPreview() {
    PlaceholderView(text = "Now now", lettersToDisplay = listOf('N', 'o', 'w'))
}