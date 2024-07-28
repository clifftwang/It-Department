package com.gamecodeschool.itdepartmentapp

import MenuItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(
    private val items: List<MenuItem>,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    // ViewHolder class
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iconImageView: ImageView = view.findViewById(R.id.item_icon)
        val titleTextView: TextView = view.findViewById(R.id.item_title)
    }

    // onCreateViewHolder method
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_item, parent, false)
        return ViewHolder(view)
    }

    // onBindViewHolder method
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.iconImageView.setImageResource(item.iconResId)
        holder.titleTextView.text = item.title
        holder.itemView.setOnClickListener { onItemClick(position) }
    }

    // getItemCount method
    override fun getItemCount() = items.size
}