package com.example.loginpage
import android.os.Bundle
import androidx.compose.ui.unit.dp
import android.support.v4.os.IResultReceiver.Default
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.loginpage.ui.theme.LoginPageTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.ImeAction
import com.example.loginpage.ui.theme.LoginPageTheme
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlin.jvm.internal.Intrinsics.Kotlin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppContent()

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppContent(){
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var username by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        Text(text = "Username",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        TextField(value = username, onValueChange = {newUsername -> username = newUsername},
            leadingIcon = {
                Image(painter = painterResource(id = android.R.drawable.star_big_on), contentDescription ="Star Icon" )
            },
            label = {
                Text(text = "Your Username",
                fontWeight = FontWeight.Bold)
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Password",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp)

        TextField(value = password, onValueChange ={newPassword-> password = newPassword},
            leadingIcon = {
                Image(painter = painterResource(id = android.R.drawable.star_big_on), contentDescription ="Star Icon" )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
            placeholder = {
                Text(text="Enter Password",
                    fontWeight = FontWeight.Bold)
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Submit")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    LoginPageTheme {
        
    }
}