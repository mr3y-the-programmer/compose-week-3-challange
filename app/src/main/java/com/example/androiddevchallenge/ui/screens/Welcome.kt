package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.gray900
import com.example.androiddevchallenge.ui.theme.white
import com.example.androiddevchallenge.ui.theme.yellow


@Composable
fun Welcome() {
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
            pushStyle(SpanStyle(
                fontWeight = FontWeight.Thin
            ))
            append("We")
            pop()
            pushStyle(
                SpanStyle(
                    fontWeight = FontWeight.Medium
            ))
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
                onClick = { /*TODO*/ },
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
                onClick = { /*TODO*/ },
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
        Welcome()
    }
}

@Preview(widthDp = 360, heightDp = 640, name = "Dark Theme")
@Composable
fun WelcomePreviewDark() {
    MyTheme(darkTheme = true) {
        Welcome()
    }
}