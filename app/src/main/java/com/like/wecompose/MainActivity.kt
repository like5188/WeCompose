package com.like.wecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import com.google.accompanist.pager.ExperimentalPagerApi
import com.like.wecompose.ui.ChatPage
import com.like.wecompose.ui.Home
import com.like.wecompose.ui.theme.WeComposeTheme

@OptIn(ExperimentalPagerApi::class)
class MainActivity : ComponentActivity() {
    private val viewModel: WeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeComposeTheme(viewModel.darkTheme) {
                Box {
                    Home(viewModel)
                    ChatPage()
                }
            }
        }
    }

    override fun onBackPressed() {
        if (!viewModel.endChat()) {
            super.onBackPressed()
        }
    }
}
