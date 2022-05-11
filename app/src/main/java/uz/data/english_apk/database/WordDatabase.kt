package uz.data.english_apk.database

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.data.english_apk.database.dao.WordsDao
import uz.data.english_apk.database.entity.Word

@Database(entities = [Word::class], version = 4)
abstract class WordDatabase :RoomDatabase() {
    abstract fun wordDao(): WordsDao
}