package com.geeksville.mesh.ui

sealed class Screen(val route: String) {
    object Map : Screen(route = "map_screen")
}
