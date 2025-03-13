/*
 * Copyright (C) 2025 Cameron Fisher - All Rights Reserved
 * You may use, distribute and modify this Open Source Project
 */
package com.example.composecorelib.informational

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil3.compose.AsyncImage
import com.example.composecorelib.R
import com.example.composecorelib.buttons.CustomCardItemView
import com.example.composecorelib.model.Item

val COLLAPSED_TOP_BAR_HEIGHT = 56.dp
val EXPANDED_TOP_BAR_HEIGHT = 200.dp

@Composable
private fun LargeTopBar(
    modifier: Modifier = Modifier,
    title: String = "",
    titleColor: Color = Color.Unspecified,
    topBarImage: Painter = painterResource(R.drawable.placeholder),
    onFabClick: () -> Unit
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    Box(
        modifier
            .background(colorResource(R.color.white))
            .fillMaxWidth()
            .height(EXPANDED_TOP_BAR_HEIGHT)
            .zIndex(1f),
        Alignment.BottomStart
    ) {
        AsyncImage(
            model = "",
            contentDescription = "LargeTopBar",
            placeholder = topBarImage,
            error = topBarImage,
            contentScale = ContentScale.FillBounds
        )
        Text(
            text = title,
            modifier = Modifier.padding(16.dp),
            color = titleColor,
            style = MaterialTheme.typography.titleLarge,
        )
        FloatingActionButton(
            onClick = { onFabClick() },
            modifier = Modifier.offset((screenWidth.minus(100.dp)), 30.dp),
            containerColor = colorResource(R.color.lunoBlue),
        ) {
            Icon(Icons.Filled.Add, "Add")
        }
    }
}

@Composable
private fun CollapsedTopBar(
    modifier: Modifier = Modifier,
    title: String = "",
    titleColor: Color = Color.Unspecified,
    isCollapsed: Boolean
) {
    Box(
        modifier
            .background(colorResource(R.color.lunoBlue))
            .fillMaxWidth()
            .height(COLLAPSED_TOP_BAR_HEIGHT)
            .padding(16.dp)
            .zIndex(if (isCollapsed) 1f else 0f),
        Alignment.TopStart
    ) {
        AnimatedVisibility(isCollapsed) {
            Text(
                text = title,
                color = titleColor,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun LargeTopBarView(
    modifier: Modifier = Modifier,
    title: String = "",
    expandedTitleColor: Color = Color.Unspecified,
    collapsedTitleColor: Color = Color.Unspecified,
    topBarImage: Painter = painterResource(R.drawable.placeholder),
    itemList: List<Item> = emptyList(),
    onFabClick: () -> Unit,
    onItemClick: (item: Item) -> Unit
) {
    val listState = rememberLazyListState()

    val overlapHeightPx = with(LocalDensity.current) {
        EXPANDED_TOP_BAR_HEIGHT.toPx() - COLLAPSED_TOP_BAR_HEIGHT.toPx()
    }
    val isCollapsed: Boolean by remember {
        derivedStateOf {
            val isFirstItemHidden = listState.firstVisibleItemScrollOffset > overlapHeightPx
            isFirstItemHidden || listState.firstVisibleItemIndex > 0
        }
    }
    Box {
        CollapsedTopBar(title = title, titleColor = collapsedTitleColor, isCollapsed = isCollapsed)
        LazyColumn(state = listState) {
            item {
                LargeTopBar(
                    modifier = modifier,
                    title = title,
                    titleColor = expandedTitleColor,
                    topBarImage = topBarImage
                ) { onFabClick() }
            }
            if (itemList.isNotEmpty()) {
                items(
                    count = itemList.size,
                    key = { itemList[it].id }
                ) {
                    itemList.forEach {
                        CustomCardItemView(
                            item = it,
                            onFavoriteClick = { }
                        ) {
                            onItemClick(it)
                        }
                    }
                }
            } else {
                item {
                    Text(
                        text = stringResource(R.string.no_favourite_items),
                        Modifier.padding(20.dp, 10.dp),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LargeTopBarWithItemListPreview() {
    LargeTopBarView(
        onFabClick = {}
    ) {}
}