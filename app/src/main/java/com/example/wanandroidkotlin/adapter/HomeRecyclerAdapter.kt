package com.example.wanandroidkotlin.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.bean.HomeRecy



class HomeRecyclerAdapter(data: List<HomeRecy.DataBean.DatasBean>?) :
    BaseQuickAdapter<HomeRecy.DataBean.DatasBean, BaseViewHolder>(R.layout.home_rec_item,data) {
    override fun convert(helper: BaseViewHolder, item: HomeRecy.DataBean.DatasBean?) {
       item ?:return


        helper.setText(R.id.homeauthor,item.author)
            .setText(R.id.hometitle,item.title)
            .setText(R.id.hometype,item.chapterName)
            .setText(R.id.hometime,item.niceDate)
            .addOnClickListener(R.id.homeItemLike)

    }
}