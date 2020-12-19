package com.rogergcc.retorgcprojectmdevconf2020

import android.app.Application
import timber.log.Timber

import timber.log.Timber.DebugTree


/**
 * Created by rogergcc on 18/12/2020.
 * Copyright Ⓒ 2020 . All rights reserved.
 */
class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }

    }
}