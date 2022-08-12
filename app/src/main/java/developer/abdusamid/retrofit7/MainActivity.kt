package developer.abdusamid.retrofit7

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import developer.abdusamid.retrofit7.adapters.MovieAdapter
import developer.abdusamid.retrofit7.databinding.ActivityMainBinding
import developer.abdusamid.retrofit7.models.Movie
import developer.abdusamid.retrofit7.retrofit.Common
import developer.abdusamid.retrofit7.retrofit.RetrofitService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    //documentation: https://square.github.io/retrofit/
    //get IP: https://reqres.in/
    private lateinit var binding: ActivityMainBinding
    lateinit var retrofitService: RetrofitService
    lateinit var movieAdapter: MovieAdapter
    lateinit var list: ArrayList<Movie>

    @SuppressLint("CheckResult", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list = ArrayList()
        movieAdapter = MovieAdapter(list)
        retrofitService = Common.retrofitService(this)
        //With RxJava
        //link: https://habr.com/ru/post/336034/
        retrofitService.getMovie().observeOn(AndroidSchedulers.mainThread())
            .observeOn(Schedulers.io())
            .subscribe(
                { result ->
                    list.addAll(result)
                    movieAdapter.notifyDataSetChanged()
                },
                {
                    Toast.makeText(applicationContext, it.message, Toast.LENGTH_SHORT).show()
                }
            )
        binding.rv.adapter = movieAdapter
    }
}