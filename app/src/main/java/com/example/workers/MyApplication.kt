package com.example.workers

import android.app.Application
import com.example.workers.model.Database

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Database.init(this)
    }
}