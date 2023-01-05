package furkan.compose_lazy_column


import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle

@Composable
fun MyTextView(text : String, color : Color, style : FontStyle) {
    Text(
        text = text,
        color = color,
        fontStyle = style
    )
}