package com.rogergcc.retorgcprojectmdevconf2020


/**
 * Created by rogergcc on 19/12/2020.
 * Copyright Ⓒ 2020 . All rights reserved.
 */

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rogergcc.retorgcprojectmdevconf2020.databinding.ItemSpeakersBinding
import com.rogergcc.retorgcprojectmdevconf2020.model.mSpeaker


class SpeakerAdapter : RecyclerView.Adapter<MyViewHolder>() {
    var list: List<mSpeaker> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.getContext())
//
//        val itemBinding: ItemSpeakersBinding =
//            ItemSpeakersBinding.inflate(layoutInflater, parent, false)

//        val view = ItemSpeakersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val layoutInflater=LayoutInflater.from(parent.context)
        return MyViewHolder(layoutInflater.inflate(R.layout.item_speakers,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setItems(newList: List<mSpeaker>) {
        list = newList
        notifyDataSetChanged()
    }
}
class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
    val _binding = ItemSpeakersBinding.bind(view)

    fun bind(mspeaker: mSpeaker) {
        _binding.tvSpeakerData.text = mspeaker.name
        _binding.tvCityCountry.text = mspeaker.origin
        _binding.tvBio.text = mspeaker.bio
    }
}

//class MyViewHolder
// (private val binding: ItemSpeakersBinding) :
//
//    RecyclerView.ViewHolder(binding.root) {
//    val _binding = ItemSpeakersBinding.bind(view)
//    var  ingredientesBinding:ItemSpeakersBinding? = null
//
//    fun bind(slideContent: mSpeaker) {
//        ingredientesBinding = binding
//    }
//}