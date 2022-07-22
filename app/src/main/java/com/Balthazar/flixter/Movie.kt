package com.Balthazar.flixter

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.parcelize.IgnoredOnParcel
import org.json.JSONArray

@Parcelize
data class Movie (
    val movieId: Int,
    val voteAverage:Double,
    private val posterPath: String,
    val title: String,
    val overview: String,
): Parcelable {
    @IgnoredOnParcel
    val posterImageUrl ="https://image.tmdb.org/t/p/w342/$posterPath"

    companion object{
        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {
          val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()) {
                val movieJSON = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJSON.getInt("id"),
                        movieJSON.getDouble("vote_average"),
                        movieJSON.getString("poster_path"),
                        movieJSON.getString("title"),
                        movieJSON.getString("overview")
                    )
                )
            }
            return movies
        }
    }
}