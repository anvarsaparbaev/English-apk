package uz.data.english_apk.part

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_learn.*
import uz.data.english_apk.R
import uz.data.english_apk.part.learn.PartAdapter

class LearnActivity : AppCompatActivity() {

    private lateinit var partName:String
    private lateinit var adapterPart:PartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn)
        partName = intent.getStringExtra("partName").toString()
        adapterPart = PartAdapter(partName,this)
        adapterPart.listUnits = setUnitsData()
        rv_part1.adapter = adapterPart
    }

    fun itemUnitClick(unitNumber:Int){
        val intent = Intent(this,WordsActivity::class.java)
        intent.putExtra("unitNumber",unitNumber+1)
        intent.putExtra("partName",partName)
        startActivity(intent)
    }

    private fun setUnitsData():MutableList<String>{
        val list = mutableListOf<String>()
        for (i in 1..12){
            list.add("Unit $i")
        }
        return list
    }
}