package com.example.composecorelib.buttons

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecorelib.R
import com.example.composecorelib.miscellaneous.DividerView

@Composable
fun OptionActionView(
    icon: Painter = painterResource(R.drawable.placeholder),
    text: String,
    modifier: Modifier = Modifier,
    showDividerView: Boolean = false,
    centerText: Boolean = true,
    onClick: () -> Unit
) {
    Surface(modifier.wrapContentSize()) {
        Column {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .clickable { onClick() }
                    .padding(12.dp),
                horizontalArrangement = if (centerText) Arrangement.SpaceBetween else Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = icon,
                    contentDescription = stringResource(R.string.information),
                    modifier = modifier.size(35.dp)
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = modifier.padding(start = if (!centerText) 16.dp else 0.dp)
                )
                if (!centerText) {
                    Spacer(modifier = modifier.weight(1f))
                }
                Image(
                    painter = painterResource(R.drawable.ic_keyboard_arrow_right_black_24dp),
                    contentDescription = stringResource(R.string.information)
                )
            }

            if (showDividerView) {
                DividerView()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOptionActionView() {
    OptionActionView(
        icon = painterResource(R.drawable.ic_launcher_background),
        text = "Information",
        centerText = false
    ) {

    }
}