package com.example.wanandroidkotlin.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.bean.NomalSearchEntity

class NomalSearchAdapter(data:List<NomalSearchEntity.DataBean.DatasBean>?):BaseQuickAdapter<NomalSearchEntity.DataBean.DatasBean,BaseViewHolder>(
    R.layout.home_rec_item,data) {
    override fun convert(helper: BaseViewHolder, item: NomalSearchEntity.DataBean.DatasBean?) {
        item?:return
        helper.setText(R.id.homeauthor,item.author)
              .setText(R.id.hometime,item.niceDate)
              .setText(R.id.hometitle,item.title)
              .setText(R.id.hometype,item.chapterName)
              .addOnClickListener(R.id.hometou)

    }
}