package uz.data.english_apk.part

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_words.*
import kotlinx.android.synthetic.main.dialog_info_word.view.*
import uz.data.english_apk.R
import uz.data.english_apk.database.WordDatabase
import uz.data.english_apk.database.dao.WordsDao
import uz.data.english_apk.database.entity.Word
import uz.data.english_apk.part.word.WordAdapter

class WordsActivity : AppCompatActivity() {

    lateinit var type:String
    private lateinit var wordAdapter: WordAdapter
    private var unitNumber = 0
    private lateinit var db:WordDatabase
    private lateinit var wordsDao:WordsDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words)
        type = intent.getStringExtra("partName").toString()
        unitNumber = intent.getIntExtra("unitNumber",0)
        getDB()
        wordsDao = db.wordDao()
        getEnUzb()

        search_text.addTextChangedListener {
            var list = wordsDao.getSearchWordsByEnglish("$it%");
            wordAdapter.wordList = list.toMutableList()
        }

    }
    fun getEnUzb(){
        val tip = intent.getIntExtra("type",0)
        if(tip==2){
            type = "En"
            wordAdapter = WordAdapter(this)
            wordAdapter.wordList = wordsDao.getAll().toMutableList()
            rv_words.adapter = wordAdapter
        }else {
            wordAdapter = WordAdapter(this)
            wordAdapter.wordList = wordsDao.getByUnit(unitNumber).toMutableList()
            rv_words.adapter = wordAdapter
        }
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

    fun setClickWord(word: Word){
        val view = LayoutInflater.from(this).inflate(R.layout.dialog_info_word,null)
        val wordDialog = AlertDialog.Builder(this).setCancelable(false).setView(view).create()

        if(type == "English-Uzbek"){
            view.englishWord.text = word.english
            view.uzbekWord.text = word.uzbek
            view.example.text = "Example : ${word.example}"
        }else{
            view.englishWord.text = word.uzbek
            view.uzbekWord.text = word.english
            view.example.text = "Example : ${word.example}"
        }
        wordDialog.show()
        view.ok_dialog.setOnClickListener {
            wordDialog.dismiss()
        }
    }
}