package com.example.starterapp

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class AuthenticationScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // surface represents the frame of the screen
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                {
                    // make a call to the navcontroller function
                    // for navigation purpose we set up a navcontroller
                    // to redirect screens based off a click event
                    AppNavigation()
                }
            }
        }
    }
    @Composable
    fun AppNavigation(){
         // The NavController is part of the navigation concept of
        // jetpack compose. It manages app navigation = it helps in
        // movement between different composable and handles the back
        // stack  A <-> B <-> C
        // NavController "
        // 1. You tell it where to go ( navigate() )
        // 2. It remembers where you've been
        // 3. And it lets you go back ( popBackStack() )
        // Initialize the navcontroller reference
        val navController = rememberNavController()
        // set up a  to host anavhostll app's routes (paths)  /home . /login,
        // the routes are identified using names that map to composables
        NavHost(navController = navController, startDestination = "login") {
            // inside this we then add our composables with the path names
            composable("login") {  LoginScreen(navController)  }
            composable("signup") {  SignUpScreen(navController)  }
            // add more routes to composables for this screen here
        }
     }

    // composables
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LoginScreen(navController: NavController){
        val username = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        val passwordVisible = remember { mutableStateOf(false) }

        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center ) {
             Card(modifier = Modifier.fillMaxWidth().padding(24.dp),
                 shape = RoundedCornerShape(16.dp),
                 elevation = CardDefaults.cardElevation(
                     defaultElevation = 8.dp )
             ) {
                   Column(modifier= Modifier.padding(24.dp),
                         horizontalAlignment = Alignment.CenterHorizontally)
                   {
                        // logo
                       Image(painter = painterResource(R.drawable.image1),
                            contentDescription = "App logo",
                           modifier = Modifier.size(120.dp),
                           contentScale = ContentScale.Fit
                            )
                       // space
                       Spacer(modifier = Modifier.height(32.dp))
                       // username text field
                       OutlinedTextField(
                           value = username.value,
                           onValueChange = {username.value = it},
                           label = {Text("Username or Email")},
                           modifier = Modifier.fillMaxWidth(),
                           singleLine = true,
                           colors = TextFieldDefaults.colors(
                               focusedTextColor = MaterialTheme
                                   .colorScheme.onSurface,
                               unfocusedTextColor = MaterialTheme
                                   .colorScheme.onSurfaceVariant,
                               focusedContainerColor = Color.Transparent,
                               unfocusedContainerColor = Color.Gray
                           )
                       )
                       // spacer
                       Spacer(modifier = Modifier.height(16.dp))
                       // password
                       OutlinedTextField(
                           value = password.value,
                           onValueChange = {password.value = it},
                           label = {Text("Password")},
                           modifier = Modifier.fillMaxWidth(),
                           singleLine = true,
                           colors = TextFieldDefaults.colors(
                               focusedTextColor = MaterialTheme
                                   .colorScheme.onSurface,
                               unfocusedTextColor = MaterialTheme
                                   .colorScheme.onSurfaceVariant,
                               focusedContainerColor = Color.Transparent,
                               unfocusedContainerColor = Color.Gray
                           ),
                           visualTransformation = if(passwordVisible
                               .value) VisualTransformation.None else
                              PasswordVisualTransformation(),
                           trailingIcon = {
                               IconButton(onClick = {
                                   passwordVisible.value =
                                       !passwordVisible.value
                               }) {
                                   Icon(
                                       imageVector = if(
                                           passwordVisible.value
                                       ) Icons.Filled.ThumbUp else
                                       Icons.Filled.AccountBox,
                                       contentDescription = ""
                                   )
                               }
                           }

                       )
                       Spacer(modifier = Modifier.height(8.dp))
                       // Clickable Text
                       Text(
                           text = "Forgot Password ?",
                           style = MaterialTheme.typography.bodySmall.
                           copy(color = MaterialTheme.colorScheme.primary),
                           modifier = Modifier.align(Alignment.End).
                           clickable(onClick = {
//                               handle reset password functionality here
                           })
                       )
                       Spacer(modifier = Modifier.height(24.dp))
                       // login button
                       Button(
                           onClick = { /* handle login */ },
                          modifier = Modifier.fillMaxWidth()
                              .height(48.dp),
                          shape = RoundedCornerShape(8.dp),
                          colors = ButtonDefaults.buttonColors(
                              containerColor = MaterialTheme.colorScheme.
                              primary ,
                              contentColor = Color.White
                          )
                       ) {
                           Text(text = "Log In", fontSize = 16.sp)
                       }
                       // Linking element to launch the signup composable
                       Text(
                           text = "Don't have an account ? Login here",
                           style = MaterialTheme.typography.bodyMedium,
                           modifier = Modifier.clickable {
                               navController.navigate("signup")
                           }
                       )

                   }
             }
        }
    }
    @Composable
    fun SignUpScreen(navController: NavController){

    }
    @Composable
    fun ForgotPasswordScreen(navController: NavController){

    }
    // setting up preview function for my login screen composable
    @Preview(showBackground = true)
    @Composable
    fun LoginScreenPreview(){
        MaterialTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                 LoginScreen(rememberNavController())
            }
        }
    }
}












