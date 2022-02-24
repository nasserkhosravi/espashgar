package khosravi.android.espashgar.space

import android.util.TypedValue
import khosravi.android.espashgar.convertTo

internal class Px4d(
    start: Int?, top: Int?, end: Int?, bottom: Int?
) : Value4d(start, top, end, bottom) {

    fun toDp() = Dp4d(
        start?.convertTo(DP),
        top?.convertTo(DP),
        end?.convertTo(DP),
        bottom?.convertTo(DP)
    )

    fun clone() = Px4d(start, top, end, bottom)

    override fun typeCode(): Int  = TypedValue.COMPLEX_UNIT_PX
    
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }


    companion object {
        private const val DP = TypedValue.COMPLEX_UNIT_DIP
    }
}