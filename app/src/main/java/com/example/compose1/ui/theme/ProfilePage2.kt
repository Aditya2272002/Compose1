package com.example.compose1.ui.theme


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.solver.state.helpers.GuidelineReference
import com.example.compose1.R

@Composable
fun ProfilePage2(){
    Card(elevation = 10.dp, modifier = Modifier
        .fillMaxSize()
        .padding(top = 100.dp, bottom = 100.dp, start = 16.dp, end = 16.dp)
        .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(30.dp))) {

        ConstraintLayout{
            // Creating references
            val (image, nameText, countryText, rowStats, buttonFollow, buttonMessage) = createRefs()

            val guideLine = createGuidelineFromTop(0.1f)

            Image(painter = painterResource(id = R.drawable.husky),
                contentDescription = "husky",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = Color.Red,
                        shape = CircleShape
                    ).constrainAs(image){
                        // constrainAs(id)  -> it takes the id of item
                        //How this item is linked ?
                            top.linkTo(guideLine)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                    },
                contentScale = ContentScale.Crop
            )

            Text("Siberian Husky", fontSize = 15.sp, modifier = Modifier.constrainAs(nameText){
                top.linkTo(image.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

            Text("Germany", fontSize = 15.sp, modifier = Modifier.constrainAs(countryText){
                top.linkTo(nameText.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .constrainAs(rowStats){
                        top.linkTo(countryText.bottom)
                    }){
                ProfileStats2(count = "150", title = "Followers")
                ProfileStats2(count = "100", title = "Following")
                ProfileStats2(count = "30", title = "Posts")
            }


            Button(onClick = {  }, modifier = Modifier.constrainAs(buttonFollow){
                top.linkTo(rowStats.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(buttonMessage.start)
                width = Dimension.wrapContent
            }) {
                Text(text = "Follow User")
            }
            Button(onClick = {  }, modifier = Modifier.constrainAs(buttonMessage){
                top.linkTo(rowStats.bottom, margin = 16.dp)
                start.linkTo(buttonFollow.end)
                end.linkTo(parent.end)
                width = Dimension.wrapContent
            }) {
                Text(text = "Direct Message")
            }
        }
    }
}

@Composable
fun ProfileStats2(count:String,title:String){
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = count, fontWeight = FontWeight.Bold)
        Text(text = title)
    }
}


@Preview(showBackground = true)
@Composable
fun ProfilePagePreview2(){
    ProfilePage2()
}