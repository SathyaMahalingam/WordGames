package com.sample.wordgame.wordfinder.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sample.wordgame.databinding.WordResultItemViewBinding

/**
 * WordResultAdapter class acts as adapter and used to bind data to the each item view in Words List Screen
 */
class WordResultAdapter(private var context: Context?,
                        private var items:  MutableList<String>?)  : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = WordResultItemViewBinding.inflate( LayoutInflater.from(context), parent, false)
        return AvailableWordsItemRowHolder(binding)
    }

    override fun getItemCount(): Int {
        return if(items == null)
            0
        else
            items?.size!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as AvailableWordsItemRowHolder).words.text = items?.get(position).toString()
    }
}

/**
 * View holder class for available words list item row
 */
class AvailableWordsItemRowHolder(binding : WordResultItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
    var words : TextView = binding.wordsLabel
}