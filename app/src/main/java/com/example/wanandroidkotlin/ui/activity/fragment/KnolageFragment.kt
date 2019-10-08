package com.example.wanandroidkotlin.ui.activity.fragment

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.adapter.KnolageAdapter
import com.example.wanandroidkotlin.api.RetrofitUtil
import com.example.wanandroidkotlin.base.BaseFragment
import com.example.wanandroidkotlin.bean.KonlageEntity
import com.example.wanandroidkotlin.ui.activity.activity.KnolageInfo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.konlage_fragment.*

class KnolageFragment: BaseFragment() {
    var knolage:MutableList<KonlageEntity.DataBean>? = null
    override fun initView(): View {
        return View.inflate(context, R.layout.konlage_fragment,null)
    }

    override fun initData() {
        knolage = ArrayList()
        knolage_item.layoutManager = LinearLayoutManager(context)
        knolage_item.adapter = KnolageAdapter(knolage as ArrayList<KonlageEntity.DataBean>)
        RetrofitUtil.retrofitService.getknolage().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({result->
                knolage?.addAll(result.data)

                (knolage_item.adapter as KnolageAdapter).notifyDataSetChanged()
                (knolage_item.adapter as KnolageAdapter).setOnItemClickListener { adapter, view, position ->
                    var system: KonlageEntity.DataBean? = knolage?.get(position)
                    var intent = Intent(context, KnolageInfo::class.java)

                    intent.putExtra("duixianga",system)
                    startActivity(intent)
                }
            },{error->

            })
    }

}