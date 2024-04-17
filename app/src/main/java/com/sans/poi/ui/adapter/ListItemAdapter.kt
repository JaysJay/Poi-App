package com.sans.poi.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sans.poi.R
import com.sans.poi.data.model.ListPoint
import com.sans.poi.databinding.ListItemPointBinding
import com.sans.poi.databinding.SingleItemLayoutBinding
import com.sans.poi.utility.GlideApp

class ListItemAdapter :
    RecyclerView.Adapter<ListItemAdapter.ViewHolder>() {

    private val suggestions = mutableListOf<ListPoint.DataItem>()
    private var onClickListener: ((response: ListPoint.DataItem) -> Unit)? = null

    fun onClickListener(listener:(response: ListPoint.DataItem) -> Unit){
        onClickListener = listener
    }

    fun replaceList(lmenu: List<ListPoint.DataItem>){
        suggestions.clear()
        suggestions.addAll(lmenu)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ListItemPointBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(suggestion: ListPoint.DataItem) {
            suggestion.let {
                with(binding){
                    tvAddress.text = it.fullAddress
                    tvDesc.text = it.name
                    tvPhone.text = it.phoneNumber
                    tvRating.text = if (it.rating == null) "-" else it.rating.toString()
                    tvRatingCount.text = "(${it.reviewCount})"
                    if (it.businessStatus.equals("open",true)){
                        tvStatus.text = "Open"
                        tvStatus.setTextColor(Color.GREEN)
                    }else{
                        tvStatus.text = "Closed"
                        tvStatus.setTextColor(Color.RED)
                    }
                    if (it.photosSample?.isNotEmpty() == true){
                        GlideApp.with(imgPlace)
                            .load(it.photosSample[0].photoUrl)
                            .error(R.drawable.baseline_image_not_supported_24)
                            .into(imgPlace)
                    }else{
                        GlideApp.with(imgPlace)
                            .load(R.drawable.baseline_image_not_supported_24)
                            .into(imgPlace)
                    }

                    itemView.setOnClickListener { view ->
                        onClickListener?.invoke(it)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
        ListItemPointBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(suggestions[position])
    }

    override fun getItemCount(): Int {
        return suggestions.size
    }
}