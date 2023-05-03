package com.geeksville.mesh.ui.map.components

import com.geeksville.mesh.R

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*

@Composable
fun MapStyleButton(onClick: () -> Unit) {
    var isSelected by remember { mutableStateOf(false) }

    Button(
        onClick = {
            isSelected = !isSelected
            onClick()
        },
        modifier = Modifier
            .width(48.dp)
            .height(56.dp)
            .padding(8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(R.color.colorAdvancedBackground),
            contentColor = if (isSelected) MaterialTheme.colors.primary else Color(R.color.unselectedColor),
        ),
        contentPadding = PaddingValues(0.dp),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_twotone_layers_24),
            contentDescription = stringResource(R.string.map_style_selection),
            tint = if (isSelected) MaterialTheme.colors.primary else Color(R.color.unselectedColor),
            modifier = Modifier
                .size(24.dp)
                .padding(start = 16.dp, end = 8.dp)
                .align(Alignment.CenterVertically),
        )
    }
}
@Preview(showBackground = true)
@Composable
private fun MapStyleButtonPreview() {
    MapStyleButton(onClick = {})
}