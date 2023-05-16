package com.sample.characterviewer_sdk.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.characterviewer_sdk.databinding.ListCharacterBinding
import com.sample.characterviewer_sdk.model.ProfileChar

class CharacterAdapter(
    private val characters: MutableList<ProfileChar> = mutableListOf(),
    private val itemClickListener: (ProfileChar) -> Unit
): RecyclerView.Adapter<CharacterAdapter.ViewHolder>()  {

    fun updateChar(newChar: List<ProfileChar>?){
        characters.clear()
        if (newChar != null) {
            characters.addAll(newChar)
        }
        notifyDataSetChanged()
    }
    inner class ViewHolder(
        private val view: ListCharacterBinding
        ): RecyclerView.ViewHolder(view.root) {
        fun initUI(Character: ProfileChar, clickListener: (ProfileChar) -> Unit) {
            view.charName.text = Character.name

            itemView.setOnClickListener {
                clickListener(Character)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ListCharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.initUI(characters[position], itemClickListener)
    }

}