package com.rahulghag.tasty.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val Gray100 = Color(0XFFF6F6F6)
val Gray900 = Color(0XFF2E2E2E)

val Colors.bottomBarBackgroundColor: Color
    @Composable
    get() = if (isLight) Color.White else Gray900

val Colors.bottomBarSelectedContentColor: Color
    @Composable
    get() = if (isLight) primary else onSurface

val Colors.searchBarBackgroundColor: Color
    @Composable
    get() = if (isLight) Gray100 else Gray900

val Colors.topAppBarBackgroundColor: Color
    @Composable
    get() = if (isLight) Color.White else surface

val Colors.topAppBarContentColor: Color
    @Composable
    get() = if (isLight) primary else onSurface