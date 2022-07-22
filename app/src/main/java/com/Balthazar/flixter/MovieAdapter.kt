package com.Balthazar.flixter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

const val MOVIE_EXTRA = "MOVIE_EXTRA"
private const val TAG = "MovieAdapter"
class MovieAdapter(private val context: Context, private val movies: List<Movie>)
    : RecyclerView.Adapter<MovieAdapter.viewHolder>() {


    // the Expensive operation: create a view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        Log.i(TAG, "onCreateViewHolder")
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return viewHolder(view)
    }

    // Cheap: simply bind data to an existing viewHolder
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder position $position")
       val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount() = movies.size

    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private val ivPoster = itemView.findViewById<ImageView>(R.id.ivPoster)
        private val  tvTile = itemView.findViewById<TextView>(R.id.tvTitle)
        private val  tvOverview = itemView.findViewById<TextView>(R.id.tvOverview)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(movie: Movie) {
            tvTile.text = movie.title
            tvOverview.text = movie.overview
           Glide.with(context).load(movie.posterImageUrl).into(ivPoster)
        }

        override fun onClick(p0: View?) {
          // 1. Get notify of the particular movies the user click on
            val movie = movies[adapterPosition]
            Toast.makeText(context, movie.title, Toast.LENGTH_SHORT).show()
         // 2. Use the intent to navigate to the new activity
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(MOVIE_EXTRA, movie)
            context.startActivity(intent)
        }
    }
}
