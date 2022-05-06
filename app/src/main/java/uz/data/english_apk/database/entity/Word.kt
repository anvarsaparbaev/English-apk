package uz.data.english_apk.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "preintermediate")
class Word (

    @PrimaryKey val id:Int,
    @ColumnInfo(name = "english") val english:String?,
    @ColumnInfo(name = "qaraqalpaq") val qaraqalpaq:String?,
    @ColumnInfo(name = "type") val type:String?,
    @ColumnInfo(name = "transcription") val transcription:String?,
    @ColumnInfo(name = "example") val example:String?,
    @ColumnInfo(name = "unit") val unit:Int?,


)