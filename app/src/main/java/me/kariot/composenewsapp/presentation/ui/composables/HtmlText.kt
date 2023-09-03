package me.kariot.composenewsapp.presentation.ui.composables

import android.text.TextUtils
import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import me.kariot.composenewsapp.R

@Composable
fun HtmlText(
    html: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            TextView(context).apply {
                setMaxLines(maxLines)
                ellipsize = TextUtils.TruncateAt.END
                setTextColor(ContextCompat.getColor(this.context, R.color.text_color))
            }
        },
        update = { it.text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT) }
    )
}