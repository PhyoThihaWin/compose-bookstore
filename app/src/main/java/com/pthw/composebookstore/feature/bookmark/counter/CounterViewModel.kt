package com.pthw.composebookstore.feature.bookmark.counter

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Calendar
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by P.T.H.W on 14/11/2023.
 */

@HiltViewModel
class CounterViewModel @Inject constructor() : ViewModel() {

    private val _countFlow = MutableStateFlow(CountDownVO())
    val countFlow = _countFlow.asStateFlow()


    fun setupCountDown(): CountDownTimer {

        val calendar = Calendar.getInstance()
        val currentTime = calendar.timeInMillis
        calendar.add(Calendar.HOUR, 3)
        val totalTimeInMillis = calendar.timeInMillis - currentTime

        val countDownTimer = object : CountDownTimer(totalTimeInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Calculate remaining hours, minutes, and seconds
                val days = TimeUnit.MILLISECONDS.toDays(millisUntilFinished)
                val hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished)
                val minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60
                val seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60

                _countFlow.update {
                    it.copy(
                        day = days.toInt(),
                        hour = hours.toInt(),
                        minute = minutes.toInt(),
                        second = seconds.toInt()
                    )
                }
            }

            override fun onFinish() {
                // Countdown finished, perform any action needed
            }
        }
        return countDownTimer

    }

}

data class CountDownVO(
    val day: Int = 0,
    val hour: Int = 0,
    val minute: Int = 0,
    val second: Int = 0,
)