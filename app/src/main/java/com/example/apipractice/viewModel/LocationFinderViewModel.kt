package com.example.apipractice.viewModel

import androidx.compose.runtime.mutableStateListOf
import kotlinx.coroutines.flow.MutableStateFlow

class LocationFinderViewModel {
    private val currentSearchResult: MutableStateFlow<List<String>> = MutableStateFlow(mutableStateListOf())
    fun submitSearch() {
        currentSearchResult.value = mutableListOf("123", "456", "789")
    }

    fun getCurrentSearchResult(): MutableStateFlow<List<String>> {
        return currentSearchResult
    }
}