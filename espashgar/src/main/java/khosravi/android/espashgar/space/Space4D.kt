package khosravi.android.espashgar.space

import android.util.TypedValue
import java.lang.IllegalArgumentException

abstract class Space4D<SELF> {

    var isRtlAware: Boolean = true

    open var start: Int?
        get() = mainValue.start
        set(value) {
            mainValue.start = value
            onValueChange()
        }

    open var top: Int?
        get() = mainValue.top
        set(value) {
            mainValue.top = value
            onValueChange()
        }

    open var end: Int?
        get() = mainValue.end
        set(value) {
            mainValue.end = value
            onValueChange()
        }

    open var bottom: Int?
        get() = mainValue.bottom
        set(value) {
            mainValue.bottom = value
            onValueChange()
        }

    val vertical: Int?
        get() {
            return top.plusWith(bottom)
        }


    val horizontal: Int?
        get() {
            return start.plusWith(end)
        }

    private var pxValue: Value4d? = null

    internal abstract val mainValue: Value4d

    internal abstract fun createSelf(value4d: Value4d): SELF

    private fun createValue4d(start: Int?, top: Int?, end: Int?, bottom: Int?): Value4d {
        return when (mainValue) {
            is Dp4d -> Dp4d(start, top, end, bottom)

            is Px4d -> Px4d(start, top, end, bottom)

        }
    }

    /**
     * convert values to px if it's not
     */
    internal fun getPreparedValueInPx(): Value4d {
        if (pxValue == null) {
            pxValue = mainValue.toPixel()
        }
        return pxValue!!
    }

    protected fun onValueChange() {
        pxValue = null
    }

    fun isDp(): Boolean = mainValue is Dp4d

    fun isPx(): Boolean = mainValue is Px4d

    fun toDp(): SELF = createSelf(mainValue.toDp())

    fun toPx(): SELF = createSelf(mainValue.toPixel())

    private fun Value4d.toDp(): Dp4d {
        return when (this) {
            is Dp4d -> this.clone()
            is Px4d -> this.toDp()
        }
    }

    private fun Value4d.toPixel(): Px4d {
        return when (this) {
            is Dp4d -> this.toPixel()
            is Px4d -> this.clone()
        }
    }

    operator fun times(time: Int): SELF {
        return createSelf(
            createValue4d(
                start.selfOrZero().times(time),
                top.selfOrZero().times(time),
                end.selfOrZero().times(time),
                bottom.selfOrZero().times(time)
            )
        )
    }

    operator fun timesAssign(time: Int) {
        start = start.selfOrZero().times(time)
        end = end.selfOrZero().times(time)
        top = top.selfOrZero().times(time)
        bottom = bottom.selfOrZero().times(time)
    }

    operator fun plus(plus: Int): SELF {
        return createSelf(
            createValue4d(
                start.selfOrZero().plus(plus),
                top.selfOrZero().plus(plus),
                end.selfOrZero().plus(plus),
                bottom.selfOrZero().plus(plus)
            )
        )
    }

    operator fun plusAssign(plus: Int) {
        start = start.selfOrZero().plus(plus)
        end = end.selfOrZero().plus(plus)
        top = top.selfOrZero().plus(plus)
        bottom = bottom.selfOrZero().plus(plus)
    }

    operator fun minus(minus: Int): SELF {
        return createSelf(
            createValue4d(
                start.selfOrZero().minus(minus),
                top.selfOrZero().minus(minus),
                end.selfOrZero().minus(minus),
                bottom.selfOrZero().minus(minus)
            )
        )
    }

    operator fun minusAssign(minus: Int) {
        start = start.selfOrZero().minus(minus)
        end = end.selfOrZero().minus(minus)
        top = top.selfOrZero().minus(minus)
        bottom = bottom.selfOrZero().minus(minus)
    }

    private fun Int?.plusWith(b: Int?): Int? {
        if (this == null && b == null) {
            return b
        }
        return this ?: 0 + (b ?: 0)
    }

    private fun Int?.selfOrZero(): Int {
        return this ?: 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Space4D<*>) return false

        if (isRtlAware != other.isRtlAware) return false
        if (mainValue != other.mainValue) return false

        return true
    }

    override fun hashCode(): Int {
        var result = isRtlAware.hashCode()
        result = 31 * result + mainValue.hashCode()
        return result
    }


    companion object {

        internal fun createValue4dByType(
            type: Int,
            start: Int?,
            top: Int?,
            end: Int?,
            bottom: Int?
        ): Value4d {
            return when (type) {
                TypedValue.COMPLEX_UNIT_DIP -> Dp4d(start, top, end, bottom)
                TypedValue.COMPLEX_UNIT_PX -> Px4d(start, top, end, bottom)
                else -> throw unsupportedType()
            }
        }

        private fun unsupportedType() = IllegalArgumentException("Unsupported type")
    }

}