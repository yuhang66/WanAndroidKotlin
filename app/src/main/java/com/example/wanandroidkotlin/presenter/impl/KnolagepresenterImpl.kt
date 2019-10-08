package com.example.wanandroidkotlin.presenter.impl

import com.example.wanandroidkotlin.api.RetrofitUtil
import com.example.wanandroidkotlin.presenter.contract.KnolagePresenter
import com.example.wanandroidkotlin.view.KnolageView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class KnolagepresenterImpl(var knolageView:KnolageView):KnolagePresenter {
    //加载区域数据的接口
    override fun loadDatas(cid:String) {
        RetrofitUtil.retrofitService.getknolagearticle(cid).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({result->
                knolageView.onSuccess(result)
            },{error->
                knolageView.onError(error.message.toString())
            })
    }
}