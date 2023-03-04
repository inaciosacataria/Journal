package com.decode.journal.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeActivityViewModel : ViewModel() {
    val viewState = MutableLiveData<ViewState>()
}