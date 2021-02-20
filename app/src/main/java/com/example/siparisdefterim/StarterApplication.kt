package com.example.siparisdefterim

import android.app.Application
import com.parse.Parse

class StarterApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG)

        Parse.initialize(Parse.Configuration.Builder(this)
            .applicationId("s70VaxHuMdaiMIe77RZA7VEKNyKv8LFvPQEMIhJt")
            .clientKey("W7UKuOzZ1Lyzah5zFoQ3pdB2UFB2OCi64t7mKPzL")
            .server("https://parseapi.back4app.com/")
            .build()
        )
    }

}