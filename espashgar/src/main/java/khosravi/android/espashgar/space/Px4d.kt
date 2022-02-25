package khosravi.android.espashgar.space

import android.content.Context
import android.util.TypedValue
import khosravi.android.espashgar.pxToDp

internal class Px4d(
    start: Int?, top: Int?, end: Int?, bottom: Int?
) : Value4d(start, top, end, bottom) {

    fun toDp(context: Context?) = Dp4d(
        start?.pxToDp(context),
        top?.pxToDp(context),
        end?.pxToDp(context),
        bottom?.pxToDp(context)
    )

    fun clone() = Px4d(start, top, end, bottom)

    override fun typeCode(): Int  = TypedValue.COMPLEX_UNIT_PX

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Px4d) return false
        if (!super.equals(other)) return false
        return true
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}