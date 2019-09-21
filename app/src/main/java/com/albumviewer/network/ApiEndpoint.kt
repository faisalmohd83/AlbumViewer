package com.albumviewer.network

import com.albumviewer.db.Album
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * An interface to JSONPlaceholder API endpoints.
 */
interface ApiEndpoint {

    /**
     * API End point return list of {@link Album}.
     */
    @GET("albums")
    fun getAlbums(): Observable<List<Album>>
}