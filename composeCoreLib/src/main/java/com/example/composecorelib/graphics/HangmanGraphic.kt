package com.example.composecorelib.graphics

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HangmanGraphic(
    modifier: Modifier = Modifier,
    drawStructure: Boolean = false,
    drawHead: Boolean = false,
    drawBody: Boolean = false,
    drawRightArm: Boolean = false,
    drawLeftArm: Boolean = false,
    drawRightLeg: Boolean = false,
    drawLeftLeg: Boolean = false,
    structureColor: Color = Color.Black,
    hangmanColor: Color = Color.Red
) {
    val angleOffset = 3f
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val angle by infiniteTransition.animateFloat(
        initialValue = -angleOffset,
        targetValue = angleOffset,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 3000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse,
        ), label = ""
    )

    Box {
        Canvas(
            modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            val width = size.width
            val height = size.height

            if (drawStructure) {
                drawLine(
                    start = Offset(x = width / 3, y = 100f),
                    end = Offset(x = width / 3, y = height / 1.1f),
                    color = structureColor,
                    strokeWidth = 10f,
                )
                drawLine(
                    start = Offset(x = width / 3, y = height / 1.1f),
                    end = Offset(x = width / 2, y = height / 1.1f),
                    color = structureColor,
                    strokeWidth = 10f
                )
                drawLine(
                    start = Offset(x = width / 3, y = height / 1.1f),
                    end = Offset(x = width / 6, y = height / 1.1f),
                    color = structureColor,
                    strokeWidth = 10f
                )
                drawLine(
                    start = Offset(x = width / 3, y = 100f),
                    end = Offset(x = width / 1.5f, y = 100f),
                    color = structureColor,
                    strokeWidth = 10f
                )

                drawLine(
                    start = Offset(x = width / 2, y = 100f),
                    end = Offset(x = width / 3, y = 220f),
                    color = structureColor,
                    strokeWidth = 10f
                )


            }
        }

        Canvas(
            modifier
                .fillMaxWidth()
                .height(300.dp)
                .graphicsLayer(
                    transformOrigin = TransformOrigin(
                        pivotFractionX = 0.6f,
                        pivotFractionY = 0.1f,
                    ),
                    rotationZ = angle
                )
        ) {
            val width = size.width
            val height = size.height

            drawLine(
                start = Offset(x = width / 1.5f, y = 100f),
                end = Offset(x = width / 1.5f, y = 220f),
                color = structureColor,
                strokeWidth = 10f
            )

            if (drawHead) {
                drawCircle(
                    center = Offset(x = width / 1.5f, y = 270f),
                    color = hangmanColor,
                    radius = 20.dp.toPx()
                )
            }

            if (drawBody) {
                drawLine(
                    start = Offset(x = width / 1.5f, y = 320f),
                    end = Offset(x = width / 1.5f, y = 520f),
                    color = hangmanColor,
                    strokeWidth = 10f
                )
            }

            if (drawRightArm) {
                drawLine(
                    start = Offset(x = width / 1.5f, y = 420f),
                    end = Offset(x = width / 1.38f, y = 420f),
                    color = hangmanColor,
                    strokeWidth = 10f
                )
            }

            if (drawLeftArm) {
                drawLine(
                    start = Offset(x = width / 1.5f, y = 420f),
                    end = Offset(x = width / 1.65f, y = 420f),
                    color = hangmanColor,
                    strokeWidth = 10f
                )
            }

            if (drawRightLeg) {
                drawLine(
                    start = Offset(x = width / 1.5f, y = 520f),
                    end = Offset(x = width / 1.3f, y = 620f),
                    color = hangmanColor,
                    strokeWidth = 10f
                )
            }

            if (drawLeftLeg) {
                drawLine(
                    start = Offset(x = width / 1.5f, y = 520f),
                    end = Offset(x = width / 1.7f, y = 620f),
                    color = hangmanColor,
                    strokeWidth = 10f
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HangmanGraphicPreview() {
    HangmanGraphic(
        drawStructure = true,
        drawHead = true,
        drawBody = true,
        drawRightArm = true,
        drawRightLeg = true,
        drawLeftLeg = true,
        drawLeftArm = true
    )
}