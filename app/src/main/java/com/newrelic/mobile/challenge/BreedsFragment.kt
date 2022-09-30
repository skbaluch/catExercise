package com.newrelic.mobile.challenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.newrelic.mobile.challenge.models.BreedsModel
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class BreedsFragment : Fragment() {
    private lateinit var catFactsDataSource: CatFactsDataSource
    private lateinit var catFactsDataset: BreedsModel
    private lateinit var datasetAdapter: CatFactsAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * Set up the cat facts model and datasource
         */
        catFactsDataSource = CatFactsDataSource.getInstance()
        datasetAdapter = CatFactsAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_breeds, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById<RecyclerView>(R.id.breedsList)
        recyclerView.setHasFixedSize(true)

        activity?.actionBar?.setTitle(R.string.breeds)
    }

    /* the function doesn't override */
     fun onClick(v: View?) {
    }

    /* imported doAsync and uiThread*/
    override fun onStart() {
        super.onStart()
        doAsync {
            catFactsDataset = catFactsDataSource.getBreeds(null)
            uiThread {
                // bind to the recycler view
                datasetAdapter.dataset = catFactsDataset
                recyclerView.adapter = datasetAdapter
            }
        }
    }
}
