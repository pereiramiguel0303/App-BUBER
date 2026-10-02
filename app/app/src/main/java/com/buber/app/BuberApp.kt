package com.buber.app

import android.app.Application
import org.maplibre.android.MapLibre

class BuberApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // MapLibre não exige token; o estilo é definido no MapScreen.
        MapLibre.getInstance(this)
    }
}
