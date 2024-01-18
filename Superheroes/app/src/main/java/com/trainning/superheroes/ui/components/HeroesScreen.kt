package com.trainning.superheroes.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.trainning.superheroes.R
import com.trainning.superheroes.model.Hero

@Composable
fun HeroesComponent(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .height(104.dp)
                .padding(dimensionResource(R.dimen.padding_medium))
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(end = dimensionResource(R.dimen.padding_medium))
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Image(
                painter = painterResource(hero.imageRes),
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.image_size))
                    .clip(MaterialTheme.shapes.small),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
        }
    }
}