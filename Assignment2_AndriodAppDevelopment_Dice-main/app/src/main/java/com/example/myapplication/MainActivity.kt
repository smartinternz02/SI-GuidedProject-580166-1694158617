package com.example.myapplication
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

import java.util.*;

class MainActivity : ComponentActivity() {

    private lateinit var resultTextView: TextView
    private lateinit var rollButton: Button
    private lateinit var image: Image
    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView =findViewById(R.id.resultTextView)
        rollButton = findViewById(R.id.rollButton)
        imageView=findViewById(R.id.imageView)

        rollButton.setOnClickListener {
            rollDice()
        }
    }
    private fun rollDice(){
        val random=Random()
        val randomNumber=random.nextInt(6)+1
        val resultText = "you rolled a $randomNumber"
        resultTextView.text=resultText
        val imageResource = when (randomNumber) {
            1 -> R.drawable.one
            2 -> R.drawable.two
            3 -> R.drawable.three
            4 -> R.drawable.four
            5 -> R.drawable.five
            6 -> R.drawable.six
            else -> R.drawable.flowr
        }

        imageView.setImageResource(imageResource)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}