package com.pthw.composebookstore.feature.setting

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * Created by P.T.H.W on 08/12/2023.
 */
@Composable
fun SettingsRoute(
    onTopicClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    Text(text = "This is SettingsRoute PAGE.")
}