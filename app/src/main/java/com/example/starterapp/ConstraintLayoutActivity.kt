package com.example.starterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
        // variable to maintain the like and unlike states
        val isLiked  = remember { mutableStateOf(false) }
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
//                   username and image
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
//                // instagram image
                  // BOX composable : BOX LIKE CONTAINER
                Box(modifier = Modifier.fillMaxWidth().height(300.dp)) {
                        Image(painter= painterResource(id = R.drawable.image2),
                              contentDescription = "Post Image",
                              modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                }
                // Action Buttons
                    Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
//                     // Iconbutton composable: like button
                        IconButton(onClick = { isLiked.value = !isLiked.value}) {
                            Icon(
                                if(isLiked.value) Icons.Filled.Favorite
                                else Icons.Outlined.FavoriteBorder,
                                contentDescription = "Like Button",
                                tint = if(isLiked.value) Color.Red
                                else MaterialTheme.colorScheme.onSurface
                            )
                        }
                        // comment
                        IconButton(onClick = {}) {
                            Icon(Icons.Outlined.CheckCircle, contentDescription = "Comment")
                        }
                        // share
                        IconButton(onClick = {}) {
                            Icon(Icons.Outlined.Share, contentDescription = "Share")
                        }
                        //spacer
                        Spacer(modifier = Modifier.weight(1f))
                        // save
                        IconButton(onClick = {}) {
                            Icon(Icons.Outlined.Star, contentDescription = "Save")
                        }

                    }
                    // text container for the likes count
                    Text(text= "${if (isLiked.value) 1 else 0} likes",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 16.dp, bottom = 4.dp))

                    // caption
                    Row (modifier = Modifier.padding(horizontal= 16.dp, vertical = 4.dp)) {
                        Text(text="username", fontWeight = FontWeight.Bold)
                        Text(text="This is a sample instagram caption!.")

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








