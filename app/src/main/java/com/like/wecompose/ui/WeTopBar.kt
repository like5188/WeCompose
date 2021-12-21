package com.like.wecompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.like.wecompose.WeViewModel

@Composable
fun WeTopBar(title: String, onBack: (() -> Unit)? = null) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.height(48.dp)) {
                if (onBack != null) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack, contentDescription = "返回",
                        modifier = Modifier
                            .clickable(onClick = onBack)
                            .align(Alignment.CenterVertically)
                            .size(36.dp)
                            .padding(8.dp),
                        tint = MaterialTheme.colors.secondary
                    )
                }
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(1f),
                    color = MaterialTheme.colors.primary
                )
                val viewModel: WeViewModel = viewModel()
                Icon(
                    imageVector = Icons.Default.ThumbUp, contentDescription = "切换主题",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(36.dp)
                        .padding(8.dp),
                    tint = MaterialTheme.colors.secondary
                )
            }
            Divider(color = MaterialTheme.colors.secondary, thickness = 0.5f.dp)
        }
    }
}