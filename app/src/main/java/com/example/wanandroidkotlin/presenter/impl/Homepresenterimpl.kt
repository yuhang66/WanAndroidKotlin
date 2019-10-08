package com.example.wanandroidkotlin.presenter.impl

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.adapter.HomeRecyclerAdapter
import com.example.wanandroidkotlin.api.RetrofitUtil
import com.example.wanandroidkotlin.bean.HomeRecy
import com.example.wanandroidkotlin.presenter.contract.HomePresenter
import com.example.wanandroidkotlin.ui.activity.activity.HomeInfo
import com.example.wanandroidkotlin.view.HomeView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.home_rec_item.*

class Homepresenterimpl(var homeView: HomeView):HomePresenter {
    override fun initRey(offset: Int) {//首页列表初始化
        var currentpage = 0
        RetrofitUtil.retrofitService.gettab(currentpage).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({result->
                homeView.shouitem(result,currentpage)
            },
                {error->
                    Log.i("列表加载失败",error.toString())
                })
    }

    override fun bannerStart() {//banner的实现
        RetrofitUtil.retrofitService.
            getbannner().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({result->
                Log.i("waht",result.data.get(0).title)
                homeView.bannerSuccess(result)
            },{error->
                Log.i("waht",error.toString())
            })

    }

}