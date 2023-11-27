package com.pthw.composebookstore.codelab.state_in_compose

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

/**
 * Created by P.T.H.W on 28/10/2023.
 */
class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks


    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) =
        tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }

    private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

}

