package dherrero.moviessample.ui.fragments


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import dherrero.moviessample.R
import dherrero.moviessample.data.base.Constants.Companion.BASE_URL_BACKDROP
import dherrero.moviessample.domain.model.Movie
import dherrero.moviessample.ui.base.CropCircleTransformation
import kotlinx.android.synthetic.main.movieslist_adapter.view.*


class MoviesListAdapter(private val moviesDataSet: Array<Movie>, val listener:(Movie) -> Unit) : RecyclerView.Adapter<MoviesListAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
            holder.bind(moviesDataSet[position], listener)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movieslist_adapter, parent, false))

    override fun getItemCount() = moviesDataSet.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(movie:Movie, listener: (Movie) -> Unit) = with(itemView){


            titleDescription.text = movie.title
            popularityDescription.text = movie.popularity.toString()
            voteAverageDescription.rating = (movie.voteAverage.toFloat() / 2)
            voteCountDescription.text = movie.voteCount.toString()

            Picasso.get()
                    .load(BASE_URL_BACKDROP + movie.backDropImage)
                    .transform(CropCircleTransformation())
                    .into(backDropImageDescription)

            setOnClickListener{ listener(movie)}
        }

    }

}


