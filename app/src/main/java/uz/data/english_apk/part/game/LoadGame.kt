package uz.data.english_apk.part.game

import android.widget.TextView
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_game.*
import uz.data.english_apk.database.WordDatabase
import uz.data.english_apk.database.entity.Word

class LoadGame(private var activity: GameActivity,var type:String?) {

    private lateinit var db:WordDatabase
    private var models = mutableListOf<Word>()
    private var answers = mutableListOf<Int>()
    private var answerCount = 1
    private var rightCount = 0

    fun load(){
        activity.count.text = "$rightCount/$answerCount"
        getDB()
        val dao = db.wordDao()
        models = dao.getAll().toMutableList()
        setQuestion()
    }

    private fun setQuestion() {
        answerCount++
        val questionIndeks = (0 until models.size).random()
        if(type == "UE"){
            activity.question.text = models[questionIndeks].uzbek
        }
        if(type == "EU"){
            activity.question.text = models[questionIndeks].english
        }
        setAnswer(questionIndeks)
        activity.answer1.setOnClickListener {
            checkedRightAnswer(questionIndeks,activity.answer1.text.toString())
            setQuestion()
        }
        activity.answer2.setOnClickListener {
            checkedRightAnswer(questionIndeks,activity.answer2.text.toString())
            setQuestion()
        }
        activity.answer3.setOnClickListener {
            checkedRightAnswer(questionIndeks,activity.answer3.text.toString())
            setQuestion()
        }
        activity.answer4.setOnClickListener {
            checkedRightAnswer(questionIndeks,activity.answer4.text.toString())
            setQuestion()
        }
    }

    private fun checkedRightAnswer(questionIndeks: Int, text: String?) {
        if(type == "EU"){
            if(text == models[questionIndeks].uzbek){
                rightCount++
            }
        }
        if(type == "UE"){
            if(text == models[questionIndeks].english){
                rightCount++
            }
        }
        activity.count.text = "$rightCount/$answerCount"
    }

    private fun setAnswer(indeks:Int) {
        answers.clear()
        while(answers.size<4){
            var number = (0 until models.size).random()
            while (answers.contains(number) && number!=indeks){
                number = (0 until models.size).random()
            }
            answers.add(number)
        }
        setWrongAnswerText()
        setRightAnswer(indeks)
    }

    private fun setRightAnswer(indeks: Int) {
        when((1..4).random()){
            1-> setTextEnglishOrUzbek(indeks,activity.answer1)
            2-> setTextEnglishOrUzbek(indeks,activity.answer2)
            3-> setTextEnglishOrUzbek(indeks,activity.answer3)
            4-> setTextEnglishOrUzbek(indeks,activity.answer4)
        }
    }
    private fun setTextEnglishOrUzbek(indeks:Int,view: TextView){
        if(type == "UE"){
            view.text = models[indeks].english
        }
        if(type == "EU"){
            view.text = models[indeks].uzbek
        }
    }

    private fun setWrongAnswerText() {
        if(type == "UE"){
            activity.answer1.text = models[answers[0]].english
            activity.answer2.text = models[answers[1]].english
            activity.answer3.text = models[answers[2]].english
            activity.answer4.text = models[answers[3]].english
        }
        if(type == "EU"){
            activity.answer1.text = models[answers[0]].uzbek
            activity.answer2.text = models[answers[1]].uzbek
            activity.answer3.text = models[answers[2]].uzbek
            activity.answer4.text = models[answers[3]].uzbek
        }

    }

    private fun getDB(){
        db = Room.databaseBuilder(
            activity,
            WordDatabase::class.java, "base2"
        )
            .createFromAsset("base2.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}