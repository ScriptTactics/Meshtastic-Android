package com.geeksville.mesh.ui

class MapConstants {
    companion object {

        const val PREFS_NAME = "org.geeksville.osm.prefs"
        const val MAP_STYLE_ID = "map_style_id"

        // Map Zoom
        const val DEFAULT_MIN_ZOOM = 1.5
        const val DEFAULT_MAX_ZOOM = 18.0

        // NODES
        const val NODE_LAYER = 1
        const val NODE_ZOOM_LEVEL = 8.5
        const val DEFAULT_NODE_ZOOM_SPEED = 3000L

        // Distance of bottom corner to top corner of bounding box
        const val DOWNLOAD_ZOOM_LEVEL_LOWEST = 13.0 // approx 5 miles long
        const val DOWNLOAD_ZOOM_LEVEL_MIDDLE = 12.25 // approx 10 miles long
        const val DOWNLOAD_ZOOM_LEVEL_HIGHEST = 11.5 // approx 15 miles long


    }
}