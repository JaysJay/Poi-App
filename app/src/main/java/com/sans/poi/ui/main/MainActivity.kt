package com.sans.poi.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sans.poi.R
import com.sans.poi.databinding.ActivityMainBinding
import com.sans.poi.ui.adapter.SuggestionAdapter
import com.sans.poi.ui.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val suggestionAdapter by lazy { SuggestionAdapter() }
    private lateinit var suggestions: ArrayList<String>

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSearchView()
    }

    override fun onResume() {
        super.onResume()
        with(binding){
            include.searchView.setQuery("",false)
        }
    }

    private fun setupSearchView(){
        // Initialize suggestion list
        suggestions = ArrayList()
        suggestions.add("Suggestion 1")
        suggestions.add("Suggestion 2")
        suggestions.add("Suggestion 3")
        suggestions.add("Suggestion 3")
        suggestions.add("Suggestion 3")
        suggestions.add("Suggestion 3")
        suggestions.add("Suggestion 3")
        suggestions.add("Suggestion 3")
        suggestions.add("Suggestion 3")
        suggestions.add("Suggestion 3")
        suggestions.add("Suggestion 3")
        suggestions.add("Suggestion 3")
        suggestions.add("Suggestion 3")
        suggestions.add("Suggestion 3")
        suggestions.add("Suggestion 3")

        with(binding){
            // Set up adapter
            suggestionListView.adapter = suggestionAdapter
            suggestionListView.layoutManager = LinearLayoutManager(this@MainActivity)
            suggestionListView.isNestedScrollingEnabled = false

            suggestionAdapter.onClickListener {
                Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
            }

            // Set search view listeners
            include.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    //show only some query
                    return false
                }
            })

            // Show suggestion list when search view gains focus
            include.searchView.setOnQueryTextFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    suggestionListView.visibility = View.VISIBLE
                } else {
                    suggestionListView.visibility = View.GONE
                }
            }

            include.searchCloseBtn.setOnClickListener { include.searchView.setQuery("", false) }

            suggestionAdapter.replaceList(suggestions)
        }


    }
}