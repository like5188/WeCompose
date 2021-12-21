package com.like.wecompose.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.like.wecompose.R

@Composable
fun WeBottomBar(selected: Int, onSelectedChanged: (Int) -> Unit) {
    Row {
        TabItem(
            iconId = R.mipmap.nav_home,
            title = "聊天",
            tint = if (selected == 0) MaterialTheme.colors.error else MaterialTheme.colors.background,
            modifier = Modifier
                .weight(1f)
                .clickable {
                    onSelectedChanged(0)
                }
        )
        TabItem(
            iconId = R.mipmap.nav_project,
            title = "发现",
            tint = if (selected == 1) MaterialTheme.colors.error else MaterialTheme.colors.background,
            modifier = Modifier
                .weight(1f)
                .clickable {
                    onSelectedChanged(1)
                }
        )
        TabItem(
            iconId = R.mipmap.nav_system,
            title = "通讯录",
            tint = if (selected == 2) MaterialTheme.colors.error else MaterialTheme.colors.background,
            modifier = Modifier
                .weight(1f)
                .clickable {
                    onSelectedChanged(2)
                }
        )
        TabItem(
            iconId = R.mipmap.nav_mine,
            title = "我",
            tint = if (selected == 3) MaterialTheme.colors.error else MaterialTheme.colors.background,
            modifier = Modifier
                .weight(1f)
                .clickable {
                    onSelectedChanged(3)
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WeBottomBarPreview() {
    var selectedTab by remember { mutableStateOf(0) }
    WeBottomBar(selectedTab) {
        selectedTab = it
    }
}

@Composable
fun TabItem(@DrawableRes iconId: Int, title: String, tint: Color, modifier: Modifier = Modifier) {
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
    TabItem(iconId = R.mipmap.nav_home, title = "聊天", tint = MaterialTheme.colors.primary)
}