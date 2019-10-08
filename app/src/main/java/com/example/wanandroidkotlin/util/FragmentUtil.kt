package com.example.wanandroidkotlin.util

import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.base.BaseFragment
import com.example.wanandroidkotlin.ui.activity.fragment.HomeFragment
import com.example.wanandroidkotlin.ui.activity.fragment.KnolageFragment

//管理fragment的工具类
class FragmentUtil private constructor(){//私有化构造方法
    val homeFragment by lazy { HomeFragment() }
    val konlageFragment by lazy { KnolageFragment() }

    companion object{//伴生对象 就是java中的static
       val fragmentUtil by lazy { FragmentUtil() }//惰性加载
}
    //根据tabid获取对应的fragment
    fun getFragment(tabid:Int):BaseFragment?{
        when(tabid){
            R.id.tab_shou->return homeFragment
            R.id.tab_tixi->return konlageFragment
        }
        return null
    }


}