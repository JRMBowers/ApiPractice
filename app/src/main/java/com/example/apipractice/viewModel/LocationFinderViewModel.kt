package com.example.apipractice.viewModel

import androidx.compose.runtime.mutableStateListOf
import kotlinx.coroutines.flow.MutableStateFlow

class LocationFinderViewModel {
    val currentSearchResult: MutableStateFlow<List<String>> = MutableStateFlow(mutableStateListOf())
    fun submitSearch(locationCode: String) {
        currentSearchResult.value = mutableListOf(locationCode, "456", "789")
    }
}