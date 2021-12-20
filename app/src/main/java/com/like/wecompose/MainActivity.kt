package com.like.wecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.like.wecompose.ui.theme.WeComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeComposeTheme {
                Column {


                }
            }
        }
    }
}

@Composable
fun WeBottomBar(selected: Int) {
    Row {
        TabItem(
            iconId = R.mipmap.nav_home,
            title = "聊天",
            tint = if (selected == 0) Color.Green else Color.Black,
            modifier = Modifier.weight(1f)
        )
        TabItem(
            iconId = R.mipmap.nav_project,
            title = "发现",
            tint = if (selected == 1) Color.Green else Color.Black,
            modifier = Modifier.weight(1f)
        )
        TabItem(
            iconId = R.mipmap.nav_system,
            title = "通讯录",
            tint = if (selected == 2) Color.Green else Color.Black,
            modifier = Modifier.weight(1f)
        )
        TabItem(
            iconId = R.mipmap.nav_mine,
            title = "我",
            tint = if (selected == 3) Color.Green else Color.Black,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WeBottomBarPreview() {
    WeBottomBar(0)
}

@Composable
private fun TabItem(@DrawableRes iconId: Int, title: String, tint: Color, modifier: Modifier) {
    Column(
        modifier = modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(painterResource(id = iconId), contentDescription = title, tint = tint, modifier = Modifier.size(24.dp))
        Text(text = title, fontSize = 11.sp, color = tint)
    }
}

@Preview(showBackground = true)
@Composable
fun TabItemPreview() {
    TabItem(iconId = R.mipmap.nav_home, title = "聊天", tint = Color.Green, modifier = Modifier)
}
