package com.ks.dynamicrendering

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ks.dynamicrendering.ui.theme.DynamicrenderingTheme
import org.json.JSONObject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val json = """
            {
                "title": "Dynamic UI",
                "subtitle": "Using Jetpack Compose",
                "showButton": true,
                "buttonText": "Click Me"
            }
        """
        val data = parseJson(json)
        setContent {
            DynamicrenderingTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(text = data.title, fontSize = 32.sp)
                    Text(text = data.subtitle, fontSize = 16.sp, color = Color.Blue)
                    if (data.showButton){
                        Button(onClick = { /*TODO*/ },
                        modifier=Modifier.padding(top = 16.dp)
                        ) {
                            Text(text = data.buttonText)

                        }
                    }
                }
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
            }
        }
    }
}
data class UiData(
    val title:String,
    val subtitle:String ,
    val showButton:Boolean,
    val buttonText:String
)
private fun parseJson(json:String):UiData{
val jsonObject = JSONObject(json)
    return UiData(
        title = jsonObject.getString("title"),
        subtitle = jsonObject.getString("subtitle"),
        showButton = jsonObject.getBoolean("showButton"),
        buttonText = jsonObject.getString("buttonText")
    )
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    DynamicrenderingTheme {
//        Greeting("Android")
//    }
//}