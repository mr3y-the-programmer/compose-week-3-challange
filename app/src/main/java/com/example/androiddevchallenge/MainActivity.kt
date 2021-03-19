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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.androiddevchallenge.ui.navigation.Navigator
import com.example.androiddevchallenge.ui.navigation.Screen
import com.example.androiddevchallenge.ui.screens.Home
import com.example.androiddevchallenge.ui.screens.LogIn
import com.example.androiddevchallenge.ui.screens.Welcome
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    @ExperimentalComposeUiApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // request drawing behind system bars
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun MyApp() {
    val navigator by rememberSaveable { mutableStateOf(Navigator(Screen.Welcome)) }
    val screen by navigator.currentScreen.observeAsState()
    when (screen) {
        Screen.Welcome -> AnimatedContent(screen == Screen.Welcome, initiallyVisible = true) { Welcome{ navigator.navigateTo(Screen.LogIn) } }
        Screen.LogIn -> AnimatedContent(screen == Screen.LogIn) { LogIn{ navigator.navigateTo(Screen.Home) } }
        Screen.Home -> AnimatedContent(screen == Screen.Home) { Home() }
    }
}

@ExperimentalAnimationApi
@Composable
fun AnimatedContent(
    enabled: Boolean,
    initiallyVisible: Boolean = false,
    content: @Composable () -> Unit
) {
    AnimatedVisibility(
        visible = enabled,
        modifier = Modifier.fillMaxSize(),
        enter = slideInHorizontally(initialOffsetX = { it }),
        exit = slideOutHorizontally(targetOffsetX = { it }),
        content = { content() },
        initiallyVisible = initiallyVisible
    )
}

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
