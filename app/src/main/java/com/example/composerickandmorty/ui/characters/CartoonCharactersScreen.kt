package com.example.composerickandmorty.ui.characters

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

// Main screen of the app
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartoonCharactersScreen(
    cartoonCharViewModel: CartoonCharactersViewModel = viewModel()
) {
    val cartoonChars by cartoonCharViewModel.cartoonChars.collectAsState()

    Scaffold(
        topBar = { Toolbar() }
    ) {
        Box(
            modifier = Modifier.padding(top = 64.dp)
        ) {
            // Content Composables
            SearchBar()


            // Display the list of cartoon characters  in a LazyColumn
            LazyColumn {
                items(cartoonChars){cartoonCharItem ->
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
    modifier: Modifier = Modifier
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        placeholder = {
            //Text(stringResource(R.string.placeholder_search))
            Text("Search Cartoons by Name")
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
            .background(color = Color.LightGray, shape = RectangleShape)

    )
}
