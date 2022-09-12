package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    var wishlistItems: MutableList<WishlistItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val WishlistItemsRv = findViewById<RecyclerView>(R.id.wishlistItemRv)


        var itemsAdapter = WishlistAdapter(wishlistItems)

        WishlistItemsRv.adapter = itemsAdapter

        WishlistItemsRv.layoutManager = LinearLayoutManager(this)

        var itemNameEtv = findViewById<EditText>(R.id.itemNameEtv)
        var priceEtv = findViewById<EditText>(R.id.priceEtv)
        var urlEtv = findViewById<EditText>(R.id.urlEtv)

        var addItembtn = findViewById<Button>(R.id.addItembtn)

        addItembtn.setOnClickListener{
            var newItem1 = WishlistItem(itemNameEtv.text.toString(), priceEtv.text.toString().toDouble(), urlEtv.text.toString())
            wishlistItems.add(newItem1)
            itemsAdapter.notifyDataSetChanged()
        }




    }
}