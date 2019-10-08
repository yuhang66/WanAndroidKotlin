package com.example.wanandroidkotlin.ui.activity.activity

import androidx.appcompat.widget.Toolbar
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.base.BaseActivity
import com.example.wanandroidkotlin.util.FragmentUtil

import com.example.wanandroidkotlin.util.ToolBarManager

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),ToolBarManager {

    override val toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }
    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        initMainToolBar(this)//自定义Toolbar
    }

    override fun initListener() {//设置切换碎片
        bottomBar.setOnTabSelectListener {
            val transaction =  supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, FragmentUtil.fragmentUtil.getFragment(it)!!,it.toString())
            transaction.commit()
        }
    }

}
