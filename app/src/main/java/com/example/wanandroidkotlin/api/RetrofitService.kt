package com.example.wanandroidkotlin.api

import com.example.wanandroidkotlin.bean.*
import io.reactivex.Observable
import retrofit2.http.*

interface RetrofitService {
    //bannner
   @GET("banner/json")
   fun getbannner():Observable<BannerEntity>
    //首页列表数据展示
    @GET("article/list/{page}/json")
    fun gettab(
        @Path("page") page: Int
    ):Observable<HomeRecy>
    //hotsearch
    @GET("/hotkey/json")
    fun gethotsearch():Observable<HotSearchEntity>
   //keyword search
    @FormUrlEncoded
    @POST("article/query/0/json")
    fun postkey(@Field("k") k:String):Observable<NomalSearchEntity>
    //knolageshow
    @GET("tree/json")
    fun getknolage():Observable<KonlageEntity>
    //知识体系下的文章
    @GET("article/list/0/json")
    fun getknolagearticle(@Query("cid") cid: String): Observable<KnolageSystemType>

}