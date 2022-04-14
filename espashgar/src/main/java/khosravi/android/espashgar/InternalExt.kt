package khosravi.android.espashgar

import android.content.Context
import android.content.res.Resources
import android.os.Parcel
import android.view.View
import android.view.ViewGroup.MarginLayoutParams

internal fun Int.pxToDp(context: Context? = null): Int {
    return (this / context.getResourceOrDefault().displayMetrics.density).toInt()
}

internal fun Int.dpToPx(context: Context? = null): Int {
    return (this * context.getResourceOrDefault().displayMetrics.density).toInt()
}

private fun Context?.getResourceOrDefault(): Resources {
    return this?.resources ?: Resources.getSystem()
}

internal fun Parcel.writeBool(flag: Boolean?) {
    when (flag) {
        true -> writeInt(1)
        false -> writeInt(0)
        else -> writeInt(-1)
    }
}

internal fun Parcel.readBool(): Boolean? {
    return when (readInt()) {
        1 -> true
        0 -> false
        else -> null
    }
}

private inline fun View.getPossibleMarginLayoutParam() = layoutParams as? MarginLayoutParams

internal val View.marginStart: Int
    get() {
        return getPossibleMarginLayoutParam()?.marginStart ?: 0
    }

internal val View.marginEnd: Int
    get() {
        return getPossibleMarginLayoutParam()?.marginEnd ?: 0
    }

internal val View.marginTop: Int
    get() {
        return getPossibleMarginLayoutParam()?.topMargin ?: 0
    }

internal val View.marginBottom: Int
    get() {
        return getPossibleMarginLayoutParam()?.bottomMargin ?: 0
    }