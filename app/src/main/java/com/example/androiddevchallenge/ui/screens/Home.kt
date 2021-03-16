package com.example.androiddevchallenge.ui.screens

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.green
import com.example.androiddevchallenge.ui.theme.red
import com.example.androiddevchallenge.ui.theme.white

@Composable
fun Home() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        var tab by remember { mutableStateOf(Tab.Account) }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            (0..2).forEach {
                TabButton(index = it, selected = it == tab.ordinal) {
                    tab = Tab.values()[it]
                }
            }
        }
        Crossfade(targetState = tab) {
            when (it) {
                Tab.Account -> AccountPage()
                Tab.WatchList -> WatchListPage()
                Tab.Profile -> ProfilePage()
            }
        }
    }
}
 
@Composable
fun AccountPage(modifier: Modifier = Modifier) {
    val boxScrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(boxScrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Balance",
            modifier = Modifier.paddingFrom(FirstBaseline, before = 32.dp, after = 8.dp),
            style = MaterialTheme.typography.subtitle1,
            color = white
        )
        Text(
            text = "$73,589.01",
            modifier = Modifier.paddingFrom(FirstBaseline, before = 48.dp, after = 24.dp),
            style = MaterialTheme.typography.h1,
            color = white
        )
        Text(
            text = "+412.35 today",
            modifier = Modifier.paddingFrom(FirstBaseline, before = 16.dp, after = 32.dp),
            style = MaterialTheme.typography.subtitle1,
            color = green
        )
        TextButton(
            onClick = { /*TODO*/ },
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
                text = "TRANSACT",
                style = MaterialTheme.typography.button
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        val rowScrollState = rememberScrollState()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .horizontalScroll(rowScrollState),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Spacer(modifier = Modifier.width(16.dp))
            (0..4).forEach {
                Chip(
                    withIcon = it == 0, // add icon only for first item
                    text = chips[it],
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(if (it == 0) 80.dp else 72.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.home_illos),
                contentDescription = "Your account balance graph in last weeks",
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 32.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
        }
        PositionsList(modifier = Modifier.fillMaxWidth())
    }
}


@Composable
fun PositionsList(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.background(MaterialTheme.colors.surface),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.surface,
                contentColor = MaterialTheme.colors.onSurface
            )
        ) {
            Text(
                text = "Positions",
                modifier = Modifier.paddingFrom(FirstBaseline, before = 20.dp, after = 24.dp),
                style = MaterialTheme.typography.subtitle1
            )
        }
        for (position in positions) {
            PositionItem(
                position = position,
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(0.95f)
            )
        }
    }
}

@Composable
private fun PositionItem(position: Position, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Divider(
            thickness = (1.5).dp,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.fillMaxHeight(0.05f)
        )
        Row(
            modifier = Modifier.fillMaxHeight(0.95f),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(0.5f)) {
                Text(
                    text = position.balance,
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.paddingFrom(FirstBaseline, before = 24.dp)
                )
                Spacer(modifier = Modifier.height(1.dp))
                val percentage = position.percentage
                Text(
                    text = percentage,
                    color = if (percentage.startsWith("+")) green else red,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.paddingFrom(FirstBaseline, before = 16.dp, after = 16.dp)
                )
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = position.nickName,
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier.paddingFrom(FirstBaseline, before = 24.dp)
                )
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = position.name,
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.paddingFrom(FirstBaseline, before = 16.dp, after = 16.dp)
                )
            }
            Image(
                painter = painterResource(id = position.drawableId),
                contentDescription = null,
                modifier = Modifier.weight(0.5f)
            )
        }
    }
}

@Composable
private fun Chip(text: String, withIcon: Boolean, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.large.copy(CornerSize(20.dp)),
        backgroundColor = Color.Transparent,
        contentColor = white,
        border = BorderStroke(1.dp, white)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = text, style = MaterialTheme.typography.body1)
            if (withIcon) {
                Icon(
                    imageVector = Icons.Filled.ExpandMore,
                    contentDescription = "Expand to Select a specific week",
                    modifier = Modifier.size(15.dp)
                )
            }
        }
    }
}

@Composable
fun WatchListPage(modifier: Modifier = Modifier) {
    Box(modifier = modifier)
}

@Composable
fun ProfilePage(modifier: Modifier = Modifier) {
    Box(modifier = modifier)
}

@Composable
private fun TabButton(
    index: Int,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val alpha by animateFloatAsState(targetValue = if (selected) 1f else 0.5f)
    OutlinedButton(
        onClick = { onClick() },
        modifier = modifier,
        border = BorderStroke(0.dp, Color.Transparent),
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color.Transparent,
            contentColor = white.copy(alpha = alpha)
        )
    ) {
        Text(
            text = Tab.values()[index].name.toUpperCase(), // Temporary workaround, style should uppercase it
            style = MaterialTheme.typography.button,
            modifier = Modifier.paddingFrom(FirstBaseline, before = 64.dp, 8.dp)
        )
    }
}

enum class Tab{
    Account,
    WatchList,
    Profile
}

 
@Preview(widthDp = 360, heightDp = 640, name = "Light Theme")
@Composable
fun HomePreview() {
    MyTheme {
        Home()
    }
}

 
@Preview(widthDp = 360, heightDp = 640, name = "Dark Theme")
@Composable
fun HomePreviewDark() {
    MyTheme(darkTheme = true) {
        Home()
    }
}