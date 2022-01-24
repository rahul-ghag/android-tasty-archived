package com.rahulghag.tasty.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rahulghag.tasty.R

@Composable
fun ErrorScreen() {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.error_internet_not_available),
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(
                modifier = Modifier
                    .height(4.dp)
            )
            TextButton(onClick = {

            }) {
                Text(
                    text = "Try Again",
                    color = MaterialTheme.colors.primary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}