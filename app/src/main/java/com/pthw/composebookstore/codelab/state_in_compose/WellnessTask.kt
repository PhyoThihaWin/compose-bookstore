package com.pthw.composebookstore.codelab.state_in_compose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

//data class WellnessTask(val id: Int, val label: String, var checked: Boolean = false)

class WellnessTask(
    val id: Int,
    val label: String,
    initialChecked: Boolean = false
) {
    var checked by mutableStateOf(initialChecked)
}