package uz.data.english_apk.part.learn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_unit.view.*
import uz.data.english_apk.R
import uz.data.english_apk.part.LearnActivity

class PartAdapter(val partName:String,var activity:LearnActivity) :RecyclerView.Adapter<PartAdapter.PartViewHolder>() {

    var listUnits = mutableListOf<String>()
    set(value) {
        field = value
    }

    inner class PartViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){
        fun setItemsData(title:String,position: Int){
            itemView.tv_unit_title.text = title
            itemView.tv_unit_description.text = partName
            itemView.setOnClickListener {
                activity.itemUnitClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_unit,parent,false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: PartViewHolder, position: Int) {
        holder.setItemsData(listUnits[position],position)
    }

    override fun getItemCount(): Int {
        return listUnits.size
    }

}