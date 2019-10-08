package com.example.wanandroidkotlin.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.bean.KonlageEntity

class KnolageAdapter(data:List<KonlageEntity.DataBean>):BaseQuickAdapter<KonlageEntity.DataBean,BaseViewHolder>(R.layout.knolage_item,data) {
    override fun convert(helper: BaseViewHolder, item: KonlageEntity.DataBean) {
        helper.setText(R.id.typeItemFirst, item.name)
        item.children?.let { children ->
            helper.setText(
                R.id.typeItemSecond,
                children.joinToString("     ", transform = { child ->
                    child.name
                })
            )
        }
    }

}