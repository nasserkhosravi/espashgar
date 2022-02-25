package khosravi.android.espashgar

import android.view.View
import khosravi.android.espashgar.space.Margin
import khosravi.android.espashgar.space.Padding

fun Margin.applyOn(views: List<View>) {
    views.forEach { applyOn(it) }
}

fun Padding.applyOn(views: List<View>) {
    views.forEach { applyOn(it) }
}

fun Margin.applyOn(vararg views: View) {
    applyOn(views.toList())
}

fun Padding.applyOn(vararg views: View) {
    applyOn(views.toList())
}

fun View.getMargin(): Margin {
    return Margin.fromViewPx(this).build()
}

fun View.getPadding(): Padding {
    return Padding.fromViewPx(this).build()
}

fun paddingDp() = Padding.dp()

fun marginDp() = Margin.dp()