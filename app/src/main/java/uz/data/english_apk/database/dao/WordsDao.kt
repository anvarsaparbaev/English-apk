package uz.data.english_apk.database.dao

import androidx.room.Dao
import androidx.room.Query
import uz.data.english_apk.database.entity.Sound
import uz.data.english_apk.database.entity.Word

@Dao
interface WordsDao {

    @Query("select * from preintermediate")
    fun getAll(): List<Word>

    @Query("SELECT * FROM preintermediate where id = :id")
    fun getById(id:Int):Word

    @Query("Select * from preintermediate where unit = :unitNumber")
    fun getByUnit(unitNumber:Int):List<Word>

    @Query("Select * from preintermediate where english like :str")
    fun getSearchWordsByEnglish(str:String):List<Word>

    @Query("Select * from sounds")
    fun getAllSounds():List<Sound>

}