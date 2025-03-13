package com.example.composecorelib.informational

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.composecorelib.R

@Composable
fun IconInformationView(
    modifier: Modifier = Modifier,
    title: String = "",
    description: String = "",
    icon: Painter = painterResource(R.drawable.placeholder),
    iconWidth: Dp = 100.dp,
    iconHeight: Dp = 100.dp
) {
    Surface(Modifier.wrapContentSize()) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = "",
                contentDescription = "Information",
                placeholder = icon,
                error = icon,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(width = iconWidth, height = iconHeight)
                    .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                    .clip(
                        RoundedCornerShape(
                            topEnd = 8.dp,
                            topStart = 8.dp,
                            bottomEnd = 8.dp,
                            bottomStart = 8.dp
                        )
                    )
            )
            Column {
                if (title.isNotBlank()) {
                    Text(
                        text = title,
                        modifier = modifier.padding(start = 12.dp, end = 16.dp),
                        fontWeight = if (description.isBlank()) FontWeight.Normal else FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                if (description.isNotBlank()) {
                    Text(
                        text = description,
                        modifier = modifier.padding(start = 12.dp, end = 16.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IconInformationViewPreview() {
    IconInformationView(
        title = "How To Play",
        description = "This is a very difficult game to play."
    )
}