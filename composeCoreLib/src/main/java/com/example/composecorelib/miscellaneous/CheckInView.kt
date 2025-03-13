package com.example.composecorelib.miscellaneous

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecorelib.R
import com.example.composecorelib.graphics.CoinGraphic

@Composable
fun CheckInView(
    modifier: Modifier = Modifier,
    coinText: String = "$",
    text: String = "",
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier.wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            onClick = {
                if (enabled) {
                    onClick()
                }
            }
        ) {
            CoinGraphic(
                coinSize = 40,
                text = coinText,
                textSize = 10,
                textColor = if (enabled) colorResource(R.color.darkGold) else colorResource(R.color.black),
                animate = enabled,
                coinColor = if (enabled) colorResource(R.color.gold) else colorResource(R.color.grey)
            )
        }
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CheckInViewPreview() {
    CheckInView(text = "Date") {

    }
}