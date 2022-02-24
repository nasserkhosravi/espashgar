package khosravi.android.espashgar

import android.os.Bundle
import android.view.View
import khosravi.android.espashgar.space.Margin
import khosravi.android.espashgar.space.Padding
import khosravi.android.espashgar.space.Space4D

fun Margin.applyOn(views: List<View>) {
    views.forEach { applyOn(it) }
}

fun Padding.applyOn(views: List<View>) {
    views.forEach { applyOn(it) }
}

fun Margin.applyOn(vararg views: View) {
    for (view in views) {
        applyOn(view)
    }
}

fun Padding.applyOn(vararg views: View) {
    for (view in views) {
        applyOn(view)
    }
}

fun View.getMargin(): Margin {
    return Margin.fromViewPx(this).build()
}

fun View.getPadding(): Padding {
    return Padding.fromViewPx(this).build()
}

fun paddingDp() = Padding.dp()

fun marginDp() = Margin.dp()