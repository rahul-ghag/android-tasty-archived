package com.rahulghag.tasty.presentation.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.rahulghag.tasty.ui.theme.topAppBarBackgroundColor
import com.rahulghag.tasty.ui.theme.topAppBarContentColor

@Composable
fun TopBar(
    title: @Composable () -> Unit,
    onNavigationIconClick: () -> Unit,
    actions: @Composable RowScope.() -> Unit = {},
) {
    TopAppBar(
        title = title,
        navigationIcon = {
            IconButton(onClick = {
                onNavigationIconClick()
            }) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = null,
                    tint = MaterialTheme.colors.topAppBarContentColor,
                )
            }
        },
        actions = actions,
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        elevation = 0.dp
    )
}