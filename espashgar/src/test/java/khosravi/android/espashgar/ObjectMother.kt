package khosravi.android.espashgar

import khosravi.android.espashgar.space.Dp4d
import khosravi.android.espashgar.space.Px4d

internal fun aValue4d(
    start: Int? = null,
    top: Int? = null,
    end: Int? = null,
    bottom: Int? = null
) = aPx4d(start, top, end, bottom)

internal fun aDp4d(
    start: Int? = null,
    top: Int? = null,
    end: Int? = null,
    bottom: Int? = null
) = Dp4d(start, top, end, bottom)

internal fun aPx4d(
    start: Int? = null,
    top: Int? = null,
    end: Int? = null,
    bottom: Int? = null
) = Px4d(start, top, end, bottom)