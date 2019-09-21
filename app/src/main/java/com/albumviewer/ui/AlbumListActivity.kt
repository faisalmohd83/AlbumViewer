package com.albumviewer.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.albumviewer.R
import com.albumviewer.common.InjectorUtils
import com.albumviewer.db.Album
import kotlinx.android.synthetic.main.activity_album_list.*

/**
 * Activity class to showcase the list of {@link Album}.
 */
class AlbumListActivity : AppCompatActivity(), Observer<List<Album>> {

    private lateinit var mRecyclerAdapter: AlbumListAdapter
    private lateinit var viewModel: AlbumListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_list)

        // View Model
        val factory = InjectorUtils.provideAlbumListViewModelFactory(this)
        viewModel = ViewModelProviders.of(this, factory).get(AlbumListViewModel::class.java)

        mRecyclerAdapter = AlbumListAdapter(this)

        rv_album_list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mRecyclerAdapter
        }

        tv_empty_list.setOnClickListener {
            viewModel.reloadData()
        }
    }

    override fun onResume() {
        super.onResume()
        // Listen to data change
        viewModel.getAlbums()?.observe(this, this)
    }

    override fun onChanged(albums: List<Album>) {
        if (albums.isNotEmpty()) {
            mRecyclerAdapter.submitList(albums)
            rv_album_list.visibility = View.VISIBLE
            tv_empty_list.visibility = View.GONE
        } else {
            rv_album_list.visibility = View.GONE
            tv_empty_list.visibility = View.VISIBLE
        }
    }

    override fun onPause() {
        viewModel.getAlbums()?.removeObserver(this)
        super.onPause()
    }
}
