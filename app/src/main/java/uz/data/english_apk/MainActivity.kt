package uz.data.english_apk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import uz.data.english_apk.part.LearnActivity

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
    }
}