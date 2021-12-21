package com.like.wecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.lifecycle.viewmodel.compose.viewModel
import com.like.wecompose.ui.theme.WeComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeComposeTheme {
                Column {
                    val viewModel: WeViewModel = viewModel()
                    WeBottomBar(selected = viewModel.selectedTab){
                        viewModel.selectedTab = it
                    }
                }
            }
        }
    }
}
