package com.example.tugasmobile.ui.matchlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MatchListsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Ini Match List"
    }
    val text: LiveData<String> = _text
}