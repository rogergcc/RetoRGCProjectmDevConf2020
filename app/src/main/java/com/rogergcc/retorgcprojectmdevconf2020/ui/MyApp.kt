package com.rogergcc.retorgcprojectmdevconf2020.ui

import android.app.Application
import com.rogergcc.retorgcprojectmdevconf2020.ui.utils.TimberAppLogger


/**
 * Created by rogergcc on 18/12/2020.
 * Copyright Ⓒ 2020 . All rights reserved.
 */
class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
//        if (BuildConfig.DEBUG) {
//            Timber.plant(DebugTree())
//        }
        TimberAppLogger.init()

    }
}