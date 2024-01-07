package com.kivous.jetpackcomposeui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kivous.jetpackcomposeui.R
import com.kivous.jetpackcomposeui.ui.theme.Coral
import com.kivous.jetpackcomposeui.ui.theme.Orange
import com.kivous.jetpackcomposeui.ui.theme.Purple

@Composable
fun HomeScreen() {

    Scaffold(
        containerColor = Color.White,
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.padding(8.dp))
            ToolBar()
            Spacer(modifier = Modifier.padding(top = 24.dp))
            Text(modifier = Modifier.padding(horizontal = 24.dp),
                fontSize = 28.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                lineHeight = 28.sp,
                text = buildAnnotatedString {
                    append("Choose what\n")
                    withStyle(
                        style = SpanStyle(
                            fontFamily = FontFamily(Font(R.font.poppins_bold))
                        )
                    ) {
                        append("to learn today?")
                    }

                })
            Spacer(modifier = Modifier.padding(top = 24.dp))

            var isSelected by remember {
                mutableStateOf(false)
            }

            GenreSection()


            Spacer(modifier = Modifier.padding(16.dp))

            CardPart()

            Spacer(modifier = Modifier.padding(16.dp))

            Text(
                text = "Recommended",
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 24.dp),
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                color = Color.Black
            )

            Spacer(modifier = Modifier.padding(8.dp))

            val recommendationList = listOf(
                RecommendedItemModel("Chatting", "5 minutes", Coral, R.drawable.chat),
                RecommendedItemModel("Listen", "2 minutes", Purple, R.drawable.headphones),
                RecommendedItemModel("Speak", "3 minutes", Orange, R.drawable.keyboard_voice)
            )

            Column(
                modifier = Modifier.padding(horizontal = 24.dp)
            ) {
                recommendationList.forEach {
                    RecommendedItem(it)
                }
            }

        }

    }

}

data class RecommendedItemModel(
    val text: String, val time: String, val color: Color, val icon: Int
)


@Composable
fun GenreSection() {
    val genres = listOf("Brainstorm", "Books", "Videos", "Others")

    var selectedItem by remember {
        mutableStateOf("Brainstorm")
    }

    LazyRow(
        contentPadding = PaddingValues(horizontal = 12.dp)
    ) {
        items(genres) { genre ->
            Button(
                onClick = {
                    selectedItem = genre
                },
                modifier = Modifier.padding(horizontal = 12.dp),
                colors = if (selectedItem == genre) ButtonDefaults.buttonColors(
                    Color.Black
                )
                else ButtonDefaults.buttonColors(Color(0xfff7f7f7)),
                contentPadding = PaddingValues(vertical = 16.dp, horizontal = 24.dp)
            ) {
                Text(
                    text = genre,
                    color = if (selectedItem == genre) Color.White else Color.Black,
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendedItem(recommendedItemModel: RecommendedItemModel) {

    var isBookmarked by remember {
        mutableStateOf(false)
    }

    Card(
        colors = CardDefaults.cardColors(Color(0xfff7f7f7)),
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier.padding(bottom = 24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Box(
                    modifier = Modifier
                        .size(52.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(recommendedItemModel.color), contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = recommendedItemModel.icon),
                        contentDescription = "",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
                Column {
                    Text(
                        text = recommendedItemModel.text,
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        color = Color.Black
                    )
                    Text(
                        text = recommendedItemModel.time,
                        fontFamily = FontFamily(Font(R.font.poppins_light)),
                        color = Color.DarkGray,
                    )
                }
            }
            Box(
                modifier = Modifier.align(Alignment.CenterVertically),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    onClick = {
                        isBookmarked = !isBookmarked
                    },
                    colors = CardDefaults.cardColors(Color.Transparent),
                    modifier = Modifier.size(32.dp),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bookmark),
                        contentDescription = "icon",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(6.dp),
                        colorFilter = ColorFilter.tint(
                            if (isBookmarked) Color.Black else Color(0xffD6D6D6)
                        )
                    )
                }
            }

        }
    }
}

@Composable
fun CardPart() {
    Box(
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth()
    ) {
        Card(
            colors = CardDefaults.cardColors(Purple),
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(180.dp)
                .padding(horizontal = 24.dp)
                .clip(RoundedCornerShape(32.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(.6f)
                    .padding(start = 24.dp)
                    .padding(vertical = 24.dp), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Vocabulary",
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        fontSize = 18.sp,
                        color = Color.White,

                        )
                    Text(
                        text = "Listen 20 new words",
                        color = Color.White,
                        fontSize = 14.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = FontFamily(Font(R.font.poppins_light)),
                    )
                }

                Button(
                    onClick = { },
                    modifier = Modifier.height(52.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(Color.White),
                ) {
                    Text(
                        text = "Start",
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_light)),
                    )
                    Spacer(
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(Color.Black),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.PlayArrow,
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier.padding(4.dp)
                        )
                    }

                }

            }

        }

        Image(
            painter = painterResource(id = R.drawable.listening),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth(.4f)
                .align(Alignment.CenterEnd)
                .padding(end = 8.dp)
        )
    }
}

@Composable
fun ToolBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 24.dp
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconImage(id = R.drawable.menu)
            Row {
                IconImage(id = R.drawable.search)
                Spacer(modifier = Modifier.padding(12.dp))
                IconImage(id = R.drawable.bookmark)
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IconImage(id: Int) {
    Card(
        onClick = {},
        colors = CardDefaults.cardColors(Color.Transparent),
        modifier = Modifier.size(32.dp),
    ) {
        Image(
            painter = painterResource(id = id),
            contentDescription = "icon",
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp),
        )
    }

}
