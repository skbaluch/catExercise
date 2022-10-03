package com.newrelic.mobile.challenge

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.newrelic.mobile.challenge.models.BreedsModel
import com.newrelic.mobile.challenge.models.DetailModel



class CatFactsAdapter(
    var dataset: BreedsModel
) : RecyclerView.Adapter<CatFactsAdapter.BreedViewHolder>() {

    constructor() : this(BreedsModel())
    class BreedViewHolder(private val view: View, adapter: CatFactsAdapter) :
        RecyclerView.ViewHolder(view) {

        init {
            itemView.setOnClickListener {
                bindModel(adapter.dataset.data[adapterPosition])
                val navController = Navigation.findNavController(itemView)
                navController.navigate(
                R.id.action_breed_list_to_breed_detail,
                bundleOf("detailModel" to "DetailModel")
                )
                Log.e("msg", "update the list view here")

                var breed: TextView = view.findViewById(R.id.breed)
                var country: TextView = view.findViewById(R.id.country)
                var origin: TextView = view.findViewById(R.id.origin)
                var coat: TextView = view.findViewById(R.id.coat)
                var pattern: TextView = view.findViewById(R.id.pattern)

                fun bindModel(breadDetailModel: DetailModel) {
                    breed.text = breadDetailModel.breed
                    country.text = breadDetailModel.country
                    origin.text = breadDetailModel.origin
                    coat.text = breadDetailModel.coat
                    pattern.text = breadDetailModel.pattern
                }

            }

        }

        var breed: TextView = view.findViewById(R.id.breed)

        fun bindModel(detailModel: DetailModel) {
            breed.text = detailModel.breed
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        // create a breed list item
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
       return BreedViewHolder(adapterLayout, this)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        val item = dataset.data[position]
        holder.bindModel(item)
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount(): Int {
        return dataset.data.size
    }
}

