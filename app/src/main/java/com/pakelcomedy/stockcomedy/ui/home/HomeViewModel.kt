package com.pakelcomedy.stockcomedy.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    // LiveData for greeting or welcome message
    private val _greetingMessage = MutableLiveData<String>()
    val greetingMessage: LiveData<String> get() = _greetingMessage

    // LiveData for current tab title
    private val _currentTab = MutableLiveData<String>()
    val currentTab: LiveData<String> get() = _currentTab

    init {
        setGreetingMessage()
    }

    private fun setGreetingMessage() {
        val currentHour = java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY)
        _greetingMessage.value = when {
            currentHour in 5..11 -> "Good Morning! Ready to trade?"
            currentHour in 12..17 -> "Good Afternoon! Let's check the market."
            else -> "Good Evening! Review your portfolio?"
        }
    }

    fun updateCurrentTab(tabTitle: String) {
        _currentTab.value = tabTitle
    }
}