package com.example.recycleviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val list:List<Student>,
                     private val listener: MainActivity
    ):RecyclerView.Adapter<StudentAdapter.myViewHolder>() {

    inner class myViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) , View.OnClickListener {
        val tvId:TextView = itemView.findViewById(R.id.tv_id)
        val tvName:TextView = itemView.findViewById(R.id.tv_name)
        val tvProgramme:TextView = itemView.findViewById(R.id.tv_programme)
        val picPhoto:ImageView = itemView.findViewById(R.id.img_profile)

        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            val position = adapterPosition

                if (position != RecyclerView.NO_POSITION){
                    listener.itemClick(position)
            }
        }
    }

    interface onItemClicklistener{
        fun itemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view,parent,false)
        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val curStudent = list[position]

        holder.tvId.text = list[position].id
        holder.tvName.text = list[position].name
        holder.tvProgramme.text = list[position].programme

        if(curStudent.gender == "f"){
            holder.picPhoto.setImageResource(R.drawable.ic_female)
        }
        else{
            holder.picPhoto.setImageResource(R.drawable.ic_male)

        }


    }

    override fun getItemCount(): Int {
        return list.size
    }
}