package com.buber.app.ui.map

import android.annotation.SuppressLint
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import org.maplibre.android.camera.CameraPosition
import org.maplibre.android.geometry.LatLng
import org.maplibre.android.maps.MapLibreMap
import org.maplibre.android.maps.MapView
import org.maplibre.android.maps.Style

/** Centro de São Leopoldo/RS (mesmo valor usado no projeto web). */
val SAO_LEOPOLDO = LatLng(-29.7604, -51.1470)

/**
 * Estilo raster com tiles do OpenStreetMap.
 * Para produção, troque por um provedor próprio (MapTiler, Stadia, Protomaps...),
 * pois o servidor público do OSM não é para tráfego de app em escala.
 */
private const val OSM_STYLE = """
{
  "version": 8,
  "sources": {
    "osm": {
      "type": "raster",
      "tiles": ["https://tile.openstreetmap.org/{z}/{x}/{y}.png"],
      "tileSize": 256,
      "maxzoom": 19,
      "attribution": "© OpenStreetMap contributors"
    }
  },
  "layers": [{ "id": "osm", "type": "raster", "source": "osm" }]
}
"""

@SuppressLint("MissingPermission")
@Composable
fun BuberMap(
    modifier: Modifier = Modifier,
    onMapReady: (MapLibreMap) -> Unit = {},
) {
    val context = LocalContext.current
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val mapView = remember { MapView(context) }

    // MapView exige repassar o ciclo de vida da Activity.
    DisposableEffect(lifecycle, mapView) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> mapView.onCreate(null)
                Lifecycle.Event.ON_START -> mapView.onStart()
                Lifecycle.Event.ON_RESUME -> mapView.onResume()
                Lifecycle.Event.ON_PAUSE -> mapView.onPause()
                Lifecycle.Event.ON_STOP -> mapView.onStop()
                Lifecycle.Event.ON_DESTROY -> mapView.onDestroy()
                else -> Unit
            }
        }
        lifecycle.addObserver(observer)
        // Se o composable entrou depois do ON_CREATE, alinha o estado atual.
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.CREATED)) mapView.onCreate(null)
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) mapView.onStart()
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.RESUMED)) mapView.onResume()
        onDispose {
            lifecycle.removeObserver(observer)
            mapView.onPause(); mapView.onStop(); mapView.onDestroy()
        }
    }

    AndroidView(
        modifier = modifier,
        factory = {
            mapView.apply {
                getMapAsync { map ->
                    map.setStyle(Style.Builder().fromJson(OSM_STYLE)) { onMapReady(map) }
                    map.cameraPosition = CameraPosition.Builder()
                        .target(SAO_LEOPOLDO).zoom(13.0).build()
                    map.uiSettings.isRotateGesturesEnabled = false
                    map.uiSettings.isLogoEnabled = false
                }
            }
        },
    )
}
