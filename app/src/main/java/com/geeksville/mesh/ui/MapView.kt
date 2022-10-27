package com.geeksville.mesh.ui

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import org.osmdroid.views.MapView
import com.geeksville.mesh.R

@Preview(showBackground = true)
@Composable
fun MapView(
    modifier: Modifier = Modifier,
    onLoad: ((map: MapView) -> Unit)? = null
) {
    val mapViewState = rememberMapViewWithLifecycle()
    AndroidView(
        { mapViewState },
        modifier,
    ) { mapView -> onLoad?.invoke(mapView) }
    MapStyleButton()
    DownloadButton()
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
            contentDescription = Resources.getSystem().getString(R.string.preferences_map_style)
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
            contentDescription = Resources.getSystem().getString(R.string.download_region)
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
