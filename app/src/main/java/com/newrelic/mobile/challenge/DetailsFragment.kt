package com.newrelic.mobile.challenge

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.newrelic.mobile.challenge.models.BreedsModel

class DetailsFragment : Fragment() {
    private lateinit var catFactsDataSource: CatFactsDataSource
    private lateinit var catFactsDataset: BreedsModel
    private lateinit var datasetAdapter: CatFactsAdapter
    private lateinit var recyclerView: RecyclerView


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        /**
//         * Set up the cat facts model and datasource
//         */
//        catFactsDataSource = CatFactsDataSource.getInstance()
//        datasetAdapter = CatFactsAdapter()
//    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // this is related to fragmentdetail
//        recyclerView = view.findViewById<RecyclerView>(R.id.detailList)
//        recyclerView.setHasFixedSize(true)

        Log.d("DetailsFragment", arguments.toString())

        activity?.actionBar?.setTitle(R.string.details)
    }

    // make this similar to breedsFragment, want to make the details page to give details
//    override fun onStart() {
//        super.onStart()
//        doAsync {
//            catFactsDataset = catFactsDataSource.getCatFact()
//            uiThread {
//                // bind to the recycler view
//                datasetAdapter.dataset = catFactsDataset
//                recyclerView.adapter = datasetAdapter
//            }
//        }
//    }
}
