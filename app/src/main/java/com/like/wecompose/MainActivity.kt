package com.like.wecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.like.wecompose.ui.ChatPage
import com.like.wecompose.ui.Home
import com.like.wecompose.ui.theme.WeComposeTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: WeViewModel = viewModel()
            WeComposeTheme(viewModel.darkTheme) {
                Box {
                    Home(viewModel)
                    ChatPage()
                }
            }
        }
    }
}
