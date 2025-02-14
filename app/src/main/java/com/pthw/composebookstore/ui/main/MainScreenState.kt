package com.pthw.composebookstore.ui.main

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import androidx.tracing.trace
import com.pthw.composebookstore.feature.bookmark.navigation.navigateToBookmarks
import com.pthw.composebookstore.feature.foryou.navigation.forYouNavigationRoute
import com.pthw.composebookstore.feature.foryou.navigation.navigateToForYou
import com.pthw.composebookstore.feature.interests.navigation.navigateToInterestsGraph
import com.pthw.composebookstore.feature.setting.navigation.navigateToSettingsGraph
import com.pthw.composebookstore.navigation.TopLevelDestination
import kotlinx.coroutines.CoroutineScope

/**
 * Created by P.T.H.W on 13/11/2023.
 */


@Composable
fun rememberMainScreenState(
    windowSizeClass: WindowSizeClass,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
): MainScreenState {
//    NavigationTrackingSideEffect(navController)
    return remember(
        navController,
        coroutineScope,
        windowSizeClass,
    ) {
        MainScreenState(
            navController,
            coroutineScope,
            windowSizeClass,
        )
    }
}

class MainScreenState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
    val windowSizeClass: WindowSizeClass
) {

    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            forYouNavigationRoute -> TopLevelDestination.FOR_YOU
//            bookmarksRoute -> BOOKMARKS
//            interestsRoute -> INTERESTS
            else -> null
        }

    /**
     * UI logic for navigating to a top level destination in the app. Top level destinations have
     * only one copy of the destination of the back stack, and save and restore state whenever you
     * navigate to and from it.
     *
     * @param topLevelDestination: The destination the app needs to navigate to.
     */
    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        trace("Navigation: ${topLevelDestination.name}") {
            val topLevelNavOptions = navOptions {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }

            when (topLevelDestination) {
                TopLevelDestination.FOR_YOU -> navController.navigateToForYou(topLevelNavOptions)
                TopLevelDestination.BOOKMARKS -> navController.navigateToBookmarks(topLevelNavOptions)
                TopLevelDestination.INTERESTS -> navController.navigateToInterestsGraph(topLevelNavOptions)
                TopLevelDestination.SETTINGS -> navController.navigateToSettingsGraph(topLevelNavOptions)
            }
        }
    }

    /**
     * Map of top level destinations to be used in the TopBar, BottomBar and NavRail. The key is the
     * route.
     */
    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()
}