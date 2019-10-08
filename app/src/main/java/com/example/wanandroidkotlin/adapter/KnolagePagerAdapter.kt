package com.example.wanandroidkotlin.adapter

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.example.wanandroidkotlin.bean.KonlageEntity
import com.example.wanandroidkotlin.ui.activity.activity.KnolagePagerManager
import com.example.wanandroidkotlin.ui.activity.fragment.KnolageShowPagerFragment

import java.util.*

class KnolagePagerAdapter(val list: List<KonlageEntity.DataBean.ChildrenBean>,fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
          var fragment = KnolageShowPagerFragment()
          var bundle = Bundle()
          bundle.putString("wakaka",list.get(position).id)
          fragment.arguments = bundle
          return fragment

    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return list.get(position).name
    }

}