package com.sans.poi.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sans.poi.R
import com.sans.poi.data.model.Suggestion
import com.sans.poi.databinding.SingleItemLayoutBinding

class SuggestionAdapter :
    RecyclerView.Adapter<SuggestionAdapter.ViewHolder>() {

    private val suggestions = mutableListOf<Suggestion.DataItem>()
    private var onClickListener: ((data: Suggestion.DataItem) -> Unit)? = null

    fun onClickListener(listener:(data: Suggestion.DataItem) -> Unit){
        onClickListener = listener
    }

    fun replaceList(lmenu: List<Suggestion.DataItem>){
        suggestions.clear()
        suggestions.addAll(lmenu)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: SingleItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(suggestion: Suggestion.DataItem) {
            suggestion.let {
                with(binding){
                    tvSuggetion.text = it.description
                    itemView.setOnClickListener { view ->
                        onClickListener?.invoke(it)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
        SingleItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(suggestions[position])
    }

    override fun getItemCount(): Int {
        return suggestions.size
    }
}