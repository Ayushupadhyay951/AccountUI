package com.example.accountui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.accountui.ui.theme.AccountUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AccountUITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth().fillMaxSize()) {
        val context:Context= LocalContext.current
        val email  = remember {
            mutableStateOf("")
        }
 val password  = remember {
            mutableStateOf("")
        }

        Text(
            text = "Welcome to the Rajan's Software",
            fontSize = 20.sp,
            fontWeight = FontWeight.Black,
            modifier = Modifier
                .background(
                    Color.Green
                )
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.loginui),
            contentDescription = "null",
            modifier = Modifier
                .height(250.dp).fillMaxWidth()

        )
        OutlinedTextField(
            value = email.value, onValueChange = {email.value=it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp), placeholder = {
                    Text(text = "E-mail")
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = password.value,
            onValueChange = {password.value=it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp), placeholder = {
                    Text(text = "Password")
            }
        )
OutlinedButton(onClick = {
    Toast.makeText(context, "You have logged in Succesfully", Toast.LENGTH_SHORT).show()
}, modifier = Modifier
    .fillMaxWidth()
    .padding(20.dp)) {
    Text(text = "Login")
}
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}