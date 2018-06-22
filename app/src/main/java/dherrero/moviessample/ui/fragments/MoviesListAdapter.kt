package dherrero.moviessample.ui.fragments

import android.graphics.*
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import dherrero.moviessample.R
import dherrero.moviessample.data.base.Constants.Companion.BASE_URL_BACKDROP
import dherrero.moviessample.data.base.Constants.Companion.BASE_URL_POSTER
import dherrero.moviessample.domain.model.Movie
import kotlinx.android.synthetic.main.movieslist_adapter.view.*
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import android.widget.RatingBar


class MoviesListAdapter(private val moviesDataSet: Array<Movie>) : RecyclerView.Adapter<MoviesListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


//        val originalTitle: TextView = view.originalTitleDescription!!
        val title: TextView = view.titleDescription!!
//        val adult: TextView = view.adultDescription!!
        val backDropImage: ImageView = view.backDropImageDescription!!
//        val mediaType: TextView = view.mediaTypeDescription!!
//        val language: TextView = view.languageDescription!!
//        val overview: TextView = view.overviewDescription!!
        val popularity: TextView = view.popularityDescription!!
//        val posterImage: ImageView = view.posterImageDescription!!
//        val releaseDate: TextView = view.releaseDateDescription!!
//        val video: TextView = view.videoDescription!!
        val voteAverage: RatingBar = view.voteAverageDescription!!
        val voteCount: TextView = view.voteCountDescription!!

    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//        holder.originalTitle.text = moviesDataSet[position].originalTitle
        holder.title.text = moviesDataSet[position].title
//        holder.adult.text = moviesDataSet[position].adult.toString()



        Picasso.get().load(BASE_URL_BACKDROP + moviesDataSet[position].backDropImage)
                .transform(CropCircleTransformation())

                .into(holder.backDropImage)

//        holder.mediaType.text = moviesDataSet[position].mediaType
//        holder.language.text = moviesDataSet[position].language
//        holder.overview.text = moviesDataSet[position].overview
        holder.popularity.text = moviesDataSet[position].popularity.toString()

//        Picasso.get().load(BASE_URL_POSTER + moviesDataSet[position].posterImage).into(holder.posterImage)

//        holder.releaseDate.text = moviesDataSet[position].releaseDate
//        holder.video.text = moviesDataSet[position].video.toString()
        holder.voteAverage.rating = (moviesDataSet[position].voteAverage.toFloat() / 2)
        holder.voteCount.text = moviesDataSet[position].voteCount.toString()


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.movieslist_adapter, parent, false)

        return ViewHolder(view)


    }

    override fun getItemCount(): Int {
        return moviesDataSet.size
    }


class CropCircleTransformation: Transformation{

    override fun key(): String {
        return "circle()"
    }

    override fun transform(source: Bitmap?): Bitmap {

        val size = Math.min(source!!.width, source!!.height)

        val x = (source.width - size) / 2
        val y = (source.height - size) / 2

        val squaredBitmap = Bitmap.createBitmap(source, x, y, size, size)

        if (squaredBitmap != source) {
            source.recycle()
        }

        val bitmap = Bitmap.createBitmap(size, size, source.config)

        val canvas = Canvas(bitmap)
        val paint = Paint()

        val shader = BitmapShader(squaredBitmap,
                Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

        paint.shader = shader
        paint.isAntiAlias = true

        val r = size / 2f
        canvas.drawCircle(r, r, r, paint)

        squaredBitmap.recycle()
        return bitmap

    }
}

}


