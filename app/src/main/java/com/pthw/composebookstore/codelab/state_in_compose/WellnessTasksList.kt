package com.pthw.composebookstore.codelab.state_in_compose


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Created by P.T.H.W on 28/10/2023.
 */
@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
) {
    LazyColumn(
        modifier = modifier,
        state = state
    ) {
        items(
            items = list,
            key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(taskName = task.label,
                checked = task.checked,
                onCheckedChange = {
                    onCheckedTask(task, it)
                },
                onClose = { onCloseTask(task) })
        }
    }
}