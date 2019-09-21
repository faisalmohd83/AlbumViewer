package com.albumviewer.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.albumviewer.ui.AlbumListViewModel
import com.albumviewer.db.AlbumRepository

class ViewModelFactory(
    private val repository: AlbumRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = AlbumListViewModel(repository) as T
}