package com.example.wanandroidkotlin.util

import android.content.Intent
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat.startActivity
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.ui.activity.activity.HotSearchManager
import com.example.wanandroidkotlin.ui.activity.activity.MainActivity
import com.example.wanandroidkotlin.ui.activity.activity.NomalSearchManager

interface ToolBarManager {
    val toolbar:Toolbar

    fun initMainToolBar(mainActivity: MainActivity) {
        toolbar.setTitle("玩Android")
        toolbar.inflateMenu(R.menu.mian)
        toolbar.setOnMenuItemClickListener(object :Toolbar.OnMenuItemClickListener{
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when(item?.itemId){
                    R.id.setting->{
                        var intent = Intent(mainActivity, HotSearchManager::class.java)
                        mainActivity.startActivity(intent)
                    }
                    R.id.search->{
                        var intent = Intent(mainActivity, NomalSearchManager::class.java)
                        mainActivity.startActivity(intent)
                    }
                }
                return true
            }

        })
    }


}