package com.sans.poi.ui.viewModel

import android.app.Application
import com.sans.poi.data.repository.POIRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    app: Application,
    private val repo: POIRepository
) : BaseViewModel(app) {

    //get data
}