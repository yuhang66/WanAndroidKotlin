package com.example.wanandroidkotlin.ui.activity.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.adapter.KnolagePagerAdapter
import com.example.wanandroidkotlin.base.BaseFragment
import com.example.wanandroidkotlin.bean.KonlageEntity
import com.example.wanandroidkotlin.presenter.impl.KnolagepresenterImpl
import com.example.wanandroidkotlin.view.KnolageView
import kotlinx.android.synthetic.main.knolage_page_fragment.*

class KnolagePagerFragment: BaseFragment() {


    var list: MutableList<KonlageEntity.DataBean.ChildrenBean> = ArrayList()

    override fun initView(): View {
        return View.inflate(context, R.layout.knolage_page_fragment, null)

    }

    override fun initData() {
        val bundle = this@KnolagePagerFragment.getArguments()
        var data = bundle?.getSerializable("msg") as KonlageEntity.DataBean
        list.addAll(data.children)
        val adapter = KnolagePagerAdapter(list, childFragmentManager)
        viewpager.adapter = adapter
        viewpager.setOffscreenPageLimit(list.size)
        tablayout.setupWithViewPager(viewpager)


    }
}