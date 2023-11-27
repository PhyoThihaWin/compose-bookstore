package com.pthw.composebookstore.feature.bookmark

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * Created by P.T.H.W on 14/11/2023.
 */

@Composable
fun BookmarksRoute(
    onTopicClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: BookmarksViewModel = hiltViewModel(),
) {
    Text(text = "This is BOOKMARK PAGE.")
}