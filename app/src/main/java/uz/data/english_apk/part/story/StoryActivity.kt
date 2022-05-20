package uz.data.english_apk.part.story

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_story.*
import uz.data.english_apk.R
import uz.data.english_apk.database.WordDatabase
import uz.data.english_apk.database.entity.Sound

class StoryActivity : AppCompatActivity() {

    val myAdapter = AdapterStory(this)
    lateinit var db:WordDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)
        rv_stories.adapter = myAdapter
        getDB()
        var dao = db.wordDao()
        myAdapter.list = dao.getAllSounds().toMutableList()

    }
    fun setOnClickItemTrack(sound: Sound){
        var intent = Intent(this,SoundPlayActivity::class.java)
        intent.putExtra("soundtext",sound.text)
        intent.putExtra("soundName",sound.soundName)
        startActivity(intent)
    }

    fun getDB(){
        db = Room.databaseBuilder(
            this,
            WordDatabase::class.java, "base2"
        )
            .createFromAsset("base2.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}