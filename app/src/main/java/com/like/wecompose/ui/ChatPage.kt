package com.like.wecompose.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.like.wecompose.WeViewModel
import kotlin.math.roundToInt

@Composable
fun ChatPage(modifier: Modifier = Modifier) {
    val viewModel: WeViewModel = viewModel()
    val offsetPercentX by animateFloatAsState(targetValue = if (viewModel.chatting) 0f else 1f)
    val offsetPercentY by animateFloatAsState(targetValue = if (viewModel.chatting) 0f else 1f)
    val chat = viewModel.currentChat
    if (chat != null) {
        Column(
            modifier = modifier
                .offsetPercent(offsetPercentX, offsetPercentY)
                .background(MaterialTheme.colors.background)
                .fillMaxSize()
        ) {
            WeTopBar(title = chat.friend.name) {
                viewModel.endChat()
            }
        }
    }
}

fun Modifier.offsetPercent(offsetPercentX: Float = 0f, offsetPercentY: Float = 0f): Modifier = this.layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    val offsetX = (offsetPercentX * placeable.width).roundToInt()
    val offsetY = (offsetPercentY * placeable.height).roundToInt()
    layout(placeable.width, placeable.height) {
        placeable.placeRelative(offsetX, offsetY)
    }
}