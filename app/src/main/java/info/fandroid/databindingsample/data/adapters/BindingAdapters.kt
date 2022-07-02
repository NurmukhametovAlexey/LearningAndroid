package info.fandroid.databindingsample.data.adapters

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter
import info.fandroid.databindingsample.R
import info.fandroid.databindingsample.data.Popularity

@BindingAdapter("app:hideIfZero")
fun View.hideIfZero(number: Int) {
    this.visibility = when(number) {
        0 -> View.GONE
        else -> View.VISIBLE
    }
}

@BindingAdapter(value = ["app:progressScaled", "android:max"], requireAll = true)
fun ProgressBar.setProgress(likes: Int, max: Int) {
    this.progress = (likes * max / 5).coerceAtMost(max)
}

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
@BindingAdapter("app:progressColored")
fun View.colorPopularity(popularity: Popularity) {
    val colorStateList = ColorStateList.valueOf(getAssociatedColor(popularity, this.context))
    when (this) {
        is ProgressBar -> this.progressTintList = colorStateList
        is ImageView -> ImageViewCompat.setImageTintList(this, colorStateList)
    }
}

@BindingAdapter("app:progressDrawn")
fun ImageView.drawPopularity(popularity: Popularity) {
    this.setImageDrawable(getDrawablePopularity(popularity, this.context))
}

private fun getAssociatedColor(popularity: Popularity, context: Context): Int {
    return when (popularity) {
        Popularity.NORMAL -> context.theme.obtainStyledAttributes(
            intArrayOf(android.R.attr.colorForeground)
        ).getColor(0, 0x000000)
        Popularity.POPULAR -> ContextCompat.getColor(context, R.color.popular)
        Popularity.STAR -> ContextCompat.getColor(context, R.color.star)
    }
}

private fun getDrawablePopularity(popularity: Popularity, context: Context): Drawable? {
    return when (popularity) {
        Popularity.NORMAL -> {
            ContextCompat.getDrawable(context, R.drawable.ic_person_black_96dp)
        }
        Popularity.POPULAR -> {
            ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp)
        }
        Popularity.STAR -> {
            ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp)
        }
    }
}