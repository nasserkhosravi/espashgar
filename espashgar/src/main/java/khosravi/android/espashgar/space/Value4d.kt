package khosravi.android.espashgar.space

internal sealed class Value4d(
    var start: Int?, var top: Int?, var end: Int?, var bottom: Int?
){
    abstract fun typeCode(): Int

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Value4d) return false

        if (start != other.start) return false
        if (top != other.top) return false
        if (end != other.end) return false
        if (bottom != other.bottom) return false

        return true
    }

    override fun hashCode(): Int {
        var result = start ?: 0
        result = 31 * result + (top ?: 0)
        result = 31 * result + (end ?: 0)
        result = 31 * result + (bottom ?: 0)
        return result
    }


}