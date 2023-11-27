package com.pthw.composebookstore

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.pthw.composebookstore.ui.main.mainScreen
import com.pthw.composebookstore.ui.theme.ComposeBookStoreTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar
import javax.inject.Inject

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var calendar: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        Log.i("Test DI", calendar.time.toString())

        setContent {
            ComposeBookStoreTheme {
                mainScreen(
                    windowSizeClass = calculateWindowSizeClass(this),
                )
            }
        }
    }
}






