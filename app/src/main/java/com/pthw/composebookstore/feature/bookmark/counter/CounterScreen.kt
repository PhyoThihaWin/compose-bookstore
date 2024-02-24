package com.pthw.composebookstore.feature.bookmark.counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.pthw.composebookstore.feature.bookmark.BookmarksViewModel
import com.pthw.composebookstore.feature.bookmark.counter.AnimatedCounter
import kotlinx.coroutines.flow.collect

/**
 * Created by P.T.H.W on 14/11/2023.
 */

@Composable
fun CounterRoute(
    onTopicClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CounterViewModel = hiltViewModel(),
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        val countDownVO = viewModel.countFlow.collectAsState()


        Row(
            verticalAlignment = Alignment.CenterVertically
        )
        {
            repeat(4) { index ->
                AnimatedCounter(
                    count = when (index) {
                        0 -> countDownVO.value.day
                        1 -> countDownVO.value.hour
                        2 -> countDownVO.value.minute
                        else -> countDownVO.value.second
                    },
                    style = MaterialTheme.typography.titleLarge
                )

                if (index != 3) Text(text = "  :  ")
            }
        }
        Button(onClick = {
            viewModel.setupCountDown().start()
        }) {
            Text(text = "Increment")
        }
    }
}