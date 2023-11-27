package com.pthw.composebookstore.feature.bookmark.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.pthw.composebookstore.feature.bookmark.BookmarksRoute
import com.pthw.composebookstore.feature.foryou.ForYouRoute

/**
 * Created by P.T.H.W on 13/11/2023.
 */

const val bookmarksRoute = "bookmarks_route"

fun NavController.navigateToBookmarks(navOptions: NavOptions? = null) {
    this.navigate(bookmarksRoute, navOptions)
}

fun NavGraphBuilder.bookmarksScreen(
    onTopicClick: (String) -> Unit,
) {
    composable(route = bookmarksRoute) {
        BookmarksRoute(onTopicClick)
    }
}

