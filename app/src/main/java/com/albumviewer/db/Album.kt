package com.albumviewer.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Generic DTO for Room and network operations.
 */
@Entity(tableName = "albums")
data class Album(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    val userId: Int,
    val title: String
)