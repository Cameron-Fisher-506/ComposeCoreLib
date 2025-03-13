/*
 * Copyright (C) 2025 Cameron Fisher - All Rights Reserved
 * You may use, distribute and modify this Open Source Project
 */
package com.example.composecorelib.buttons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.composecorelib.R
import com.example.composecorelib.informational.ExpandableTextView
import com.example.composecorelib.miscellaneous.DividerView
import com.example.composecorelib.model.Item

@Composable
fun CustomCardItemView(
    modifier: Modifier = Modifier,
    item: Item,
    isFavoriteItem: Boolean = false,
    showFavoriteIcon: Boolean = false,
    onFavoriteClick: (isFavoriteItem: Boolean) -> Unit,
    onClick: () -> Unit
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    Card(
        modifier = modifier
            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
            .wrapContentSize()
            .clickable { onClick() }
    ) {
        if (showFavoriteIcon) {
            Box(modifier = Modifier.offset((screenWidth.minus(80.dp)), 24.dp)) {
                Icon(
                    imageVector = if (isFavoriteItem) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    contentDescription = "Favorite",
                    modifier = Modifier.clickable { onFavoriteClick(isFavoriteItem) },
                    tint = Color.Red
                )
            }
        }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = item.imageUrl,
                contentDescription = "itemImage",
                placeholder = painterResource(R.drawable.space_rocket),
                error = painterResource(R.drawable.space_rocket),
                contentScale = ContentScale.FillBounds,
                modifier = modifier
                    .width(100.dp)
                    .height(120.dp)
            )
            Column(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = item.title,
                    modifier = modifier,
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = item.subTitle,
                    modifier = modifier,
                    style = MaterialTheme.typography.titleMedium
                )
                Row {
                    Text(
                        text = item.rating,
                        modifier = modifier,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Star",
                        tint = colorResource(R.color.gold)
                    )
                }
            }
        }

        if (item.description.isNotBlank()) {
            DividerView()
            ExpandableTextView(
                text = item.description,
                modifier = modifier.padding(16.dp)
            )
        }
    }
}

@Preview
@Composable
fun CustomCardItemViewPreview() {
    CustomCardItemView(
        item = Item.Builder()
            .description("Hello")
            .build(),
        onFavoriteClick = {}) {

    }
}
