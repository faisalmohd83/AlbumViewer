package com.albumviewer.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.albumviewer.R
import com.albumviewer.db.Album

/**
 * Adapter class for {@link AlbumActivity}.
 */
class AlbumListAdapter(var context: Context?) : ListAdapter<Album, AlbumViewHolder>(diffCallback) {

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Album>() {

            override fun areItemsTheSame(oldAlbum: Album, newAlbum: Album): Boolean {
                return oldAlbum.id == newAlbum.id
            }

            override fun areContentsTheSame(oldAlbum: Album, newAlbum: Album): Boolean {
                return oldAlbum == newAlbum
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_album_item, parent, false)
        return AlbumViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.tvAlbumName.text = getItem(position)!!.title
    }
}
