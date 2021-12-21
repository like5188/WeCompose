package com.like.wecompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.like.wecompose.data.Chat

@Composable
fun ChatList(chats: List<Chat>) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.secondary)
            .fillMaxSize()
    ) {
        LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
            itemsIndexed(chats) { index, chat ->
                ChatListItem(chat)
                if (index < chats.lastIndex) {
                    Divider(
                        startIndent = 68.dp,
                        color = MaterialTheme.colors.secondary,
                        thickness = 0.5f.dp
                    )
                }
            }
        }
    }
}

@Composable
private fun ChatListItem(chat: Chat) {
    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = chat.friend.avatar),
            contentDescription = chat.friend.name,
            modifier = Modifier
                .padding(8.dp)
                .size(48.dp)
                .unRead(!chat.msgs.last().read, MaterialTheme.colors.error)
                .clip(RoundedCornerShape(4.dp))

        )
        Column(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Text(text = chat.friend.name, fontSize = 17.sp, color = MaterialTheme.colors.primary)
            Text(text = chat.msgs.last().text, fontSize = 14.sp, color = MaterialTheme.colors.secondary)
        }
        Text(
            text = chat.msgs.last().time,
            fontSize = 11.sp,
            color = MaterialTheme.colors.secondary,
            modifier = Modifier.padding(8.dp, 8.dp, 12.dp, 8.dp)
        )
    }
}

fun Modifier.unRead(show: Boolean, color: Color): Modifier = this.drawWithContent {
    drawContent()
    if (show) {
        drawCircle(
            color = color,
            radius = 5.dp.toPx(),
            center = Offset(size.width - 1.dp.toPx(), 1.dp.toPx()),
        )
    }
}
