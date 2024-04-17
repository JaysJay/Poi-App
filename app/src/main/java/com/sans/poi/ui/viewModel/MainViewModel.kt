package com.sans.poi.ui.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.hadilq.liveevent.LiveEvent
import com.sans.poi.data.model.ListPoint
import com.sans.poi.data.model.Suggestion
import com.sans.poi.data.repository.POIRepository
import com.sans.poi.utility.state.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    app: Application,
    private val repo: POIRepository
) : BaseViewModel(app) {

    var searchKey = ""

    private var _getQuerySearch: LiveEvent<Resource<ListPoint.Response>> = LiveEvent()
    val getQuerySearch: LiveData<Resource<ListPoint.Response>> get() = _getQuerySearch

    private var _getSuggestion: LiveEvent<Resource<Suggestion.Response>> = LiveEvent()
    val getSuggestion: LiveData<Resource<Suggestion.Response>> get() = _getSuggestion

    fun getQuerySearch(request: ListPoint.Request) = viewModelScope.launch {
        _getQuerySearch.postValue(Resource.Loading())

        try {
            val data = repo.getSearch(request)
            _getQuerySearch.postValue(data)
        } catch (e: Exception){
            e.printStackTrace()
            _getQuerySearch.postValue(Resource.Error(handleException(e)))
        }
    }

    fun getSuggestionWord(request: Suggestion.Request) = viewModelScope.launch {
        _getSuggestion.postValue(Resource.Loading())

        try {
            val data = repo.getSuggestionWord(request)
            _getSuggestion.postValue(data)
        } catch (e: Exception){
            e.printStackTrace()
            _getSuggestion.postValue(Resource.Error(handleException(e)))
        }
    }
}