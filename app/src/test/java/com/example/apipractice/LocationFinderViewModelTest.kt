package com.example.apipractice

import com.example.apipractice.viewModel.LocationFinderViewModel
import org.junit.Assert.assertEquals
import org.junit.Test


class LocationFinderViewModelTest {
    val subject = LocationFinderViewModel()

    @Test
    fun `WHEN location code query is submitted THEN list of values returned`() {
        val expectedResult = listOf("London","456","789")
        assertEquals(subject.currentSearchResult.value, emptyList<String>())
        subject.submitSearch("London")
        assertEquals(subject.currentSearchResult.value, expectedResult)
    }
}