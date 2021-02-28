package com.syahferiaswan.puppyadoption

import android.app.Activity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.syahferiaswan.puppyadoption.model.PuppyData
import com.syahferiaswan.puppyadoption.ui.PuppyTheme

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val puppy = intent.getParcelableExtra<PuppyData>("puppy")
        puppy?.let {
            setContent {
                PuppyTheme {
                    Surface {
                        PuppyDetail(puppy, context = this)
                    }
                }
            }
        }
    }
}

@Composable
fun PuppyDetail(puppy: PuppyData, modifier: Modifier = Modifier, context: Activity) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(puppy.name ?: "") }, navigationIcon = {
                IconButton(onClick = { context.onBackPressed() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "back button"
                    )
                }

            })
        },
    ) {
        Column(modifier.padding(16.dp)) {
            Image(
                painter = painterResource(puppy.image),
                contentDescription = "image $puppy.name",
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxWidth()
            )
            Spacer(modifier.height(6.dp))
            Text("Hello my name is ${puppy.name}")
            Text("age: ${puppy.age} years old")
            Text("type: ${puppy.type}")

            Spacer(modifier.height(12.dp))

            Text( "Additional Info",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
            )
            Text(
                puppy.desc ?: "",
                style = TextStyle(fontWeight = FontWeight.Light, fontSize = 15.sp)
            )
            Spacer(modifier.height(6.dp))
        }
    }
}

@Preview
@Composable
fun PreviewUiDetail() {
}