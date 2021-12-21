package com.like.wecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.like.wecompose.ui.ChatList
import com.like.wecompose.ui.WeBottomBar
import com.like.wecompose.ui.theme.WeComposeTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeComposeTheme(false) {
                Column {
                    val viewModel: WeViewModel = viewModel()
                    HorizontalPager(count = 4) { page ->
                        when (page) {
                            0 -> ChatList(viewModel.chats)
                            1 -> Box(modifier = Modifier.fillMaxSize())
                            2 -> Box(modifier = Modifier.fillMaxSize())
                            3 -> Box(modifier = Modifier.fillMaxSize())
                        }

                    }
                    WeBottomBar(selected = viewModel.selectedTab) {
                        viewModel.selectedTab = it
                    }
                }
            }
        }
    }
}
