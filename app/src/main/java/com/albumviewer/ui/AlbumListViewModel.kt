package com.albumviewer.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.albumviewer.db.Album
import com.albumviewer.db.AlbumRepository
import com.albumviewer.network.ApiEndpoint
import com.albumviewer.network.ApiFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * ViewModel class for {@link AlbumActivity}.
 */
class AlbumListViewModel internal constructor(
    private val repository: AlbumRepository
) : ViewModel() {

    private lateinit var subscribe: Disposable

    private val apiEndpoint: ApiEndpoint = ApiFactory.create()

    private var albumList: LiveData<List<Album>> = repository.getAlbums()

    init {
        fetchDataFromNetwork() // load from network
    }

    fun getAlbums(): LiveData<List<Album>>? {
        return albumList
    }

    /**
     *
     */
    private fun fetchDataFromNetwork() {
        subscribe = apiEndpoint.getAlbums()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->
                repository.insertAll(result.toList())
            }, { error ->
                error.printStackTrace()
            })
    }

    /**
     *
     */
    fun reloadData() {
        fetchDataFromNetwork()
    }

    override fun onCleared() {
        if (!subscribe.isDisposed) subscribe.dispose()
        super.onCleared()
    }
}
