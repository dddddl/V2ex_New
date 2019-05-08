package com.ddddl.v2ex

import android.app.Application
import timber.log.Timber

class V2ex :Application(){

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }


}