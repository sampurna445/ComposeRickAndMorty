package com.example.composerickandmorty.ui.characters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.composerickandmorty.ui.data.model.characters.ResultModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartoonCharacterItem(cartoonCharitem: ResultModel){


    var isClicked by remember { mutableStateOf(false) }
    Column {
        ClickableCard(onClick = { isClicked = true },cartoonCharitem)

    }
    if(isClicked) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan) // Set the background color
        ) {
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Column() {
                    Row( modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.SpaceAround) {
                        Text("Name:",
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Left)
                        cartoonCharitem.name?.let { Text(it,
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Start) }
                    }
                    Row( modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.SpaceAround) {
                        Text("Status:",
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Left)
                        cartoonCharitem.status?.let { Text(it,
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Start) }
                    }
                    Row( modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.SpaceAround) {
                        Text("Gender:",
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Left)
                        cartoonCharitem.gender?.let { Text(it,
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Start) }
                    }
                    Row( modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.SpaceAround) {
                        Text("Origin:",
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Left)
                        cartoonCharitem.origin?.name.let {
                            if (it != null) {
                                Text(it,
                                    color = Color.Blue,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start)
                            }
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 24.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text("Species:",
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Left)
                    cartoonCharitem.species?.let { Text(it,
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start) }
                }
                Row() {
                    Image(
                        painter = rememberAsyncImagePainter(cartoonCharitem.image),
                        contentDescription = ""
                    )
                }
            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClickableCard(onClick: () -> Unit,cartoonCharitem: ResultModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Magenta) // Set the background color
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clickable(onClick = onClick)
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 24.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = rememberAsyncImagePainter(cartoonCharitem.image),
                    contentDescription = "",
                    modifier = Modifier
                        .size(height = 180.dp, width = 90.dp)
                        .weight(0.5f)
                        .padding(5.dp)

                )

                Column() {
                    cartoonCharitem.name?.let {
                        Text(text = it,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Left
                        )
                    }
                    cartoonCharitem.status?.let { Text(text = it,
                            color = Color.Black,
                        fontWeight = FontWeight.Bold
                    ) }
                }
            }
        }
    }
}

