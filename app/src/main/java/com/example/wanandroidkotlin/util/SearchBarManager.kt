package com.example.wanandroidkotlin.util




import androidx.appcompat.widget.Toolbar
import com.example.wanandroidkotlin.R

interface SearchBarManager {
    val toolbar:Toolbar


    fun initSearchBarManager() {
        toolbar.inflateMenu(R.menu.search)


    }
}