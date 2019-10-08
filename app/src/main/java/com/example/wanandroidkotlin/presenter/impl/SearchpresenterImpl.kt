package com.example.wanandroidkotlin.presenter.impl

import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wanandroidkotlin.adapter.NomalSearchAdapter
import com.example.wanandroidkotlin.api.RetrofitUtil
import com.example.wanandroidkotlin.bean.NomalSearchEntity
import com.example.wanandroidkotlin.presenter.contract.SearchPresenter
import com.example.wanandroidkotlin.ui.activity.activity.HomeInfo
import com.example.wanandroidkotlin.view.SearchView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchpresenterImpl(var searView:SearchView):SearchPresenter {
    override fun searchbegin(keyword: String) {
        searView.initSearch()

        RetrofitUtil.retrofitService.postkey(keyword).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                searView.searchAccess(result)

            }, { error ->
                searView.searchError(error.message.toString())

            })
    }

    override fun backclick() {
        searView.click()
    }


    }




