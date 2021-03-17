package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Password
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.white

@ExperimentalComposeUiApi
@Composable
fun LogIn(onComplete: () -> Unit) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colors.surface)) {
        Image(
            painter = painterResource(id = R.drawable.login_bg),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome\nback",
                style = MaterialTheme.typography.h2,
                color = white,
                textAlign = TextAlign.Center,
                modifier = Modifier.paddingFrom(FirstBaseline, before = 152.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .align(BiasAlignment(-1f, 1f)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            LogInTextField(
                text = "",
                icon = Icons.Outlined.MailOutline,
                label = "Email address",
                contentDescription = "Enter your email"
            )
            Spacer(modifier = Modifier.height(8.dp))
            LogInTextField(
                text = "",
                icon = Icons.Outlined.Password,
                label = "Password",
                contentDescription = "Enter your password",
                visualTransformation = PasswordVisualTransformation(),
                onComplete = { onComplete() }
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextButton(
                onClick = { onComplete() },
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(0.9f),
                shape = MaterialTheme.shapes.large,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = MaterialTheme.colors.onPrimary
                )
            ) {
                Text(
                    text = "LOG IN",
                    style = MaterialTheme.typography.button
                )
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
private fun LogInTextField(
    text: String,
    icon: ImageVector,
    label: String,
    contentDescription: String,
    visualTransformation: VisualTransformation? = null,
    onComplete: (() -> Unit)? = null
) {
    val imeAction = onComplete?.let { ImeAction.Done } ?: ImeAction.Next
    val controller = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        value = text,
        onValueChange = { /*TODO*/ },
        textStyle = MaterialTheme.typography.body1,
        keyboardOptions = KeyboardOptions(imeAction = imeAction),
        keyboardActions = KeyboardActions(
            onDone = {
                controller?.hideSoftwareKeyboard()
                onComplete?.invoke()
            }
        ),
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = MaterialTheme.colors.onSurface
        ),
        placeholder = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = contentDescription,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = label,
                    style = MaterialTheme.typography.body1,
                )
            }
        },
        visualTransformation = visualTransformation ?: VisualTransformation.None,
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth(0.9f)
            .clip(shape = MaterialTheme.shapes.small)
            .semantics(mergeDescendants = true) {
                this.contentDescription = contentDescription
            }
    )
}

@ExperimentalComposeUiApi
@Preview(widthDp = 360, heightDp = 640, name = "Light Theme")
@Composable
fun LogInPreview() {
    MyTheme {
        LogIn{}
    }
}

@ExperimentalComposeUiApi
@Preview(widthDp = 360, heightDp = 640, name = "Dark Theme")
@Composable
fun LogInPreviewDark() {
    MyTheme(darkTheme = true) {
        LogIn{}
    }
}