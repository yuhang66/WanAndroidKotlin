package com.example.wanandroidkotlin.view

import com.example.wanandroidkotlin.bean.NomalSearchEntity

interface SearchView {
    fun click()//所有事件的点击事件
    fun searchAccess(result: NomalSearchEntity)//搜索成功事件回掉
    fun searchError(toString: String)//搜索失败
    fun initSearch()//搜索前初始化

}