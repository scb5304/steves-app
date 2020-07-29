package com.stevenbrown.stevesapp.places

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stevenbrown.stevesapp.R
import com.stevenbrown.stevesapp.models.Place

class PlacesAdapter: RecyclerView.Adapter<PlacesAdapter.PlacesViewHolder>() {

    private var places: List<Place> = ArrayList()

    fun setData(places: List<Place>) {
        this.places = places
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacesViewHolder {
        return PlacesViewHolder(View.inflate(parent.context, R.layout.item_place, null))
    }

    override fun getItemCount(): Int {
        return places.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PlacesViewHolder, position: Int) {
        holder.placeNameTextView.text = places[position].name
    }

    class PlacesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var placeNameTextView: TextView = itemView.findViewById(R.id.place_name_textview)
    }
}