package com.example.composecorelib.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomAlphabetKeyboardView(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    alphabetListToRemove: List<Char> = listOf(),
    onClick: (word: String) -> Unit
) {
    Surface(modifier.wrapContentSize()) {
        val alphabetList = getAlphabetList(alphabetListToRemove)
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 60.dp),
            contentPadding = PaddingValues(
                start = 12.dp,
                top = 16.dp,
                end = 12.dp,
                bottom = 16.dp
            )
        ) {
            items(
                count = alphabetList.size,
                key = { key ->
                    alphabetList[key]
                }
            ) { index ->
                Button(
                    enabled = enabled,
                    modifier = modifier.wrapContentSize(),
                    onClick = {
                        onClick(alphabetList[index].toString())
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        disabledContainerColor = Color.LightGray,
                        disabledContentColor = Color.White
                    )
                ) {
                    Text(alphabetList[index].toString())
                }
            }
        }
    }
}

private fun getAlphabetList(alphabetListToRemove: List<Char>): List<Char> {
    var alphabetList: List<Char> = listOf(
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
        'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
        'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    )
    alphabetListToRemove.forEach { alphabet ->
        alphabetList = alphabetList.filterNot { alphabet.equals(it, true) }
    }
    return alphabetList
}

@Preview(showBackground = true)
@Composable
fun CustomAlphabetKeyboardViewPreview() {
    CustomAlphabetKeyboardView { }
}