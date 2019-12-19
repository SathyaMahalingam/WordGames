package com.sample.wordgame.wordfinder.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sample.wordgame.databinding.WordBoardItemViewBinding

/**
 * WordBoardAdapter class acts as adapter and used to bind data to the each item view in Word Board Screen
 */
class WordBoardAdapter(private var context: Context?,
                       private var items:  MutableList<Char>?)  : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = WordBoardItemViewBinding.inflate( LayoutInflater.from(context), parent, false)
        return WordsItemRowHolder(binding)
    }

    override fun getItemCount(): Int {
        return if(items == null)
            0
        else
            items?.size!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as WordsItemRowHolder).letter.text = items?.get(position).toString()
    }

    fun addItems(item: MutableList<Char>?) {
      items?.clear()
      if(items == null) items = mutableListOf()
      items?.addAll(item as List<Char>)
      notifyDataSetChanged()

    }
}

/**
 * View holder class for word board Item Row
 */
class WordsItemRowHolder(binding : WordBoardItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
   var letter : TextView = binding.letterLabel
}