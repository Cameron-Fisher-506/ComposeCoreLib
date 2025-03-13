package com.example.composecorelib.graphics

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecorelib.R

@Composable
fun CoinGraphic(
    modifier: Modifier = Modifier,
    coinSize: Int = 60,
    text: String = "$",
    textSize: Int = 60,
    textColor: Color = colorResource(R.color.darkGold),
    animate: Boolean = true,
    coinColor: Color = colorResource(R.color.gold)
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        val textMeasurer = rememberTextMeasurer()

        val style = TextStyle(
            fontSize = textSize.sp,
            color = textColor,
        )

        val textLayoutResult = remember(text) {
            textMeasurer.measure(text, style)
        }

        val infiniteTransition = rememberInfiniteTransition(label = "")
        val coinAnimationSize by infiniteTransition.animateValue(
            initialValue = (coinSize-20).dp,
            targetValue = (coinSize-25).dp,
            Dp.VectorConverter,
            animationSpec = infiniteRepeatable(
                animation = tween(500, easing = FastOutLinearInEasing),
                repeatMode = RepeatMode.Reverse
            ), label = ""
        )

        Canvas(
            modifier
                .width((coinSize+30).dp)
                .height((coinSize+30).dp)
        ) {
            drawCircle(
                color = coinColor,
                radius = if (animate) coinAnimationSize.toPx() else (coinSize-20).dp.toPx()
            )
            drawText(
                textMeasurer = textMeasurer,
                text = text,
                style = style,
                topLeft = Offset(
                    x = center.x - textLayoutResult.size.width / 2,
                    y = center.y - textLayoutResult.size.height / 2,
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoinGraphicPreview() {
    CoinGraphic(
        coinSize = 40,
        text = "1000",
        textSize = 10
    )
}