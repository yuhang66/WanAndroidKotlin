package com.example.wanandroidkotlin.view

import com.example.wanandroidkotlin.bean.KnolageSystemType

interface KnolageView {
    fun onError(toString: String)//回掉失败
    fun onSuccess(result: KnolageSystemType)//回掉成功
}