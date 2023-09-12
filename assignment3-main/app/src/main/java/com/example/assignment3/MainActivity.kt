package com.example.assignment3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Background()

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Header()
                LoginScreen()
                Footer()
            }
        }
    }
}

@Composable
fun Background(){
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.img1),
            contentDescription = "Login",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun Header(){
    Text(text = "Login",
        style = MaterialTheme.typography.headlineLarge.copy(color = Color(0xffD7F1F3))
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(){
    var username by remember { mutableStateOf("") }
    OutlinedTextField(value = username ,
        onValueChange = { username =  it},
        label = { Text(text = "UserName", style = MaterialTheme.typography.bodyLarge.copy(color = Color.White), fontWeight = FontWeight.Bold)},
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Go),
        textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color(0xFFECF2F3)),
    )

    Spacer(modifier = Modifier.height(8.dp))

    var password by remember {
        mutableStateOf("")
    }
    OutlinedTextField(value = password,
        onValueChange = { password = it},
        label = { Text(text = "Password",style = MaterialTheme.typography.bodyLarge.copy(color = Color(0xFFECF2F3),fontWeight = FontWeight.Bold))},
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Go),
        textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color(0xFFECF2F3))
    )

    Spacer(modifier = Modifier.height(16.dp))

}

@Composable
fun Footer(){
    val context = LocalContext.current
    Button(
        onClick = {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.prada.com/ww/en.html")))},
        modifier = Modifier.padding(all = 10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
    )
    {
        Row {

            Image(painter = painterResource(id = R.drawable.prada), contentDescription = "Prada", modifier = Modifier
                .width(30.dp)
                .height(30.dp))
        }
        Spacer(modifier = Modifier.width(6.dp))
        Text(text = "Sign In to Prada", style = MaterialTheme.typography.bodyMedium.copy(color = Color.Yellow))
    }

    Button(
        onClick = {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.example.com")))},
        modifier = Modifier.padding(all = 10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
    )
    {
        Row {

            Image(painter = painterResource(id = R.drawable.example), contentDescription = "Example", modifier = Modifier
                .width(30.dp)
                .height(30.dp))
        }
        Spacer(modifier = Modifier.width(6.dp))
        Text(text = "Sign In to example", style = MaterialTheme.typography.bodyMedium.copy(color = Color.Yellow))
    }

    Button(
        onClick = {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com")))},
        modifier = Modifier.padding(all = 10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
    )
    {
        Row {

            Image(painter = painterResource(id = R.drawable.google), contentDescription = "Google", modifier = Modifier
                .width(30.dp)
                .height(30.dp))
        }
        Spacer(modifier = Modifier.width(6.dp))
        Text(text = "Sign In to Google", style = MaterialTheme.typography.bodyMedium.copy(color = Color.Yellow))
    }
    Button(
        onClick = {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com")))},
        modifier = Modifier.padding(all = 10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
    )
    {
        Row {

            Image(painter = painterResource(id = R.drawable.facebook), contentDescription = "Facebook", modifier = Modifier
                .width(30.dp)
                .height(30.dp))
        }
        Spacer(modifier = Modifier.width(6.dp))
        Text(text = "Sign In to Facebook", style = MaterialTheme.typography.bodyMedium.copy(color = Color.Yellow))
    }
}

@Preview
@Composable
fun Preview(){

    Background()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Header()
        LoginScreen()
        Footer()
    }

}