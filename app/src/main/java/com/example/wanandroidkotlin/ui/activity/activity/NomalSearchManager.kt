package com.example.wanandroidkotlin.ui.activity.activity


import android.content.Intent
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo

import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.adapter.NomalSearchAdapter
import com.example.wanandroidkotlin.base.BaseActivity
import com.example.wanandroidkotlin.bean.NomalSearchEntity
import com.example.wanandroidkotlin.presenter.impl.SearchpresenterImpl
import com.example.wanandroidkotlin.util.SearchBarManager
import com.example.wanandroidkotlin.view.SearchView
import kotlinx.android.synthetic.main.nomal_search_manager.*

class NomalSearchManager :BaseActivity(),SearchBarManager,SearchView {
    override val toolbar by lazy { findViewById<Toolbar>(R.id.searchbar) }
    var search: MutableList<NomalSearchEntity.DataBean.DatasBean> = ArrayList()
    val searchimpl by lazy { SearchpresenterImpl(this) }
    override fun getLayout(): Int {
        return R.layout.nomal_search_manager
    }

    override fun initData() {
        initSearchBarManager()
        setSupportActionBar(toolbar)//设置返回按钮
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }


    override fun initListener() {
        searchimpl.backclick()
        nomalsearch_refresh.setOnRefreshListener(object :SwipeRefreshLayout.OnRefreshListener{
            override fun onRefresh() {
                searchimpl.searchbegin(search_text.text.toString())
            }

        })
    }
    override fun click() {
        toolbar.setNavigationOnClickListener(object : View.OnClickListener{//返回建的点击事件
        override fun onClick(v: View?) {
            finish()
        }

        })
        clearthing.setOnClickListener(object : View.OnClickListener{//清空edit的值
        override fun onClick(v: View?) {
            search_text.setText("")
        }
        })
        search_text.setOnEditorActionListener(object : TextView.OnEditorActionListener{
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    if(search_text.text.isEmpty()){
                        Toast.makeText(this@NomalSearchManager,"请输入要查找的内容", Toast.LENGTH_SHORT).show()
                    }else{
                        searchimpl.searchbegin(search_text.text.toString())
                    }
                }
                return false
            }

        })
    }

    override fun initSearch() {//搜索前初始化
        search.clear()
        nomalsearch_recy.layoutManager = LinearLayoutManager(this)  //设置布局管理
        nomalsearch_recy.adapter = NomalSearchAdapter(search)
    }
    override fun searchAccess(result: NomalSearchEntity) {//搜索导数据啦
        search.addAll(result.data.datas)
        (nomalsearch_recy.adapter as NomalSearchAdapter).notifyDataSetChanged()
         nomalsearch_refresh.setRefreshing(false)
        (nomalsearch_recy.adapter as NomalSearchAdapter).setOnItemChildClickListener { adapter, view, position ->
            var searchinfo: NomalSearchEntity.DataBean.DatasBean = search.get(position)
            var intent: Intent = Intent(this, HomeInfo::class.java)
            intent.putExtra("title", searchinfo.title)
            intent.putExtra("link", searchinfo.link)
            this.startActivity(intent)
        }
    }
    override fun searchError(toString: String) {//查找失败
        Toast.makeText(this, toString, Toast.LENGTH_SHORT).show()
    }
}
