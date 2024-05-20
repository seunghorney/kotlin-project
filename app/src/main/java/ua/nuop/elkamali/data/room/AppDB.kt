package ua.nuop.elkamali.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ua.nuop.elkamali.data.room.dao.NoteDao
import ua.nuop.elkamali.entity.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class AppDB : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}