package com.example.wanandroidkotlin.util

import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.wanandroidkotlin.R

interface InfoBarManager {
    val toolbar: Toolbar

    fun  initToolbarInfoManager(title:String){//详情页面加载标题以及返回

        toolbar.setTitle(title)
        toolbar.inflateMenu(R.menu.info)//加载布局
        toolbar.setOnMenuItemClickListener(object :Toolbar.OnMenuItemClickListener{
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when(item?.itemId){
                    R.id.menuShare->{
                        Toast.makeText(toolbar.context,"share",Toast.LENGTH_SHORT).show()

                    }
                        R.id.menuLike->{
                            Toast.makeText(toolbar.context,"like",Toast.LENGTH_SHORT).show()

                        }
                }

                return true
            }

        })

    }
}