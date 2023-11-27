package com.pthw.composebookstore.feature.foryou.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.pthw.composebookstore.feature.foryou.ForYouRoute

/**
 * Created by P.T.H.W on 13/11/2023.
 */

const val LINKED_NEWS_RESOURCE_ID = "linkedNewsResourceId"
const val forYouNavigationRoute = "for_you_route/{$LINKED_NEWS_RESOURCE_ID}"
private const val DEEP_LINK_URI_PATTERN =
    "https://www.nowinandroid.apps.samples.google.com/foryou/{$LINKED_NEWS_RESOURCE_ID}"

fun NavController.navigateToForYou(navOptions: NavOptions? = null) {
    this.navigate(forYouNavigationRoute, navOptions)
}

fun NavGraphBuilder.forYouScreen(onTopicClick: (String) -> Unit) {
    composable(
        route = forYouNavigationRoute,
        deepLinks = listOf(
            navDeepLink { uriPattern = DEEP_LINK_URI_PATTERN },
        ),
        arguments = listOf(
            navArgument(LINKED_NEWS_RESOURCE_ID) { type = NavType.StringType },
        ),
    ) {
        ForYouRoute(onTopicClick)
    }
}
