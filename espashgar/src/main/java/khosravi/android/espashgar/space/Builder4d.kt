package khosravi.android.espashgar.space

abstract class Builder4d<SELF : Builder4d<SELF>> internal constructor(
    private val value: Value4d,
) {

    private fun self() = this as SELF

    internal fun getValue() = value

    /**
     * Set all four direction specifically
     */
    fun every(start: Int?, top: Int?, end: Int?, bottom: Int?): SELF {
        value.start = start
        value.top = top
        value.end = end
        value.bottom = bottom
        return self()
    }

    /**
     * Set [size] to all four side
     */
    fun all(size: Int?): SELF {
        value.start = size
        value.top = size
        value.end = size
        value.bottom = size
        return self()
    }

    /**
     * divide [value] between top and bottom
     */
    fun divideVertical(value: Int): SELF {
        this.value.top = value / 2
        this.value.bottom = value / 2
        return self()
    }

    /**
     * Set [value] to top and bottom
     */
    fun vertical(value: Int?): SELF {
        this.value.top = value
        this.value.bottom = value
        return self()
    }

    /**
     * divide [value] between start and end
     */
    fun divideHorizontal(value: Int): SELF {
        this.value.start = value / 2
        this.value.end = value / 2
        return self()
    }

    /**
     * Set [value] to start and end
     */
    fun horizontal(value: Int?): SELF {
        this.value.start = value
        this.value.end = value
        return self()
    }

    /**
     * Set [horizontal] to start end and [vertical] to top bottom
     */
    fun side(horizontal: Int?, vertical: Int?): SELF {
        this.value.top = vertical
        this.value.bottom = vertical
        this.value.start = horizontal
        this.value.end = horizontal
        return self()
    }

    /**
     * Set [value] to start
     */
    fun start(value: Int?): SELF {
        this.value.start = value
        return self()
    }

    /**
     * Set [value] to end
     */
    fun end(value: Int?): SELF {
        this.value.end = value
        return self()
    }

    /**
     * Set [value] to top
     */
    fun top(value: Int?): SELF {
        this.value.top = value
        return self()
    }

    /**
     * Set [value] to bottom
     */
    fun bottom(value: Int?): SELF {
        this.value.bottom = value
        return self()
    }
}