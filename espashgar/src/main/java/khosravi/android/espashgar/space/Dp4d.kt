package khosravi.android.espashgar.space

import android.util.TypedValue
import khosravi.android.espashgar.convertTo

internal class Dp4d(
    start: Int?, top: Int?, end: Int?, bottom: Int?
) : Value4d(start, top, end, bottom) {

    fun toPixel() = Px4d(
        start?.convertTo(PX),
        top?.convertTo(PX),
        end?.convertTo(PX),
        bottom?.convertTo(PX)
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

    companion object {
        private const val PX = TypedValue.COMPLEX_UNIT_PX
    }
}