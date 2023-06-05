package com.erif.datetimepickerlib.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erif.datetimepickerlib.R

class AdapterTimePicker: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list: MutableList<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_date_time, parent, false)
        return HolderTimePicker(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HolderTimePicker) {
            holder.bind()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: MutableList<String>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun remove(position: Int) {
        this.list.removeAt(position)
        notifyItemChanged(position)
    }

    fun add(value: String, position: Int) {
        this.list.add(value)
        notifyItemInserted(position)
    }

}