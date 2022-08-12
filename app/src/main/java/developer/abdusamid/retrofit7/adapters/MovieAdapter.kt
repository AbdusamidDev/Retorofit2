package developer.abdusamid.retrofit7.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import developer.abdusamid.retrofit7.databinding.ItemMovieBinding
import developer.abdusamid.retrofit7.models.Movie

class MovieAdapter(private var listMovie: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.VH>() {
    inner class VH(private var itemRV: ItemMovieBinding) : RecyclerView.ViewHolder(itemRV.root) {
        fun onBind(movie: Movie) {
            itemRV.nameTv.text = movie.name
            Picasso.get().load(movie.imageUrl).into(itemRV.imageItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(listMovie[position])
    }

    override fun getItemCount(): Int = listMovie.size
}