package com.grupog.atividadefase2.adapter

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.grupog.atividadefase2.DeletarImovelActivity
import com.grupog.atividadefase2.ImoveisActivity
import com.grupog.atividadefase2.R
import com.grupog.atividadefase2.model.Imovel

class ItemAdapter(private val context: Context, private val dataset:List<Imovel>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view:View):RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset.get(position)
       // holder.imageView.setImageResource(R.drawable.delete)
        holder.textView.text = item.toString()
       // holder.imageView.setOnClickListener(context,position) //Botão de apagar

    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}


