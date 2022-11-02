package com.geeksville.mesh.ui

import android.content.Context
import android.content.res.Resources
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import com.geeksville.mesh.BuildConfig
import org.osmdroid.views.MapView
import com.geeksville.mesh.R
import com.geeksville.mesh.model.map.CustomOverlayManager
import com.geeksville.mesh.ui.MapConstants.Companion.DEFAULT_MAX_ZOOM
import com.geeksville.mesh.ui.MapConstants.Companion.DEFAULT_MIN_ZOOM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.overlay.CopyrightOverlay

@Preview(showBackground = true)
@Composable
fun MapView(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Configuration.getInstance().userAgentValue =
        BuildConfig.APPLICATION_ID // Required to get online tiles
    val mapViewState = rememberMapViewWithLifecycle()
    AndroidView(
        { mapViewState }) { mapView ->
        CoroutineScope(Dispatchers.Main).launch {
            setupMapProperties(mapView, context)
        }
    }
    MapStyleButton()
    DownloadButton()
}


/**
 * Adds copyright to map depending on what source is showing
 */
private fun addCopyright(map: MapView, context: Context) {
    if (map.tileProvider.tileSource.copyrightNotice != null) {
        val copyrightNotice: String = map.tileProvider.tileSource.copyrightNotice
        val copyrightOverlay = CopyrightOverlay(context)
        copyrightOverlay.setCopyrightNotice(copyrightNotice)
        map.overlays.add(copyrightOverlay)
    }
}

private fun setupMapProperties(mapView: MapView, context: Context) {
    // private var nodePositions = listOf<MarkerWithLabel>()
    // private var wayPoints = listOf<MarkerWithLabel>()
    mapView.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE)
    mapView.setDestroyMode(false) // keeps map instance alive when in the background.
    mapView.isVerticalMapRepetitionEnabled = false // disables map repetition
    mapView.overlayManager = CustomOverlayManager.create(mapView, context)
    mapView.setScrollableAreaLimitLatitude(
        mapView.overlayManager.tilesOverlay.bounds.actualNorth,
        mapView.overlayManager.tilesOverlay.bounds.actualSouth,
        0
    ) // bounds scrollable map
    mapView.isTilesScaledToDpi =
        true // scales the map tiles to the display density of the screen
    mapView.minZoomLevel =
        DEFAULT_MIN_ZOOM // sets the minimum zoom level (the furthest out you can zoom)
    mapView.maxZoomLevel = DEFAULT_MAX_ZOOM
    mapView.setMultiTouchControls(true) // Sets gesture controls to true.
    mapView.zoomController.setVisibility(CustomZoomButtonsController.Visibility.NEVER) // Disables default +/- button for zooming
    mapView.controller.zoomTo(DEFAULT_MIN_ZOOM)
//        mapView.addMapListener(object : MapListener {
//            override fun onScroll(event: ScrollEvent): Boolean {
//                if (binding.cacheLayout.visibility == View.VISIBLE) {
//                    generateBoxOverlay(zoomLevelMax)
//                }
//                return true
//            }
//
//            override fun onZoom(event: ZoomEvent): Boolean {
//                return false
//            }
//        })
}

@Composable
fun MapStyleButton() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.size(width = 56.dp, height = 48.dp),
        enabled = true,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(R.color.colorAdvancedBackground),
        ),
        contentPadding = PaddingValues(Dp(0f)),
    ) {
        Image(
            alignment = Alignment.Center,
            modifier = Modifier
                .absolutePadding(Dp(0f), Dp(0f), Dp(0f), Dp(0f))
                .background(
                    color = Color(R.color.unselectedColor)
                ),
            painter = painterResource(id = R.drawable.ic_twotone_layers_24),
            contentDescription = R.string.style_selection.toString()
        )
    }
}

@Composable
fun DownloadButton() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        backgroundColor = Color(R.color.buttonColor),
        contentColor = contentColorFor(backgroundColor = Color(R.color.buttonColor)),
    ) {
        Image(
            modifier = Modifier
                .absolutePadding(Dp(0f), Dp(0f), Dp(0f), Dp(0f))
                .background(
                    color = Color(R.color.buttonColor)
                ),
            painter = painterResource(id = R.drawable.ic_appintro_arrow),
            contentDescription = R.string.download_region.toString()
        )
    }
}

@Composable
fun CacheManagerDialog() {
    Dialog(onDismissRequest = { /*TODO*/ }) {
        DownloadRegionView()
        CacheSizeView()
        ClearDownloadedTilesView()
    }

}

@Composable
fun DownloadRegionView() {
    SelectDownloadRegionText()
    ToggleButtonGroup()
    CacheEstimateText()
    ExecuteJobButton()
    CancelDownloadButton()
}

@Composable
fun CacheSizeView() {
    //show current cache size
}

@Composable
fun ClearDownloadedTilesView() {

}

@Composable
fun SelectDownloadRegionText() {
    Text(
        text = R.string.select_download_region.toString(),
        color = Color.DarkGray
    )
}

@Composable
fun ToggleButtonGroup() {
    FiveMileButton()
    TenMileButton()
    FifteenMileButton()

}

@Composable
fun FiveMileButton() {
    Button(onClick = { /*TODO*/ }) {

    }

}

@Composable
fun FifteenMileButton() {
    Button(onClick = { /*TODO*/ }) {

    }

}

@Composable
fun TenMileButton() {
    Button(onClick = { /*TODO*/ }) {

    }
}

@Composable
fun ExecuteJobButton() {
    Button(onClick = { /*TODO*/ }) {

    }

}

@Composable
fun CancelDownloadButton() {
    Button(onClick = { /*TODO*/ }) {

    }
}

@Composable
fun CacheEstimateText() {
    Text(text = R.string.tile_download_estimate.toString(), color = Color.Gray)
}

class MapView {

}
