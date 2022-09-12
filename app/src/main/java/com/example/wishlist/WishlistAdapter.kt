package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val wishlistItems: MutableList<WishlistItem>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>(){
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        // as you render a row.
        val nameTextView: TextView
        val priceTextView: TextView
        val urlTextView: TextView



        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // the public final member variables created above
            nameTextView = itemView.findViewById<TextView>(R.id.nameTv)
            priceTextView = itemView.findViewById<TextView>(R.id.priceTv)
            urlTextView = itemView.findViewById<TextView>(R.id.urlTv)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Populate data into the item through the holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val Wishlistitem = wishlistItems.get(position)
        // Set item views based on views and data model
        holder.nameTextView.text = Wishlistitem.name
        holder.priceTextView.text = Wishlistitem.price.toString()
        holder.urlTextView.text = Wishlistitem.url
    }

    override fun getItemCount(): Int {
        return wishlistItems.size
    }

}
