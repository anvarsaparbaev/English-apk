package uz.data.english_apk.part

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_words.*
import uz.data.english_apk.R
import uz.data.english_apk.database.WordDatabase
import uz.data.english_apk.database.dao.WordsDao
import uz.data.english_apk.part.word.WordAdapter

class WordsActivity : AppCompatActivity() {

    lateinit var type:String
    lateinit var wordAdapter: WordAdapter
    private var unitNumber = 0
    lateinit var db:WordDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words)
        type = intent.getStringExtra("partName").toString()
        unitNumber = intent.getIntExtra("unitNumber",0)

        db = Room.databaseBuilder(
            this,
            WordDatabase::class.java, "base"
        )
            .createFromAsset("base.db")
            .allowMainThreadQueries()
            .build()
        val wordsDao = db.wordDao()

        wordAdapter = WordAdapter(this)
        wordAdapter.wordList = wordsDao.getByUnit(unitNumber).toMutableList()
        rv_words.adapter = wordAdapter
    }
}