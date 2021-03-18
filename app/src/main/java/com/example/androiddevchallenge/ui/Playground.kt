package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
import com.example.androiddevchallenge.ui.theme.white

// although this is not used anywhere, i decided to keep it explicitly,
// because i was trying to replicate the provided image graph but with custom views
@Composable
fun Graph(
    modifier: Modifier = Modifier,
    numOfRows: Int = 4,
    numOfCellsInOneRow: Int = 8
) {
    Canvas(modifier = modifier) {
        val rectSize = size.copy(width = size.width * 4f, height = size.height * 8f) / (numOfRows.toFloat() * numOfCellsInOneRow.toFloat())
        for (i in 0 until numOfRows) {
            for (j in 0 until numOfCellsInOneRow) {
                drawRect(
                    style = Stroke(1f),
                    color = white.copy(alpha = 0.5f),
                    topLeft = Offset(x = j * rectSize.width, y = i * rectSize.height),
                    size = rectSize,
                )
            }
        }
    }
}