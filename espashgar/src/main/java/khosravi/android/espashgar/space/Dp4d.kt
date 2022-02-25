package khosravi.android.espashgar.space

import android.content.Context
import android.util.TypedValue
import khosravi.android.espashgar.dpToPx

internal class Dp4d(
    start: Int?, top: Int?, end: Int?, bottom: Int?
) : Value4d(start, top, end, bottom) {

    fun toPixel(context: Context?) = Px4d(
        start?.dpToPx(context),
        top?.dpToPx(context),
        end?.dpToPx(context),
        bottom?.dpToPx(context)
    )

    fun clone() = Dp4d(start, top, end, bottom)

    override fun typeCode(): Int = TypedValue.COMPLEX_UNIT_DIP

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Dp4d) return false
        if (!super.equals(other)) return false
        return true
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}