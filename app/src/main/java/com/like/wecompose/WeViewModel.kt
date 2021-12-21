package com.like.wecompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.like.wecompose.data.Chat
import com.like.wecompose.data.Msg
import com.like.wecompose.data.User

class WeViewModel : ViewModel() {
    var currentChat: Chat? by mutableStateOf(null)
    var chatting by mutableStateOf(false)
    var darkTheme by mutableStateOf(true)
    var selectedTab by mutableStateOf(0)
    var chats by mutableStateOf(
        listOf(
            Chat(
                friend = User.LaoWang,
                mutableStateListOf(
                    Msg(User.LaoWang, "text1", "14:20"),
                    Msg(User.Me, "text2", "14:21"),
                    Msg(User.Me, "text3", "14:22"),
                    Msg(User.Me, "text4", "14:23"),
                    Msg(User.Me, "text5", "14:24"),
                )
            ),
            Chat(
                friend = User.HaHa,
                mutableStateListOf(
                    Msg(User.HaHa, "text1", "14:20"),
                    Msg(User.Me, "text2", "14:21"),
                    Msg(User.Me, "text3", "14:22"),
                    Msg(User.Me, "text4", "14:23"),
                    Msg(User.Me, "text5", "14:24").apply { read = false },
                )
            )
        )
    )

    fun startChat(chat: Chat) {
        chatting = true
        currentChat = chat
    }

    fun endChat(): Boolean {
        val result = chatting
        if (chatting) {
            chatting = false
        }
        return result
    }
}