package uz.data.english_apk.part.word

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_word.view.*
import uz.data.english_apk.R
import uz.data.english_apk.database.entity.Word
import uz.data.english_apk.part.WordsActivity

class WordAdapter(val activity: WordsActivity): RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    var wordList = mutableListOf<Word>()
    set(value) {
        field = value
    }

    inner class WordViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        fun setWordData(word: Word){
            if(activity.type.startsWith("En")){
                itemView.word1.text = word.english+" - "
                itemView.word2.text = word.uzbek
            }else{
                itemView.word1.text = word.uzbek+" - "
                itemView.word2.text = word.english
            }
            itemView.setOnClickListener {
                activity.setClickWord(word)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word,parent,false)
        return WordViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.setWordData(wordList[position])
    }

    override fun getItemCount(): Int = wordList.size

}