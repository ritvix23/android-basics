package com.example.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.Dataset
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val affirmationDataset = Datasource().getAffirmations()

        val recyclerView  = findViewById<RecyclerView>(R.id.itemRecycler)
        recyclerView.adapter = ItemAdapter(this,  affirmationDataset)




    }
}