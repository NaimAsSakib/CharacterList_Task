package com.example.characterlisttask.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.characterlisttask.R
import com.example.characterlisttask.api.models.CharacterListResponseItem
import com.example.characterlisttask.databinding.ItemRcvBinding

class CharacterListAdapter(private val list: List<CharacterListResponseItem>, private val callback:(String)->Unit): RecyclerView.Adapter<CharacterListAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemRcvBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListAdapter.ViewHolder {
        return ViewHolder(ItemRcvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CharacterListAdapter.ViewHolder, position: Int) {
        val current = list.get(position)

        val fullName = current.name?:"Not Available"
        val nameParts = fullName.split(" ")
        val lastName = nameParts.lastOrNull()
        val firstName = nameParts.dropLast(1).joinToString(" ")

        val image = current.image?:""
        val gender = current.gender?.capitalize()?:"Not Available"
        holder.binding.tvFirstNameValue.text = firstName
        holder.binding.tvLastNameValue.text = lastName
        holder.binding.tvGenderValue.text = gender

        Glide.with(holder.itemView.context)
            .load(image)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.baseline_person_24)
            .into(holder.binding.ivCharacter)

        holder.binding.root.setOnClickListener {
            callback(current.id?:"")
        }
    }

    override fun getItemCount(): Int = list.size

}