package khosravi.android.espashgar.space

internal sealed class Value4d(
    var start: Int?, var top: Int?, var end: Int?, var bottom: Int?
){
    abstract fun typeCode(): Int
}