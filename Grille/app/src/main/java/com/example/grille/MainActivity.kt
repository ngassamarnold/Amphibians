package com.example.grille

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.grille.data.DataSource
import com.example.grille.model.Topic
import com.example.grille.ui.components.CardGrid
import com.example.grille.ui.components.TopicCard
import com.example.grille.ui.theme.GrilleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GrilleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CardGridList(DataSource.topics, Modifier.padding(dimensionResource(R.dimen.padding_small)))
                }
            }
        }
    }
}

@Composable
fun CardGridList(topicList: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        modifier = modifier
    ) {
        items(topicList) {
            TopicCard(topic = it)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CardGridPreview() {
    GrilleTheme {
        CardGridList(DataSource.topics, Modifier.padding(dimensionResource(R.dimen.padding_small)))
    }
}