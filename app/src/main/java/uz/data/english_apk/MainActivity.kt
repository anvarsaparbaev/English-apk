package uz.data.english_apk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import uz.data.english_apk.part.game.GameActivity
import uz.data.english_apk.part.LearnActivity
import uz.data.english_apk.part.WordsActivity
import uz.data.english_apk.part.story.StoryActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_learnEU.setOnClickListener {
            val intent = Intent(this,LearnActivity::class.java)
            intent.putExtra("partName","English-Uzbek")
            startActivity(intent)
        }
        btn_learnUE.setOnClickListener {
            val intent = Intent(this,LearnActivity::class.java)
            intent.putExtra("partName","Uzbek-English")
            startActivity(intent)
        }
        btn_learnAllWords.setOnClickListener {
            val intent = Intent(this,WordsActivity::class.java)
            intent.putExtra("type",2)
            startActivity(intent)
        }
        btn_startShortStroies.setOnClickListener {
            val intent = Intent(this,StoryActivity::class.java)
            startActivity(intent)
        }
        btn_gameUE.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("type","UE")
            startActivity(intent)
        }
        btn_gameEU.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("type","EU")
            startActivity(intent)
        }
    }
}