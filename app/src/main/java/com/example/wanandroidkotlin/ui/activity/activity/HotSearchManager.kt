package com.example.wanandroidkotlin.ui.activity.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.widget.Toolbar
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.base.BaseActivity
import com.example.wanandroidkotlin.util.InfoBarManager
import kotlinx.android.synthetic.main.hot_search_manager.*
import android.widget.Toast
import android.widget.TextView
import com.zhy.view.flowlayout.TagFlowLayout
import com.zhy.view.flowlayout.TagFlowLayout.OnTagClickListener

import android.view.View
import com.example.wanandroidkotlin.api.RetrofitUtil
import com.example.wanandroidkotlin.bean.HotSearchEntity
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class HotSearchManager :BaseActivity(),InfoBarManager {
    override val toolbar by lazy{findViewById<Toolbar>(R.id.toolbarinfo)}
             val tagflow by lazy{findViewById<TagFlowLayout>(R.id.tagfl)}
             var hot:MutableList<String> =ArrayList()


    val name =
        arrayOf("#990033", "#CC6699", "#99FFFF", "#66FF66", "#99CC00", "#FF00FF", "#FFCCFF", "#663399", "#FF0000")
    override fun getLayout(): Int {
        return R.layout.hot_search_manager
    }

    override fun initData() {
        initToolbarInfoManager("Hot")//设置头部
        RetrofitUtil.retrofitService.gethotsearch().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({result->
                var size = result.data.size
                for(i in 0..size){
                    hot.add(result.data.get(i).name)//添加到数组中
                    var tag = object : TagAdapter<String>(hot) {
                        override fun getView(parent: FlowLayout, position: Int, o: String): View {
                            val view = LayoutInflater.from(this@HotSearchManager).inflate(R.layout.hotsearch_item, parent, false) as TextView
                            view.text = o
                            view.setTextColor(Color.parseColor(name[position]))
                            return view
                        }
                    }
                    tagflow.setAdapter(tag)//设置上适配器
                    tagflow.setOnTagClickListener(object :TagFlowLayout.OnTagClickListener{
                        override fun onTagClick(view: View?, position: Int, parent: FlowLayout?): Boolean {
                           var title = hot.get(position)
                            return false
                        }

                    })
                }

            },{error->

            })



    }




}
