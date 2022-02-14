package com.example.compose1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.compose1.ui.theme.Compose1Theme
import com.example.compose1.ui.theme.ProfilePage
import com.example.compose1.ui.theme.ProfilePage2
import com.example.compose1.ui.theme.ProfilePage3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose1Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ProfilePage3()
                }
            }
        }
    }
}

//Creating own Compose
//@Composable
//fun myApp(){
//    Text("Aditya", fontSize = 20.sp, color = Color.Red)
//}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
}