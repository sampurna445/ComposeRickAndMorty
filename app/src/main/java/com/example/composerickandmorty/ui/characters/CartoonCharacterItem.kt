package com.example.composerickandmorty.ui.characters

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
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
import com.example.composerickandmorty.data.model.characters.ResultModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartoonCharacterItem(cartoonCharitem: ResultModel){


    var isClicked by remember { mutableStateOf(false) }

    Column {
        ClickableCard(onCardClick = { isClicked = true },
            cartoonCharitem)

    }
//For the expanded car visibility
   AnimatedVisibility(isClicked) {


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(16.dp)// Set the background color
        )
        {
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .padding(8.dp)
                    .clickable {
                        isClicked = !isClicked

                    }

            ) {
                Column(verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.padding(16.dp)) {
                    /*AnimatedVisibility(visible = isExpanded) {*/
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            "Name:",
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.End,
                            modifier = Modifier.padding(start = 24.dp)
                        )
                        cartoonCharitem.name?.let {
                            Text(
                                it,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            "Status:",
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.End
                        )
                        cartoonCharitem.status?.let {
                            Text(
                                it,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            "Gender:",
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.End
                        )
                        cartoonCharitem.gender?.let {
                            Text(
                                it,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            "Origin:",
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.End,
                            modifier = Modifier.padding(start = 24.dp)
                        )
                        cartoonCharitem.origin?.name.let {
                            if (it != null) {
                                Text(
                                    it,
                                    color = Color.Blue,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier.padding(start = 8.dp)
                                )
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
                        Text(
                            "Species:",
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.End
                        )
                        cartoonCharitem.species?.let {
                            Text(
                                it,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(24.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(cartoonCharitem.image),
                            contentDescription = "",
                            modifier = Modifier
                                .size(height = 150.dp, width = 90.dp)
                                .weight(0.5f)
                                .padding(5.dp)
                        )
                    }
                }
                }

            }



    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClickableCard(onCardClick: () -> Unit,
                  cartoonCharitem: ResultModel) {

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
                .clickable(onClick = onCardClick)
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

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandedCard(onExpandedCardClick: () -> Unit,
                 onExpandedCardCollapse : () -> Unit,
                 cartoonCharitem:ResultModel){
   // var isExpanded by remember { mutableStateOf(false) }


}
/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClickableCard(onCardClick: () -> Unit,
                  onCardCollapse: () -> Unit,
                  cartoonCharitem: ResultModel) {

    var isExpanded by remember { mutableStateOf(true) }

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
                .animateContentSize()
                .clickable {
                    if (isExpanded) {

                        LaunchedEffect(isExpanded) {
                            isExpanded = false
                            onCardCollapse()
                        }
                    } else {
                        isExpanded = true
                        onCardClick()
                    }
                },
            elevation = CardDefaults.cardElevation(
                defaultElevation = if (isExpanded) 24.dp else 2.dp
            )
        ) {

                Column(
                    modifier = Modifier
                        .animateContentSize()
                        .padding(16.dp)
                ) {
                    AnimatedVisibility(visible = isExpanded) {
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

                            Column(
                                modifier = Modifier.padding(20.dp)
                            ) {
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


    }
}

*/
