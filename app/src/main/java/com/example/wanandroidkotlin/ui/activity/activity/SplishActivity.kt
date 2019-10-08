package com.example.wanandroidkotlin.ui.activity.activity

import android.content.Intent
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splish.*

class SplishActivity : BaseActivity(), ViewPropertyAnimatorListener {
    override fun onAnimationEnd(view: View?) {
        val intent:Intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onAnimationCancel(view: View?) {

    }

    override fun onAnimationStart(view: View?) {

    }

    override fun getLayout(): Int {
        return R.layout.activity_splish
    }

    override fun initData() {
        ViewCompat.animate(imgview).scaleY(1.0f).scaleX(1.0f).setListener(this).setDuration(3000)
    }


}
