package com.example.wanandroidkotlin.util

import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.example.wanandroidkotlin.R

interface KnolageBarManager {
    val toolbar :Toolbar

    fun initKnolageBar(title:String){
        toolbar.setTitle(title)
        toolbar.inflateMenu(R.menu.knolage)//加载布局
        toolbar.setOnMenuItemClickListener(object :Toolbar.OnMenuItemClickListener{
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when(item?.itemId){
                    R.id.knolage_item_search->{

                    }
                    R.id.knolage_item_share->{

                    }
                }
                return true
            }

        })
    }
}