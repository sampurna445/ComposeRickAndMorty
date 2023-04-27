package com.example.composerickandmorty.ui.characters

import android.annotation.SuppressLint
import android.widget.Toolbar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.lazy.itemsIndexed

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


// Main screen of the app
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartoonCharactersScreen(

) {
    val cartoonCharViewModel: CartoonCharactersViewModel=hiltViewModel()

    val cartoonChars by cartoonCharViewModel.cartoonChars.collectAsState()


    // Filtered product list based on search query
    val searchQuery = remember { mutableStateOf("") }

    val filteredCartoonCharsList =
        if (searchQuery.value.isBlank()) {
            cartoonChars
        } else {
            cartoonChars.filter { cartoonChar ->
                cartoonChar?.name!!.contains(searchQuery.value, ignoreCase = true)
            }
        }



    Scaffold(
        topBar = { Toolbar() }
    ) {
        Column(
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Toolbar()
            SearchBar(searchQuery)

            LazyColumn(
                modifier = Modifier
                    .padding(top = 10.dp)

            ) {
                itemsIndexed(filteredCartoonCharsList) { _, cartoonCharItem ->
                    if (cartoonCharItem != null) {
                        CartoonCharacterItem(cartoonCharItem)
                    }
                }

            }

        }


    }


}
@Composable
fun Toolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .height(56.dp)
            .background(color = Color(0xffe754ac)),
       horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Cartoon Characters",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color(0xff1228e6),
            modifier = Modifier
                .padding(end = 10.dp)
        )
    }

}


@Composable
fun SearchBar(

    searchQuery: MutableState<String>, modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = searchQuery.value,
        onValueChange = {searchQuery.value=it},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            //MaterialTheme.colorScheme.onPrimary
        ),
        placeholder = {
            Text("Search Cartoons by Name")
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
    )
}
