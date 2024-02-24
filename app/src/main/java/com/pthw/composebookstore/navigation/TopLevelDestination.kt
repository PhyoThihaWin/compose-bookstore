package com.pthw.composebookstore.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.pthw.composebookstore.designsystem.NiaIcons

/**
 * Type for the top level destinations in the application. Each of these destinations
 * can contain one or more screens (based on the window size). Navigation from one screen to the
 * next within a single destination will be handled directly in composables.
 */
enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: String,
    val titleTextId: String,
) {
    FOR_YOU(
        selectedIcon = NiaIcons.Upcoming,
        unselectedIcon = NiaIcons.UpcomingBorder,
        iconTextId = "For you",
        titleTextId = "For you",
    ),
    INTERESTS(
        selectedIcon = NiaIcons.Grid3x3,
        unselectedIcon = NiaIcons.Grid3x3,
        iconTextId = "Interests",
        titleTextId = "Interests",
    ),
    BOOKMARKS(
        selectedIcon = NiaIcons.Bookmarks,
        unselectedIcon = NiaIcons.BookmarksBorder,
        iconTextId = "Saved",
        titleTextId = "Saved",
    ),
    SETTINGS(
        selectedIcon = NiaIcons.Settings,
        unselectedIcon = NiaIcons.SettingsBorder,
        iconTextId = "Settings",
        titleTextId = "Settings",
    ),
}
