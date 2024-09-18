package com.example.potluck.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

sealed class ButtonStyle(
    val backgroundColor: Color,
    val textColor: Color
) {
    object Primary : ButtonStyle(Color(0xFF0D6EFD), Color.White)
    object Info : ButtonStyle(Color(0xFF17A2B8), Color.White)
    object Danger : ButtonStyle(Color(0xFFDC3545), Color.White)
    object Default : ButtonStyle(Color(0xFF6C757D), Color.White)
    object Warning : ButtonStyle(Color(0xFFFFC107), Color.Black)
}

@Composable
fun CustomButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    style: ButtonStyle = ButtonStyle.Default,
    text: String
) {
    FilledTonalButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        colors = ButtonDefaults.filledTonalButtonColors(
            containerColor = style.backgroundColor,
            contentColor = style.textColor
        ),
        shape = RoundedCornerShape(6.dp),
        elevation = ButtonDefaults.elevatedButtonElevation(8.dp)
    ) {
        Text(text = text)
    }
}