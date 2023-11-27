package com.pthw.composebookstore

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by P.T.H.W on 12/09/2023.
 */
@HiltAndroidApp
class BookStoreApp : Application() {
    override fun onCreate() {
        super.onCreate()

    }
}