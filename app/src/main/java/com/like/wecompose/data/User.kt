package com.like.wecompose.data

import androidx.annotation.DrawableRes
import com.like.wecompose.R

class User(val id: String, val name: String, @DrawableRes val avatar: Int) {
    companion object {
        val Me: User = User("id0", "like", R.mipmap.ic_account)
        val LaoWang: User = User("id1", "老王", R.mipmap.ic_account)
        val HaHa: User = User("id2", "哈哈", R.mipmap.ic_account)
    }
}