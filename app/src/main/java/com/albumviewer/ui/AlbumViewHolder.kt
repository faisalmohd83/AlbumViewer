package com.albumviewer.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_album_item.view.*

/**
 * View holder for {@link AlbumListAdapter}.
 */
class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tvAlbumName = itemView.tv_album_title!!
}
