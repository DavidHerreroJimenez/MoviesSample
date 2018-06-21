package dherrero.moviessample.ui.fragments

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import dherrero.moviessample.R
import dherrero.moviessample.domain.model.Movie
import kotlinx.android.synthetic.main.movieslist_adapter.view.*

class MoviesListAdapter(private val moviesDataSet: Array<Movie>) : RecyclerView.Adapter<MoviesListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {



        val originalTitle: TextView = view.originalTitleDescription!!
        val title: TextView = view.titleDescription!!
        val adult: TextView = view.adultDescription!!
        val backDropImage: ImageView = view.backDropImageDescription!!
        val mediaType: TextView = view.mediaTypeDescription!!
        val language: TextView = view.languageDescription!!
        val overview: TextView = view.overviewDescription!!
        val popularity: TextView = view.popularityDescription!!
        val posterImage: ImageView = view.posterImageDescription!!
        val releaseDate: TextView = view.releaseDateDescription!!
        val video: TextView = view.videoDescription!!
        val voteAverage: TextView = view.voteAverageDescription!!
        val voteCount: TextView = view.voteCountDescription!!

    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.originalTitle.text = moviesDataSet[position].originalTitle
        holder.title.text = moviesDataSet[position].title
        holder.adult.text = moviesDataSet[position].adult.toString()
//        holder.backDropImage.image = moviesDataSet[position].backDropImage
        holder.mediaType.text = moviesDataSet[position].mediaType
        holder.language.text = moviesDataSet[position].language
        holder.overview.text = moviesDataSet[position].overview
        holder.popularity.text = moviesDataSet[position].popularity.toString()
//        holder.posterImage.image = moviesDataSet[position].posterImage
        holder.releaseDate.text = moviesDataSet[position].releaseDate
        holder.video.text = moviesDataSet[position].video.toString()
        holder.voteAverage.text = moviesDataSet[position].voteAverage.toString()
        holder.voteCount.text = moviesDataSet[position].voteCount.toString()


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.movies_fragment, parent, false)


//        originalTitleDescription
//        title
//        titleDescription
//        adult
//        adultDescription
//        backDropImage
//        backDropImageDescription
//        mediaType
//        mediaTypeDescription
//        language
//        languageDescription
//        overview
//        overviewDescription
//        popularity
//        popularityDescription
//        posterImage
//        posterImageDescription
//        releaseDate
//        releaseDateDescription
//        video
//        videoDescription
//        voteAverage
//        voteAverageDescription
//        voteCount
//        voteCountDescription

        return ViewHolder(view)


    }

    override fun getItemCount(): Int {
        return moviesDataSet.size
    }


}


