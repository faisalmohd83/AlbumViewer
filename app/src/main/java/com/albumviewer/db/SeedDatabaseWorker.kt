package com.albumviewer.db

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader

const val ALBUM_LIST_FILENAME = "albums.json"

/**
 *
 */
class SeedDatabaseWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    private val TAG by lazy { SeedDatabaseWorker::class.java.simpleName }

    override fun doWork(): Result {
        val albumType = object : TypeToken<List<Album>>() {}.type
        var jsonReader: JsonReader? = null

        return try {
            val inputStream = applicationContext.assets.open(ALBUM_LIST_FILENAME)
            jsonReader = JsonReader(inputStream.reader())
            val albumList: List<Album> = Gson().fromJson(jsonReader, albumType)
            Log.w(TAG, albumList.toString())
            val database = AppDatabase.getInstance(applicationContext)
            // database.albumDao().insertAll(albumList)
            Result.success()
        } catch (ex: Exception) {
            Log.e(TAG, "Error inserting albums", ex)
            Result.failure()
        } finally {
            jsonReader?.close()
        }
    }
}
