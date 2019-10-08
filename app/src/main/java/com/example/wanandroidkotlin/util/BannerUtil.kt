package com.example.wanandroidkotlin.util

import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer

interface BannerUtil {
    val banner :Banner
    fun initBanner(imgs:MutableList<String>,title:MutableList<String>){

    }
}