package uz.data.english_apk.part.story

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_story.view.*
import uz.data.english_apk.R
import uz.data.english_apk.database.entity.Sound

class AdapterStory(var activity: StoryActivity):RecyclerView.Adapter<AdapterStory.StoryViewHolder>(){

    var list = mutableListOf<Sound>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class StoryViewHolder(item:View):RecyclerView.ViewHolder(item){
        fun setData(sound: Sound,activity: StoryActivity){
            itemView.tv_sound_name.text = sound.soundName
            itemView.setOnClickListener {
                activity.setOnClickItemTrack(sound)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_story,parent,false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.setData(list[position],activity)
    }

    override fun getItemCount(): Int = list.size

}