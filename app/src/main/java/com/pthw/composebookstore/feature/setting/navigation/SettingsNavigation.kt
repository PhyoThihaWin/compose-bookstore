package com.pthw.composebookstore.feature.setting.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.pthw.composebookstore.feature.setting.SettingsRoute

/**
 * Created by P.T.H.W on 08/12/2023.
 */

private const val SETTING_GRAPH_ROUTE_PATTERN = "setting_graph"
const val settingsRoute = "settings_route"

fun NavController.navigateToSettingsGraph(navOptions: NavOptions? = null) {
    this.navigate(SETTING_GRAPH_ROUTE_PATTERN, navOptions)
}

fun NavGraphBuilder.settingGraph(
    onTopicClick: (String) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {
    navigation(
        route = SETTING_GRAPH_ROUTE_PATTERN,
        startDestination = settingsRoute,
    ) {
        composable(route = settingsRoute) {
            SettingsRoute(onTopicClick)
        }
        nestedGraphs()
    }
}
