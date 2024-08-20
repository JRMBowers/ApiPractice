package com.example.apipractice

import com.example.apipractice.viewModel.LocationFinderViewModel
import org.junit.Assert.assertEquals
import org.junit.Test


class LocationFinderViewModelTest {
    val subject = LocationFinderViewModel()

    @Test
    fun `WHEN location code query is submitted THEN value returned`() {
        val expectedResult = "123"
        assertEquals(subject.getLocationCode(), expectedResult)
    }
}