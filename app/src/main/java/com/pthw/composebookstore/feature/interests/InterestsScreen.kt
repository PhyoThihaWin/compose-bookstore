@file:OptIn(ExperimentalMaterial3Api::class)

package com.pthw.composebookstore.feature.interests

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarStyle
import com.pthw.composebookstore.R
import com.pthw.composebookstore.feature.foryou.ListTitleSeeMore
import com.pthw.composebookstore.feature.foryou.ListTitleText
import com.pthw.composebookstore.ui.theme.Colors
import com.pthw.composebookstore.ui.theme.ComposeBookStoreTheme
import com.pthw.composebookstore.ui.theme.Dimens

/**
 * Created by P.T.H.W on 14/11/2023.
 */

@Composable
fun InterestsRoute(
    onTopicClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: InterestsViewModel = hiltViewModel(),
) {

    var tabIndex by remember {
        mutableStateOf(0)
    }
    val tabLabels = listOf(
        "Now Showing",
        "Upcoming",
    )

    Column {
        InterestAppBar(
            modifier = modifier.fillMaxWidth()
        )
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(color = Colors.colorBackground)
        ) {

            item {
                Spacer(modifier = modifier.height(Dimens.MARGIN_MEDIUM_2))
                MovieTypeTabRow(tabLabels = tabLabels, tabIndex = tabIndex, onTabSelected = {
                    tabIndex = it
                })

                Spacer(modifier = modifier.height(Dimens.MARGIN_LARGE))

                TopMoviesSection(modifier = modifier)
                Spacer(modifier = modifier.height(Dimens.MARGIN_LARGE))
                RecommendedMoviesSection(modifier = modifier)
                Spacer(modifier = modifier.height(Dimens.MARGIN_LARGE))
            }

        }
    }


}

@Composable
fun TopMoviesSection(
    modifier: Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        ListTitleText(modifier = modifier, text = "Top Movies")
        ListTitleSeeMore(modifier)
    }

    Spacer(modifier = modifier.height(Dimens.MARGIN_12))
    LazyRow(
        contentPadding = PaddingValues(horizontal = Dimens.MARGIN_20),
        horizontalArrangement = Arrangement.spacedBy(Dimens.MARGIN_LARGE),
    ) {
        items(arrayListOf(1, 1, 1, 1, 1)) {
            Column(
                modifier = modifier
                    .width(200.dp)
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
                        modifier = modifier
                            .height(250.dp)
                    )
                }
                Spacer(modifier = modifier.height(Dimens.MARGIN_10))
                Column {
                    Text(
                        text = "Resident Evil - Racoon City",
                        modifier = modifier,
                        color = Colors.colorWhite,
                        style = MaterialTheme.typography.titleMedium,
                    )
                    Spacer(modifier = modifier.height(Dimens.MARGIN_SMALL))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RatingBar(
                            value = 2f,
                            style = RatingBarStyle.Fill(),
                            size = Dimens.MARGIN_MEDIUM_2,
                            spaceBetween = Dimens.MARGIN_XSMALL,
                            onValueChange = {
//                            rating = it
                            },
                            onRatingChanged = {
                                Log.d("TAG", "onRatingChanged: $it")
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun RecommendedMoviesSection(
    modifier: Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        ListTitleText(modifier = modifier, text = "Recommended")
        ListTitleSeeMore(modifier)
    }

    Spacer(modifier = modifier.height(Dimens.MARGIN_12))
    LazyRow(
        contentPadding = PaddingValues(horizontal = Dimens.MARGIN_20),
        horizontalArrangement = Arrangement.spacedBy(Dimens.MARGIN_MEDIUM_2),
    ) {
        items(arrayListOf(1, 1, 1, 1, 1)) {
            Column(
                modifier = modifier
                    .width(160.dp)
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
                        modifier = modifier
                            .height(180.dp)
                    )
                }
                Spacer(modifier = modifier.height(Dimens.MARGIN_10))
                Column {
                    Text(
                        text = "Resident Evil - Racoon City",
                        modifier = modifier,
                        color = Colors.colorWhite,
                        style = MaterialTheme.typography.titleMedium,
                    )
                    Spacer(modifier = modifier.height(Dimens.MARGIN_SMALL))
                }
            }
        }
    }
}

@Composable
fun MovieTypeTabRow(
    modifier: Modifier = Modifier,
    tabLabels: List<String>,
    tabIndex: Int,
    onTabSelected: (index: Int) -> Unit
) {
    TabRow(
        modifier = Modifier
            .padding(horizontal = Dimens.MARGIN_20)
            .clip(MaterialTheme.shapes.small)
            .background(color = Colors.colorBlack)
            .padding(Dimens.MARGIN_MEDIUM)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() } // This is mandatory
            ) {},
        selectedTabIndex = tabIndex,
        contentColor = Color.White,
        containerColor = Colors.colorBlack,
        indicator = {
            Box(
                Modifier
                    .tabIndicatorOffset(it[tabIndex])
                    .fillMaxSize()
                    .clip(MaterialTheme.shapes.small)
                    .background(color = Colors.Blue)
            )
        },

        divider = {}

    ) {
        tabLabels.forEachIndexed { index, title ->
            val selected = tabIndex == index
            Tab(
                modifier = Modifier.zIndex(2f),
                selected = selected,
                onClick = {
                    onTabSelected(index)
                },
                text = {
                    Text(
                        text = title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = Colors.colorWhite,
                    )
                }
            )
        }
    }
}

@Composable
fun InterestAppBar(
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(color = Colors.colorBackground)
            .padding(horizontal = Dimens.MARGIN_20)
    ) {
        Icon(
            imageVector = Icons.Rounded.ArrowBackIos,
            tint = Color.White,
            contentDescription = null,
        )
        Text(
            text = "Explore Movies",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            fontSize = Dimens.TEXT_LARGE
        )
        Image(
            painter = painterResource(id = R.drawable.baseline_search_24),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color.White)
        )
    }
}

@Preview
@Composable
fun InterestScreenPreview() {
    ComposeBookStoreTheme {
        InterestsRoute(onTopicClick = {})
    }
}