package com.kivous.jetpackcomposeui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kivous.jetpackcomposeui.R
import com.kivous.jetpackcomposeui.ui.theme.Purple
import com.kivous.jetpackcomposeui.ui.theme.PurpleLight

@Composable
fun StartScreen(onClick: () -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(), containerColor = PurpleLight
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.padding(top = 40.dp))

            Image(
                painter = painterResource(id = R.drawable.brain_bob_logo),
                contentDescription = "BrainBob Logo",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.padding(top = 40.dp))

            Image(
                painter = painterResource(id = R.drawable.study_img),
                contentDescription = "Study Image",
                modifier = Modifier.fillMaxWidth()
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(PurpleLight)
                    .padding(horizontal = 24.dp)
                    .padding(top = 24.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Be ready to learn\nEnglish easily",
                    fontSize = 28.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    lineHeight = 36.sp
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(PurpleLight)
                    .padding(horizontal = 16.dp)
                    .padding(top = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Listen to stories, watch videos and improve\nyour language with BrainBob",
                    fontFamily = FontFamily(Font(R.font.poppins_light)),
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center,
                    lineHeight = 18.sp
                )
            }

            Box(
                modifier = Modifier
                    .background(PurpleLight)
                    .fillMaxWidth()
                    .padding(vertical = 48.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = { onClick() },
                    colors = ButtonDefaults.buttonColors(Purple),
                    contentPadding = PaddingValues(vertical = 16.dp, horizontal = 40.dp)
                ) {
                    Text(
                        text = "Let's starts",
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.poppins_bold))
                    )
                }
            }
        }
    }

}
