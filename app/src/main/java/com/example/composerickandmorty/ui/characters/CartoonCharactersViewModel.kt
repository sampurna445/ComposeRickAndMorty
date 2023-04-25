package com.example.composerickandmorty.ui.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composerickandmorty.ui.data.model.characters.ResultModel
import com.example.composerickandmorty.ui.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartoonCharactersViewModel@Inject constructor(
    private val repository: Repository
):ViewModel(){

    //Mutable State Flow to store the data
    private val _cartoonChars = MutableStateFlow<List<ResultModel?>>(emptyList())
    val cartoonChars: StateFlow<List<ResultModel?>> = _cartoonChars

    //Initialising the API call request to fetch the data
    init {
        getCharacters()
    }

    fun getCharacters() {
        viewModelScope.launch {
            // Call the repository to fetch the list of cartoon characters
            val response = repository.getCharacters()
            // Update the state with the cartoon characters
            _cartoonChars.value = response.results ?:listOf<ResultModel>()

        }
    }
}