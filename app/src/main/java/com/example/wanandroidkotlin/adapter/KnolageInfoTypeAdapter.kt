package com.example.wanandroidkotlin.adapter

import android.os.Parcel
import android.os.Parcelable
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.bean.KnolageSystemType

class KnolageInfoTypeAdapter(data:List<KnolageSystemType.DataBean.DatasBean>): BaseQuickAdapter<KnolageSystemType.DataBean.DatasBean, BaseViewHolder>(
    R.layout.home_rec_item,data) {
    override fun convert(helper: BaseViewHolder?, item: KnolageSystemType.DataBean.DatasBean?) {
        item?:return
        helper?.setText(R.id.homeauthor,item.author)
            ?.setText(R.id.hometime,item.niceDate)
            ?.setText(R.id.hometitle,item.title)
            ?.setText(R.id.hometype,item.chapterName)
    }

}