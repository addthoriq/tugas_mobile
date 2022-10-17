package com.example.tugasmobile.ui.teamlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TeamListsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Ini Team List"
    }
    val text: LiveData<String> = _text
}