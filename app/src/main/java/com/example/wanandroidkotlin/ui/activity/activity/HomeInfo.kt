
package com.example.wanandroidkotlin.ui.activity.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.*
import androidx.appcompat.widget.Toolbar
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.base.BaseActivity
import com.example.wanandroidkotlin.bean.BannerEntity
import com.example.wanandroidkotlin.util.InfoBarManager
import com.example.wanandroidkotlin.view.HomeView
import kotlinx.android.synthetic.main.activity_home_info.*

class HomeInfo : BaseActivity(),InfoBarManager {
    override val toolbar by lazy { findViewById<Toolbar>(R.id.toolbarinfo) }


    override fun getLayout(): Int {
        return R.layout.activity_home_info
    }

    override fun initData() {
        val intent:Intent = intent
        val name =   intent.getStringExtra("title")
        val link:String = intent.getStringExtra("link")
        initToolbarInfoManager(name)//设置头部标题
        setSupportActionBar(toolbar)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                finish()
            }

        })

        init()//设置进度条加载
        webview.loadUrl(link)

    }
 fun init(){

    val webClient = object :WebViewClient(){
        override fun shouldOverrideUrlLoading(view: WebView?, url:String): Boolean {//覆写shouldOverrideUrlLoading实现内部显示网页
            view!!.loadUrl(url)
            return true
        }

    }
   webview.setWebViewClient(webClient)
        val  webset= webview.settings
        webset.setJavaScriptEnabled(true);//设置webview支持javascript脚本


     val chrome = object :WebChromeClient(){
         override fun onProgressChanged(view: WebView?, newProgress: Int) {
             if(newProgress==100){
                 progress.setVisibility(View.GONE)//进度加载完成
             }else{
                 progress.setVisibility(View.VISIBLE)//加载ing
                 progress.setProgress(newProgress)//设置加载的进度
             }
         }

     }
     webview.setWebChromeClient(chrome)
 }


}


