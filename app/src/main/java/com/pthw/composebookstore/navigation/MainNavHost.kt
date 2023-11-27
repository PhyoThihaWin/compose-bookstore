/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pthw.composebookstore.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.pthw.composebookstore.feature.bookmark.navigation.bookmarksScreen
import com.pthw.composebookstore.feature.foryou.navigation.forYouNavigationRoute
import com.pthw.composebookstore.feature.foryou.navigation.forYouScreen
import com.pthw.composebookstore.feature.interests.navigation.interestsGraph
import com.pthw.composebookstore.ui.main.MainScreenState
import kotlinx.coroutines.awaitAll

/**
 * Top-level navigation graph. Navigation is organized as explained at
 * https://d.android.com/jetpack/compose/nav-adaptive
 *
 * The navigation graph defined in this file defines the different top level routes. Navigation
 * within each route is handled using state and Back Handlers.
 */
@Composable
fun MainNavHost(
    appState: MainScreenState,
    modifier: Modifier = Modifier,
    startDestination: String = forYouNavigationRoute,
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        forYouScreen(onTopicClick = { })
        bookmarksScreen(
            onTopicClick = { },
        )
        interestsGraph(
            onTopicClick = {},
            nestedGraphs = {

            },
        )

    }
}
