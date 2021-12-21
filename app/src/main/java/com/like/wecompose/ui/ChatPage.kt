package com.like.wecompose.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.like.wecompose.WeViewModel
import kotlin.math.roundToInt

@Composable
fun ChatPage() {
    val viewModel: WeViewModel = viewModel()
    val offsetPercentX by animateFloatAsState(targetValue = if (viewModel.chatting) 0f else 1f)
    val offsetPercentY by animateFloatAsState(targetValue = if (viewModel.chatting) 0f else 1f)
    Box(
        modifier = Modifier
            .offsetPercent(offsetPercentX, offsetPercentY)
            .background(Color.Red)
            .fillMaxSize()
    )
}

fun Modifier.offsetPercent(offsetPercentX: Float = 0f, offsetPercentY: Float = 0f): Modifier = this.layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    val offsetX = (offsetPercentX * placeable.width).roundToInt()
    val offsetY = (offsetPercentY * placeable.height).roundToInt()
    layout(placeable.width, placeable.height) {
        placeable.placeRelative(offsetX, offsetY)
    }
}