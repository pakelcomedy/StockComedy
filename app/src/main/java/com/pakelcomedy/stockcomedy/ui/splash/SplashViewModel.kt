package com.pakelcomedy.stockcomedy.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashViewModel : ViewModel() {

    private val _appVersion = MutableLiveData<String>()
    val appVersion: LiveData<String> get() = _appVersion

    init {
        _appVersion.value = "Version 1.0.0"
    }
}