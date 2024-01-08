package com.alcorp.ajher.utils

import androidx.appcompat.app.ActionBar

object Helper {
    fun setToolbar(actionBar: ActionBar, title: String) {
        actionBar.elevation = 0f
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.title = title
    }
}