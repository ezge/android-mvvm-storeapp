package com.example.storeapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class SportStoreApp : Application(){

    override fun onCreate() {
        super.onCreate()
        // You can initialize Timber, Crashlytics, Firebase, etc. here
    }
}
