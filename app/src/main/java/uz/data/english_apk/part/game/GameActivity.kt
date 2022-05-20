package uz.data.english_apk.part.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game.*
import uz.data.english_apk.R

class GameActivity : AppCompatActivity() {

    private lateinit var loadGame: LoadGame

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val type = intent.getStringExtra("type")
        setTitles(type)
        loadGame = LoadGame(this,type)
        loadGame.load()
    }
    private fun setTitles(type:String?){
        if(type == "EU"){
            game_title.text = "English - Uzbek"
        }
        if(type == "UE"){
            game_title.text = "Uzbek - English"
        }
    }
}