package com.example.apipractice.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apipractice.R
import com.example.apipractice.viewModel.LocationFinderViewModel
import kotlin.reflect.KFunction1

@Composable
@Preview
fun LocationFinderScreen(viewModel: LocationFinderViewModel = LocationFinderViewModel()) {
    val searchResultState = viewModel.currentSearchResult.collectAsState()
    val textInput = remember { mutableStateOf("") }
    val shouldShowPlaceholderText = remember { derivedStateOf { textInput.value.isEmpty() } }
    val placeHolder = stringResource(id = R.string.input_location_code)
    LocationFinderContent(textInput, shouldShowPlaceholderText, placeHolder, viewModel::submitSearch, searchResultState)
}

@Composable
private fun LocationFinderContent(
    textInput: MutableState<String>,
    shouldShowPlaceholderText: State<Boolean>,
    placeHolder: String,
    onFindLocation: (String) -> Unit,
    searchResultState: State<List<String>>
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.location_finder), Modifier.padding(top = 16.dp))
        TextField(
            modifier = Modifier.padding(top = 16.dp),
            value = textInput.value,
            onValueChange = { textInput.value = it },
            placeholder = { if (shouldShowPlaceholderText.value) Text(text = placeHolder) })
        Button(onClick = { onFindLocation.invoke(textInput.value) } , modifier = Modifier.padding(top = 16.dp)) {
            Text(text = stringResource(id = R.string.find_location))
        }
        LazyColumn(Modifier.padding(bottom = 36.dp)) {
            items(searchResultState.value) {
                Text(text = "Placeholder locations $it")
            }
        }
    }
}