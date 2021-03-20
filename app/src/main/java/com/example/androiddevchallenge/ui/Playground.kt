/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
