package com.albumviewer.common

import android.content.Context
import com.albumviewer.db.AlbumRepository
import com.albumviewer.db.AppDatabase

object InjectorUtils {

    private fun getAlbumRepository(context: Context): AlbumRepository {
        return AlbumRepository.getInstance(AppDatabase.getInstance(context).albumDao())
    }

    fun provideAlbumListViewModelFactory(context: Context): ViewModelFactory {
        val repository = getAlbumRepository(context)
        return ViewModelFactory(repository)
    }
}