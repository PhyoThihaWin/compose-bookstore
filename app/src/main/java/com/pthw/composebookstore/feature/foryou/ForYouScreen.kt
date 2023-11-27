package com.pthw.composebookstore.feature.foryou

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarStyle
import com.pthw.composebookstore.R
import com.pthw.composebookstore.ui.theme.Colors
import com.pthw.composebookstore.ui.theme.ComposeBookStoreTheme
import com.pthw.composebookstore.ui.theme.Dimens

/**
 * Created by P.T.H.W on 13/11/2023.
 */

@Composable
fun ForYouRoute(
    onTopicClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ForYouViewModel = hiltViewModel(),
) {
    LazyColumn(
        modifier = Modifier
            .background(color = Colors.colorBackground)
    ) {

        item {
            Spacer(modifier = Modifier.height(Dimens.MARGIN_XMEDIUM))
            ForYouAppBar(modifier = modifier)
            Spacer(modifier = Modifier.height(Dimens.MARGIN_XMEDIUM))
            HomeSearchBar(modifier = modifier)
            Spacer(modifier = modifier.height(Dimens.MARGIN_XLARGE))
            ComingSoonList(modifier = modifier)
            Spacer(modifier = modifier.height(Dimens.MARGIN_XLARGE))
        }
        item {
            PopularMoviesList(modifier = modifier)
        }
        PopularMoviesItem(modifier = modifier)

    }
}

private fun LazyListScope.PopularMoviesItem(modifier: Modifier) {
    items(arrayListOf(1, 1, 1, 1, 1)) { item ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.MARGIN_20)
                .padding(bottom = Dimens.MARGIN_MEDIUM)
        ) {
            Box(
                modifier = modifier
                    .clip(MaterialTheme.shapes.medium)
                    .background(color = Colors.Blue)
            ) {
                AsyncImage(
                    model = "https://external-preview.redd.it/loki-s2-will-reportedly-premiere-on-disney-in-october-2023-v0-7INPD4Z2YqdwdwRNtY3uzVQosOIbNn7PgF9Cxt1brMs.jpg?auto=webp&s=f69a1c02588cfca3081d03c339c039d80801b715",
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = modifier.size(90.dp)
                )
            }
            Spacer(modifier = modifier.width(Dimens.MARGIN_XMEDIUM))
            Column {
                Text(
                    text = "Resident Evil - Racoon City",
                    modifier = modifier,
                    color = Colors.colorWhite,
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(modifier = modifier.height(Dimens.MARGIN_SMALL))
                Row {
                    Text(
                        text = "4.5",
                        color = Color.Gray

                    )
                    Spacer(modifier = Modifier.width(Dimens.MARGIN_MEDIUM))
                    RatingBar(
                        value = 2f,
                        style = RatingBarStyle.Fill(),
                        size = Dimens.MARGIN_20,
                        spaceBetween = Dimens.MARGIN_XSMALL,
                        onValueChange = {
//                            rating = it
                        },
                        onRatingChanged = {
                            Log.d("TAG", "onRatingChanged: $it")
                        }
                    )
                }
                Text(
                    text = "November 2021",
                    color = Color.Gray

                )
            }
        }
    }

}

// popular movie list
@Composable
private fun PopularMoviesList(
    modifier: Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = "Popular Movies",
                modifier = modifier.padding(horizontal = Dimens.MARGIN_20),
                color = Colors.colorWhite,
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = "See all",
                modifier = modifier.padding(horizontal = Dimens.MARGIN_20),
                color = Color.Gray
            )
        }
        Spacer(modifier = modifier.height(Dimens.MARGIN_XMEDIUM))
    }
}

// coming soon list
@Composable
fun ComingSoonList(
    modifier: Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "Coming Soon",
            modifier = modifier.padding(horizontal = Dimens.MARGIN_20),
            color = Colors.colorWhite,
            style = MaterialTheme.typography.titleLarge,
        )
        Spacer(modifier = modifier.height(Dimens.MARGIN_XMEDIUM))
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = Dimens.MARGIN_20),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            reverseLayout = false,
            userScrollEnabled = true,
            content = fun LazyListScope.() {
                items(arrayListOf(1, 1, 1)) { item ->
                    Column(
                        modifier = modifier
                            .fillParentMaxWidth(0.9f)
                            .fillMaxHeight()
                    ) {
                        Box(
                            modifier = modifier
                                .clip(MaterialTheme.shapes.medium)
                                .background(color = Colors.Blue)
                        ) {
                            AsyncImage(
                                model = "https://d2d7ho1ae66ldi.cloudfront.net/ArquivoNoticias/088974ed-2198-11ee-aa6e-9587410378a2/345890079_649442590532021_8425814995231854364_n.jpg",
                                contentScale = ContentScale.Crop,
                                contentDescription = null,
                                modifier = modifier.aspectRatio((4 / 2.5).toFloat())
                            )
                        }
                        Spacer(modifier = modifier.height(Dimens.MARGIN_XMEDIUM))
                        Text(
                            text = "Resident Evil - Racoon City",
                            modifier = modifier,
                            color = Colors.colorWhite,
                            style = MaterialTheme.typography.titleLarge,
                        )
                        Spacer(modifier = modifier.height(Dimens.MARGIN_SMALL))
                        Text(
                            text = "November 2021",
                            color = Color.Gray

                        )
                    }
                }
            }
        )
    }
}

@Composable
fun HomeSearchBar(
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.MARGIN_20)
            .clip(MaterialTheme.shapes.small)
            .background(color = Color.LightGray)
            .padding(
                horizontal = Dimens.MARGIN_LARGE,
                vertical = Dimens.MARGIN_XMEDIUM
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_search_24),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color.Gray)
        )
        Spacer(modifier = modifier.width(Dimens.MARGIN_MEDIUM))
        Text(
            text = "Search your favorite movie",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
    }
}

@Composable
fun ForYouAppBar(
    modifier: Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.MARGIN_20)
    ) {
        Column(
            modifier = modifier
        ) {
            Text(
                text = "Welcome back, ",
                color = Color.Gray

            )
            Text(
                text = "Victor Timely,",
                modifier = modifier,
                color = Colors.colorWhite,
                style = MaterialTheme.typography.titleLarge,
            )
        }
        Box(
            modifier = modifier
                .size(80.dp)
                .padding(Dimens.MARGIN_MEDIUM)
                .clip(MaterialTheme.shapes.medium)
                .background(color = Color.LightGray)
                .padding(Dimens.MARGIN_MEDIUM)
        ) {
            AsyncImage(
                model = "https://static.vecteezy.com/system/resources/previews/020/389/525/original/hand-drawing-cartoon-girl-cute-girl-drawing-for-profile-picture-vector.jpg",
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)                       // clip to the circle shape
                    .border(2.dp, Color.Gray, CircleShape)
            )
        }
    }
}

@Preview
@Composable
fun ForYouScreenPreview(showBackground: Boolean = true, backgroundColor: Long = 0xFFFFFF) {
    ComposeBookStoreTheme {
        ForYouRoute(onTopicClick = {})
    }
}
