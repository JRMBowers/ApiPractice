package com.example.apipractice.viewModel

import androidx.compose.runtime.mutableStateListOf
import kotlinx.coroutines.flow.MutableStateFlow

class LocationFinderViewModel {
    val currentSearchResult: MutableStateFlow<List<String>> = MutableStateFlow(mutableStateListOf())
    fun submitSearch() {
        currentSearchResult.value = mutableListOf("123", "456", "789")
    }
}