package com.example.wanandroidkotlin.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        initData()
        initListener()
    }

    open protected fun initListener() {

    }

    open protected fun initData() {

    }

    abstract fun getLayout(): Int
}