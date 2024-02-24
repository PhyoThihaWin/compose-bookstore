package com.pthw.composebookstore.feature.bookmark

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarStyle
import com.pthw.composebookstore.feature.foryou.ListTitleText
import com.pthw.composebookstore.ui.theme.Colors
import com.pthw.composebookstore.ui.theme.ComposeBookStoreTheme
import com.pthw.composebookstore.ui.theme.Dimens

/**
 * Created by P.T.H.W on 14/11/2023.
 */

@Composable
fun BookmarksRoute(
    onTopicClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: BookmarksViewModel = hiltViewModel(),
) {

    var expandIndex by remember { mutableStateOf<Int?>(null) }

    Column(
        modifier = modifier.background(color = Colors.colorBackground)
    ) {
        BookMarkAppBar()
        LazyColumn {
            listOf("0.1.02 Novermber 2024", "0.1.02 Novermber 2024")
                .forEach { header ->
                    item {
                        ListTitleText(modifier = modifier, text = header)
                    }
                    itemsIndexed(arrayListOf(1, 1, 1, 1, 1)) { index, _ ->
                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = Dimens.MARGIN_20)
                                    .padding(bottom = Dimens.MARGIN_MEDIUM)
                                    .clickable {
                                        expandIndex = if (expandIndex == index) null else index
                                    }
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
                                Spacer(modifier = modifier.width(Dimens.MARGIN_MEDIUM_2))
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
                                        Text(
                                            text = "4.5",
                                            color = Color.Gray

                                        )
                                        Spacer(modifier = Modifier.width(Dimens.MARGIN_MEDIUM))
                                        RatingBar(
                                            value = 2f,
                                            style = RatingBarStyle.Fill(),
                                            size = Dimens.MARGIN_MEDIUM_2,
                                            spaceBetween = Dimens.MARGIN_XSMALL,
                                            onValueChange = {
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


                            AnimatedVisibility(visible = index == expandIndex) {
                                Box(
                                    modifier = modifier
                                        .background(color = Color.White)
                                        .fillMaxWidth()
                                        .height(300.dp)
                                )
                            }
                        }
                    }
                }

        }
    }

}

@Composable
fun BookMarkAppBar(
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
            text = "Saved Plan",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            fontSize = Dimens.TEXT_LARGE
        )
        Spacer(modifier = modifier)
    }
}

@Preview
@Composable
fun InterestScreenPreview() {
    ComposeBookStoreTheme {
        BookmarksRoute(onTopicClick = {})
    }
}