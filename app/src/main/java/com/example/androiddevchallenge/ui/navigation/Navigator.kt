package com.example.androiddevchallenge.ui.navigation

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

/* TODO: you can safely remove navigator and use screen state directly, like:
        val screen by rememberSaveable{ mutableStateOf(Screen.Welcome) }
        onWelcomeComplete{ screen = Screen.LogIn }  */
@Parcelize
class Navigator(private val initialScreen: Screen) : Parcelable {

    @IgnoredOnParcel
    private val _currentScreen = MutableLiveData(initialScreen)
    val currentScreen: LiveData<Screen>
        get() = _currentScreen

    fun navigateTo(screen: Screen) {
        _currentScreen.value = screen
    }
}

enum class Screen {
    Welcome,
    LogIn,
    Home
}