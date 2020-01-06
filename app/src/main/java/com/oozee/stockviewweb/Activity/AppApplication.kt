package com.oozee.stockviewweb.Activity

import android.app.Application
import android.content.Context


class AppApplication : Application(){

    override fun onCreate() {
        super.onCreate()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }
}