package com.example.wanandroidkotlin.ui.activity.fragment

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.adapter.HomeRecyclerAdapter
import com.example.wanandroidkotlin.api.RetrofitUtil
import com.example.wanandroidkotlin.base.BaseFragment
import com.example.wanandroidkotlin.bean.BannerEntity
import com.example.wanandroidkotlin.bean.HomeRecy
import com.example.wanandroidkotlin.presenter.impl.Homepresenterimpl
import com.example.wanandroidkotlin.ui.activity.activity.HomeInfo
import com.example.wanandroidkotlin.util.GlideImageLoader
import com.example.wanandroidkotlin.view.HomeView
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.home_rec_item.*

class HomeFragment: BaseFragment(), HomeView {
    var title:MutableList<String> = ArrayList()
    var imgs:MutableList<String> = ArrayList()
    var list:MutableList<HomeRecy.DataBean.DatasBean> = ArrayList()
    var ischeked= false
    val homePresenter by lazy { Homepresenterimpl(this) }

    override fun initView(): View {
       return View.inflate(context, R.layout.fragment_home,null)
    }

    override fun initData() {
        homePresenter.bannerStart()
        home_recyc.layoutManager = LinearLayoutManager(context)  //设置布局管理
        homePresenter.initRey(0)
        homeswipe.setOnRefreshListener(object :SwipeRefreshLayout.OnRefreshListener{//刷新逻辑
            override fun onRefresh() {
                list.clear()
            homePresenter.initRey(0)
            }
        })
    }

    override fun bannerSuccess(result: BannerEntity) {
        title.clear()
        imgs.clear()
        var count = result.data.size
        for(i in 0..count){//kotlin for循环语句
            imgs.addAll(listOf(result.data.get(i).imagePath))
            title.addAll(listOf(result.data.get(i).title))
            banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE)//设置标题和数字指示器横向排列
            banner.setImageLoader(GlideImageLoader())
            banner.setImages(imgs)
            banner.setBannerAnimation(Transformer.DepthPage)//动画效果
            banner.isAutoPlay(true)
            banner.setDelayTime(2000)
            banner.setIndicatorGravity(BannerConfig.CENTER)//设置居中
            banner.setBannerTitles(title)
            banner.setFocusable(true)//获取焦点
            banner.setFocusableInTouchMode(true)//触摸是否能获取到焦点
            banner.start()
        }
    }
//设置列表数据
override fun shouitem(result: HomeRecy,currentPage:Int) {
    var currentpage = currentPage
    list.addAll(result.data.datas)
    home_recyc.adapter = HomeRecyclerAdapter(list)
    (home_recyc.adapter as HomeRecyclerAdapter).notifyDataSetChanged()
    homeswipe.setRefreshing(false)
    home_recyc.setNestedScrollingEnabled(false)//设置滑动不卡顿
    (home_recyc.adapter as HomeRecyclerAdapter).setOnLoadMoreListener(object : BaseQuickAdapter.RequestLoadMoreListener{
        override fun onLoadMoreRequested() {
            home_recyc.postDelayed(object :Runnable{
                override fun run() {
                    if(currentpage<=result.data.datas.size){

                        currentpage +=1

                        homePresenter.initRey(currentpage)

                    }else{
                        (home_recyc.adapter as HomeRecyclerAdapter).loadMoreFail()
                    }
                }

            },5000)
        }

    },home_recyc)
    (home_recyc.adapter as HomeRecyclerAdapter).setOnItemClickListener { adapter, view, position ->
        var item: HomeRecy.DataBean.DatasBean = list.get(position)
        var intent: Intent = Intent(context, HomeInfo::class.java)
        intent.putExtra("title",item.title)
        intent.putExtra("link",item.link)
        startActivity(intent)
    }
    (home_recyc.adapter as HomeRecyclerAdapter).setOnItemChildClickListener(object : BaseQuickAdapter.OnItemChildClickListener{//收藏的点击事件未做完
    override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        if(ischeked){
            homeItemLike.setBackgroundResource(R.drawable.shou)
            ischeked=false
        }else{
            homeItemLike.setBackgroundResource(R.drawable.shou_select)
            ischeked=true
        }

        Toast.makeText(context,"jj", Toast.LENGTH_SHORT).show()
    }

    })
}

}