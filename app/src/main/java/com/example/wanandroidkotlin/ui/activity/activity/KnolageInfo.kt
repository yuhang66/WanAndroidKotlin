package com.example.wanandroidkotlin.ui.activity.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentManager

import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.adapter.KnolagePagerAdapter
import com.example.wanandroidkotlin.base.BaseActivity
import com.example.wanandroidkotlin.bean.KonlageEntity
import com.example.wanandroidkotlin.presenter.contract.KnolagePresenter
import com.example.wanandroidkotlin.presenter.impl.KnolagepresenterImpl
import com.example.wanandroidkotlin.ui.activity.fragment.KnolagePagerFragment
import com.example.wanandroidkotlin.util.KnolageBarManager
import com.example.wanandroidkotlin.view.KnolageView
import kotlinx.android.synthetic.main.knolage_info.*

class KnolageInfo : BaseActivity(), KnolageBarManager{


    override val toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }
    val knolagepagerFragment by lazy { KnolagePagerFragment() }
    override fun getLayout(): Int {
        return R.layout.knolage_info
    }



    override fun initData() {
        var intent = getIntent()
       var  data= intent.getSerializableExtra("duixianga") as KonlageEntity.DataBean
        initKnolageBar(data?.name!!)
        setSupportActionBar(toolbar)//设置返回按钮
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                finish()
            }

        })

        var transaction = supportFragmentManager.beginTransaction().replace(R.id.fragment_item_knolage,knolagepagerFragment)
        var bundle  = Bundle()
        bundle.putSerializable("msg",data)
        knolagepagerFragment.arguments  = bundle
        transaction.commit()

    }

    override fun initListener() {

    }

}
