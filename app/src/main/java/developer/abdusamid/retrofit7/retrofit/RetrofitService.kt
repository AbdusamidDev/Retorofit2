package developer.abdusamid.retrofit7.retrofit

import developer.abdusamid.retrofit7.models.Movie
import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitService {
    @GET("marvel")
    fun getMovie(): Single<List<Movie>>
}