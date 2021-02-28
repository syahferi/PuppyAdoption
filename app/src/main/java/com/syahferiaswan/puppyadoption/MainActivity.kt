package com.syahferiaswan.puppyadoption

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.syahferiaswan.puppyadoption.model.PuppyData
import com.syahferiaswan.puppyadoption.ui.PuppyTheme
import com.syahferiaswan.puppyadoption.viewModel.PuppyViewModel

class MainActivity : AppCompatActivity() {

    private val puppyViewModel by viewModels<PuppyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuppyTheme {
                Surface {
                    BodyContent(puppyViewModel)
                }
            }
        }
    }
}

@Composable
fun BodyContent(viewModel: PuppyViewModel) {
    val puppyData: List<PuppyData> by viewModel.puppyLiveData.observeAsState(listOf())
    viewModel.fetchData()
    PuppyContent(puppyData = puppyData)
}

@Composable
fun PuppyContent(modifier: Modifier = Modifier, puppyData: List<PuppyData>) {
    Scaffold(topBar = { TopAppBar(title = { Text("Home Page") }) }) {
        LazyColumn(
            contentPadding = PaddingValues(top = 8.dp)
        ) {
            items(items = puppyData) {
                PuppyItem(modifier, it)
            }
        }
    }
}

@Composable
fun PuppyItem(modifier: Modifier, puppyItem: PuppyData) {
    val context = LocalContext.current
    val image = painterResource(puppyItem.image)
    Card(
        modifier
            .padding(8.dp)
            .clickable {
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra("puppy", puppyItem)
                }
                startActivity(context, intent, null)
            },
        elevation = 8.dp,
    ) {
        Column(
            modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = image,
                contentDescription = "image ${puppyItem.name}",
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxWidth()
            )
            Column(modifier.padding(8.dp)) {
                Text(
                    puppyItem.name ?: "",
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
                )
                Text(
                    "Type: ${puppyItem.type}",
                    style = TextStyle(fontWeight = FontWeight.Light, fontSize = 15.sp),
                )
            }
        }
    }
}


@Preview
@Composable
fun PreviewUi() {
}