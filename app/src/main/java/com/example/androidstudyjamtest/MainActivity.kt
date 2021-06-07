package com.example.androidstudyjamtest

import android.R
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidstudyjamtest.ui.theme.AndroidStudyJamTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidStudyJamTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Greeting("Android")
                    }
                }
            }
        }
    }
}

const val SEARCH_MSG = "search_msg"

@Composable
fun Greeting(name: String) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val textData = remember(SEARCH_MSG) { mutableStateOf("") }
        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(value = textData.value, onValueChange = {
                d("onValueChange $it")
                textData.value = it
            })

            Icon(
                painter = painterResource(id = R.drawable.ic_menu_close_clear_cancel),
                contentDescription = "",
                modifier = Modifier.clickable {
                    textData.value = ""
                }
            )
        }

        if (!TextUtils.isEmpty(textData.value)) {
            Text(text = "search msg is: ${textData.value}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidStudyJamTestTheme {
        Greeting("Android")
    }
}

fun d(msg: String) {
    Log.d("GFZY", msg)
}