package uz.data.english_apk.database

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.data.english_apk.database.dao.WordsDao
import uz.data.english_apk.database.entity.Sound
import uz.data.english_apk.database.entity.Word

@Database(entities = [Word::class,Sound::class], version = 1)
abstract class WordDatabase :RoomDatabase() {
    abstract fun wordDao(): WordsDao
}