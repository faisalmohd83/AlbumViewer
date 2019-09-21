package com.albumviewer.db

import org.jetbrains.anko.doAsync

/**
 * Repository module for handling data operations.
 */
class AlbumRepository private constructor(private val albumDao: AlbumDao) {

    fun getAlbums() = albumDao.getAlbums()

    fun insertAll(albums: List<Album>) {
        doAsync {
            albumDao.insertAll(albums)
        }
    }

    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: AlbumRepository? = null

        fun getInstance(albumDao: AlbumDao) =
            instance ?: synchronized(this) {
                instance
                    ?: AlbumRepository(albumDao).also { instance = it }
            }
    }

}
