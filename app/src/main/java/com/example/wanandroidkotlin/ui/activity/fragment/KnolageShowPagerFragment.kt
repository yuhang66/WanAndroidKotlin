package com.example.wanandroidkotlin.ui.activity.fragment

import android.content.Intent
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.adapter.KnolageInfoTypeAdapter
import com.example.wanandroidkotlin.base.BaseFragment
import com.example.wanandroidkotlin.bean.KnolageSystemType
import com.example.wanandroidkotlin.presenter.impl.KnolagepresenterImpl
import com.example.wanandroidkotlin.ui.activity.activity.HomeInfo
import com.example.wanandroidkotlin.view.KnolageView
import kotlinx.android.synthetic.main.knolage_show_pager_fragment.*

class KnolageShowPagerFragment: BaseFragment(),KnolageView {

    val knolageimpl by lazy { KnolagepresenterImpl(this) }
    var data:MutableList<KnolageSystemType.DataBean.DatasBean> = ArrayList()
    override fun initView(): View {
        return View.inflate(context, R.layout.knolage_show_pager_fragment,null)
    }

    override fun init() {
        var cid = getArguments()?.getString("wakaka")
        knolageimpl.loadDatas(cid.toString())



    }
    override fun onError(toString: String) {
       Toast.makeText(context,toString,Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess(result: KnolageSystemType) {
         showpager_recycler.layoutManager = LinearLayoutManager(context)
         data.addAll(result.data.datas)
         showpager_recycler.adapter = KnolageInfoTypeAdapter(data)
        (showpager_recycler.adapter as KnolageInfoTypeAdapter).setOnItemClickListener { adapter, view, position ->
            var item:KnolageSystemType.DataBean.DatasBean = data.get(position)
            var intent: Intent = Intent(context, HomeInfo::class.java)
            intent.putExtra("title",item.title)
            intent.putExtra("link",item.link)
            startActivity(intent)

        }
    }
}