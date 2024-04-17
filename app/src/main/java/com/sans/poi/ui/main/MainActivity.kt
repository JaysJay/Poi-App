package com.sans.poi.ui.main

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sans.poi.R
import com.sans.poi.data.model.ListPoint
import com.sans.poi.data.model.Suggestion
import com.sans.poi.databinding.ActivityMainBinding
import com.sans.poi.databinding.DialogLoadingBinding
import com.sans.poi.ui.adapter.ListItemAdapter
import com.sans.poi.ui.adapter.SuggestionAdapter
import com.sans.poi.ui.viewModel.MainViewModel
import com.sans.poi.utility.MapsHelper
import com.sans.poi.utility.state.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val suggestionAdapter by lazy { SuggestionAdapter() }
    private val listItemAdapter by lazy { ListItemAdapter() }
    private lateinit var suggestions: ArrayList<String>
    private lateinit var mapsHelper: MapsHelper
    private var progressDialog: Dialog? = null

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //permission
        mapsHelper = MapsHelper(this)
        mapsHelper.requestLocationPermission(this)
        progressDialog = Dialog(this)

        setupSearchView()
        setupObserver()
    }

    override fun onResume() {
        super.onResume()
        with(binding){
            include.searchView.setQuery("",false)
        }
    }

    private fun setupSearchView(){
        with(binding){
            // Set up adapter
            suggestionListView.adapter = suggestionAdapter
            suggestionListView.layoutManager = LinearLayoutManager(this@MainActivity)
            suggestionListView.isNestedScrollingEnabled = false

            listItemView.adapter = listItemAdapter
            listItemView.layoutManager = LinearLayoutManager(this@MainActivity)
            listItemView.isNestedScrollingEnabled = false

            listItemAdapter.onClickListener {
                //go to detail
            }

            suggestionAdapter.onClickListener {
                it.description?.let { it1 -> getSearchQuery(it1) }
                suggestionListView.visibility = View.GONE
            }

            // Set search view listeners
            include.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    getSearchQuery(query)
                    return false
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    if (newText.isNotEmpty()){
                        suggestionListView.visibility = View.VISIBLE
                        viewModel.searchKey = newText
                        getSuggestion(newText)
                    }else{
                        suggestionListView.visibility = View.GONE
                    }
                    return false
                }
            })

            include.searchView.setOnQueryTextFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    suggestionListView.visibility = View.VISIBLE
                } else {
                    suggestionListView.visibility = View.GONE
                }
            }

            include.searchCloseBtn.setOnClickListener { include.searchView.setQuery("", false) }
        }


    }

    private fun getSuggestion(query: String){
        mapsHelper.getDefaultLocation{
            if (it != null){
                viewModel.getSuggestionWord(
                    Suggestion.Request(
                        query = query,
                        coordinates = "${it.latitude},${it.longitude}"
                    )
                )
            }
        }
    }

    private fun getSearchQuery(query: String){
        mapsHelper.getDefaultLocation{
            if (it != null){
                viewModel.getQuerySearch(
                    ListPoint.Request(
                        query = query,
                        lat = it.latitude.toString(),
                        lng = it.longitude.toString()
                    )
                )
            }
        }
    }

    private fun setupObserver(){
        viewModel.getQuerySearch.observe(this){
            when (it){
                is Resource.Loading ->{
                    showProgressDialog()
                }
                is Resource.Success ->{
                    dissmissProgressDialog()
                    when(it.data?.status?.lowercase()){
                        "ok" ->{
                            binding.groupNoData.visibility = View.GONE
                            binding.listItemView.visibility = View.VISIBLE


                            it.data.data?.let { it1 -> listItemAdapter.replaceList(it1) }
                        }
                        else ->{
                            binding.groupNoData.visibility = View.VISIBLE
                            binding.listItemView.visibility = View.GONE
                        }
                    }

                }
                is Resource.Error ->{
                    dissmissProgressDialog()

                }
                else ->{
                    dissmissProgressDialog()

                }
            }
        }

        viewModel.getSuggestion.observe(this){
            when (it){
                is Resource.Loading ->{

                }
                is Resource.Success ->{
                    when(it.data?.status?.lowercase()){
                        "ok" ->{
                            it.data.data?.let { it1 -> suggestionAdapter.replaceList(it1) }
                        }
                        else ->{
                            binding.suggestionListView.visibility = View.GONE
                        }
                    }

                }
                is Resource.Error ->{

                }
                else ->{

                }
            }
        }
    }

    private fun showProgressDialog(){
        val binding: DialogLoadingBinding =
            DialogLoadingBinding.inflate(LayoutInflater.from(this))

        if (!progressDialog?.isShowing!!) {
            progressDialog = Dialog(this, R.style.RoundedAlertDialog)
            progressDialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
            progressDialog?.setContentView(binding.root)
            progressDialog?.setCancelable(false)
           progressDialog?.show()
        }
    }

    private fun dissmissProgressDialog(){
        progressDialog?.dismiss()
    }
}