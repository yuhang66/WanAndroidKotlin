package com.example.wanandroidkotlin.view

import com.example.wanandroidkotlin.bean.BannerEntity
import com.example.wanandroidkotlin.bean.HomeRecy

interface HomeView {
    fun bannerSuccess(result: BannerEntity)
    fun shouitem(result: HomeRecy,currentPage:Int)

}