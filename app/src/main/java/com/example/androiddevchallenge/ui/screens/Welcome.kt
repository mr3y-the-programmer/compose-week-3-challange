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
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Welcome(onComplete: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.welcome_bg),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        val logoText = AnnotatedString.Builder().apply {
            pushStyle(
                SpanStyle(
                    fontWeight = FontWeight.Thin
                )
            )
            append("We")
            pop()
            pushStyle(
                SpanStyle(
                    fontWeight = FontWeight.Medium
                )
            )
            append("Trade")
            pop()
        }.toAnnotatedString()

        Text(
            text = logoText,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h1,
            modifier = Modifier.align(Alignment.Center)
        )

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(vertical = 32.dp)
                .height(48.dp) // TODO: adapt this height to different screen sizes
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            val modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
            val shape = MaterialTheme.shapes.large // based on the mockup, button use large shape
            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            TextButton(
                onClick = { onComplete() },
                modifier = modifier,
                shape = shape,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = MaterialTheme.colors.onPrimary
                )
            ) {
                Text(
                    text = "GET STARTED",
                    style = MaterialTheme.typography.button
                )
            }
            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            OutlinedButton(
                onClick = { onComplete() },
                modifier = modifier,
                shape = shape,
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = MaterialTheme.colors.primary
                ),
                border = BorderStroke(1.dp, MaterialTheme.colors.primary)
            ) {
                Text(
                    text = "LOG IN",
                    style = MaterialTheme.typography.button
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview(widthDp = 360, heightDp = 640, name = "Light Theme")
@Composable
fun WelcomePreview() {
    MyTheme {
        Welcome {}
    }
}

@Preview(widthDp = 360, heightDp = 640, name = "Dark Theme")
@Composable
fun WelcomePreviewDark() {
    MyTheme(darkTheme = true) {
        Welcome {}
    }
}
