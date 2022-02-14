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
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.compose1.R

@Composable
fun ProfilePage3(){

    Card(elevation = 6.dp, modifier = Modifier
        .fillMaxSize()
        .padding(top = 50.dp, bottom = 100.dp, start = 16.dp, end = 16.dp)
        .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(30.dp))) {

        BoxWithConstraints {
            val constraints = if (minWidth < 600.dp) {
                portraitConstraints(margin = 16.dp)
            } else {
                landscapeConstraints(margin = 16.dp)
            }

            ConstraintLayout(constraints) {

                Image(
                    painter = painterResource(id = R.drawable.husky),
                    contentDescription = "husky",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .border(
                            width = 2.dp,
                            color = Color.Red,
                            shape = CircleShape
                        ).layoutId("image"),
                    contentScale = ContentScale.Crop
                )

                Text(
                    "Siberian Husky", fontSize = 15.sp,
                    modifier = Modifier.layoutId("nameText")
                )

                Text("Germany", fontSize = 15.sp,
                    modifier = Modifier.layoutId("countryText"))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .layoutId("rowStats")
                ) {
                    ProfileStats3(count = "150", title = "Followers")
                    ProfileStats3(count = "100", title = "Following")
                    ProfileStats3(count = "30", title = "Posts")
                }


                Button(onClick = { }
                    , modifier = Modifier.layoutId("buttonFollow")) {
                    Text(text = "Follow User")
                }
                Button(onClick = { },
                    modifier = Modifier.layoutId("buttonMessage")) {
                    Text(text = "Direct Message",
                        )
                }
            }
        }
    }
}


private fun portraitConstraints(margin:Dp):ConstraintSet{
    return ConstraintSet {
        val image = createRefFor("image")
        val nameText = createRefFor("nameText")
        val countryText = createRefFor("countryText")
        val rowStats = createRefFor("rowStats")
        val buttonFollow = createRefFor("buttonFollow")
        val buttonMessage = createRefFor("buttonMessage")
        val guideLine = createGuidelineFromTop(0.3f)

        constrain(image){
            top.linkTo(guideLine)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(nameText){
            top.linkTo(image.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(countryText){
            top.linkTo(nameText.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(rowStats){
            top.linkTo(countryText.bottom)
        }

        constrain(buttonFollow){
            top.linkTo(rowStats.bottom, margin = margin)
            start.linkTo(parent.start)
            end.linkTo(buttonMessage.start)
            width = Dimension.wrapContent
        }

        constrain(buttonMessage){
            top.linkTo(rowStats.bottom, margin = 16.dp)
            start.linkTo(buttonFollow.end)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
        }
    }
}

private fun landscapeConstraints(margin: Dp):ConstraintSet{
    return ConstraintSet{
        val image = createRefFor("image")
        val nameText = createRefFor("nameText")
        val countryText = createRefFor("countryText")
        val rowStats = createRefFor("rowStats")
        val buttonFollow = createRefFor("buttonFollow")
        val buttonMessage = createRefFor("buttonMessage")
        val guideLine = createGuidelineFromTop(0.3f)

        constrain(image){
            top.linkTo(parent.top,margin = margin)
            start.linkTo(parent.start,margin = margin)
        }

        constrain(nameText){
            top.linkTo(image.bottom)
            start.linkTo(image.start)
        }

        constrain(countryText){
            top.linkTo(nameText.bottom)
            start.linkTo(nameText.start)
            end.linkTo(nameText.end)
        }

        constrain(rowStats){
            top.linkTo(image.top)
            start.linkTo(image.end,margin = margin)
            end.linkTo(parent.end)
        }

        constrain(buttonFollow){
            top.linkTo(rowStats.bottom,margin = 16.dp)
            start.linkTo(rowStats.start)
            end.linkTo(buttonMessage.start)
            bottom.linkTo(countryText.bottom)
            width = Dimension.wrapContent
        }

        constrain(buttonMessage){
            top.linkTo(rowStats.bottom,margin = 16.dp)
            start.linkTo(buttonFollow.end)
            end.linkTo(parent.end)
            bottom.linkTo(countryText.bottom)
            width = Dimension.wrapContent
        }

    }
}


@Composable
fun ProfileStats3(count:String,title:String){
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = count, fontWeight = FontWeight.Bold)
        Text(text = title)
    }
}


@Preview(showBackground = true)
@Composable
fun ProfilePagePreview3(){
    ProfilePage3()
}