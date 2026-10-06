package com.buber.app

import android.app.Application
import org.maplibre.android.MapLibre

class BuberApp : Application() {
    override fun onCreate() {
        super.onCreate()
        MapLibre.getInstance(this)
    }
}
