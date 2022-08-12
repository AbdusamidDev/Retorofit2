package developer.abdusamid.retrofit7.retrofit

import android.content.Context

object Common {
    var BASE_URL = "https://cbu.uz/uzc/arkhiv-kursov-valyut/json/"

    fun retrofitService(context: Context): RetrofitService {
        return RetrofitClient.getRetrofit(BASE_URL, context).create(RetrofitService::class.java)
    }
}