package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

class ItemAdapter(private val context: Context, private val dataset : List<Affirmation>):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {



    class ItemViewHolder(private val view : View): RecyclerView.ViewHolder(view){
        val textBox = view.findViewById<TextView>(R.id.item_title)
        val imageBox = view.findViewById<ImageView>(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val holderView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(holderView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.textBox.text = context.resources.getString(dataset[position].stringId)
        holder.imageBox.setImageResource(dataset[position].imageId)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}