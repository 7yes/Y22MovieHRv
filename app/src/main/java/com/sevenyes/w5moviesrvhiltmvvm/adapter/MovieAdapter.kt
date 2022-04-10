package com.sevenyes.w5moviesrvhiltmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sevenyes.w5moviesrvhiltmvvm.R
import com.sevenyes.w5moviesrvhiltmvvm.models.Movie250
import com.squareup.picasso.Picasso

class MovieAdapter(private var movieList: List<Movie250> = listOf())
    : RecyclerView.Adapter<MovieHolder>() {

    fun setMovies(movieListNew: List<Movie250>){
        movieList = movieListNew
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
         val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
       return movieList.size
    }
}

class MovieHolder(private val view: View): RecyclerView.ViewHolder(view){
    fun bind(movie: Movie250){
        //view.findViewById<TextView>(R.id.crew)
          //  .text=movie.crew
        view.findViewById<TextView>(R.id.fullTitle)
            .text=movie.title
        view.findViewById<TextView>(R.id.year)
            .text=movie.year
        Picasso.get().load(movie.image)
            .resize(120,120)
            .into( view.findViewById<ImageView>(R.id.imageView))
    }
}