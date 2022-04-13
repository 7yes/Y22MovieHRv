package com.sevenyes.w5moviesrvhiltmvvm.adapter

import android.icu.number.NumberFormatter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sevenyes.w5moviesrvhiltmvvm.R
import com.sevenyes.w5moviesrvhiltmvvm.models.Movie250
import com.squareup.picasso.Picasso

class MovieAdapter(private var movieList: MutableList<Movie250> = mutableListOf(), private val like: (movie: Movie250, position: Int) -> Unit)
    : RecyclerView.Adapter<MovieHolder>() {

    fun removeMovie(position: Int){
        movieList.removeAt(position)
        notifyItemChanged(position)
    }

    fun filterFavorites(movie: Movie250){
        movieList.add(movie)
        notifyItemChanged(itemCount-1)
    }

    fun setMovies(movieListNew: List<Movie250>){
        movieList = movieListNew as MutableList<Movie250>
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
         val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        return MovieHolder(view, like)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movieList[position], position)
    }

    override fun getItemCount(): Int {
       return movieList.size
    }
}

class MovieHolder(private val view: View, private val liked: (movie: Movie250, position: Int) -> Unit
): RecyclerView.ViewHolder(view){
    fun bind(movie: Movie250, position: Int){

        view.findViewById<ImageView>(R.id.thumbsImage).setOnClickListener {
            liked(movie, position)
        }

        val icon = if (movie.iLikeIt) R.drawable.ic_like_red else R.drawable.ic_like_black
        view.findViewById<ImageView>(R.id.thumbsImage)
            .setImageResource(icon)

        view.findViewById<TextView>(R.id.fullTitle)
            .text=movie.title
        view.findViewById<TextView>(R.id.year)
            .text=movie.year
        Picasso.get().load(movie.image)
            .resize(150,150)
            .into( view.findViewById<ImageView>(R.id.imageView))
    }
}