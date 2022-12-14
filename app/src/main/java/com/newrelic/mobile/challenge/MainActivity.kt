package com.newrelic.mobile.challenge

import android.content.DialogInterface
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.randomCatFact).setOnClickListener { view ->
            val catFactModel = CatFactsDataSource.getInstance().getCatFact()
            Snackbar.make(
                view, getString(R.string.random_cat_fact_label) + catFactModel,
                Snackbar.LENGTH_LONG
            )
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_metrics -> return super.onOptionsItemSelected(item)
            else -> super.onOptionsItemSelected(item)
        }
    }

     fun showAlertDialog()
    {
        val builder:AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("network not connected")

        builder.setPositiveButton("ok", DialogInterface.OnClickListener{ dialog, which -> dialog.dismiss()})

        val alertDialog:AlertDialog = builder.create()
        alertDialog.show()

    }

}