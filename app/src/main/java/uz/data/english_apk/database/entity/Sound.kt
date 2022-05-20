package uz.data.english_apk.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sounds")
class Sound (

    @PrimaryKey
    var id:Int,

    @ColumnInfo(name = "soundname")var soundName:String,

    @ColumnInfo(name = "text") var text:String
)