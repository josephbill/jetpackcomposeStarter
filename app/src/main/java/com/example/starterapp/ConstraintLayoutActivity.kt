package com.example.starterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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

// This process creates a new activity i.e. an independent android screen
// On class creation extend CompenentActivity open class with an empty constructor
// override the fun create to load composables inside
// register the activity in our android manifest file
// confirm indication of the constraint layout activity
class ConstraintLayoutActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // inside this function we load our composables
        setContent {
            // call the material theme from google material design
            MaterialTheme {
                // ready composable frame from android design i.e our elements will be inside
                //modifier is an attribute for composables that allow us to list our styles for the
                // composable
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background ) {
//                    host other items buttons, images , text
                      InstagramPostCard()
                }
            }
        }
    }

    // clone instagram post
    // user profile pic + username : top
    // image post
    // buttons for like. comment and share
    // a caption
    // timestamp
    @Composable
    fun InstagramPostCard(){
        // card element
        Card(shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            modifier = Modifier.fillMaxWidth().padding(16.dp)) {
           // A layout composable that places its children in a vertical sequence.
            Column {
                      // header section
                // A layout composable that places its children in a horizontal sequence.
                Row (verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                         // image composable = profile pic
                        Image(painter = painterResource(id = R.drawable.image1) ,
                            contentDescription = "Profile Picture",
                            modifier = Modifier.size(40.dp).clip(CircleShape)
                                .border(1.dp, Color.Gray, CircleShape),
                            contentScale = ContentScale.Crop)
                    //spacer
                        Spacer(modifier = Modifier.width(8.dp))
                    // Text
                       Text(text="username" , fontWeight = FontWeight.Bold ,
                           modifier = Modifier.weight(1f))

                      }
                }

        }
    }

    // preview image
    @Preview(showBackground = true)
    @Composable
    fun InstagramPostCardPreview(){
        // call the material theme from google material design
        MaterialTheme {
            // ready composable frame from android design i.e our elements will be inside
            //modifier is an attribute for composables that allow us to list our styles for the
            // composable
            Surface(modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background ) {
//                    host other items buttons, images , text
                InstagramPostCard()
            }
        }
    }

}








