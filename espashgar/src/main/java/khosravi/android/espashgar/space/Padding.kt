package khosravi.android.espashgar.space

import android.os.Parcel
import android.os.Parcelable
import android.view.View
import khosravi.android.espashgar.readBool
import khosravi.android.espashgar.writeBool

open class Padding private constructor(
    override val mainValue: Value4d
) : Space4D<Padding>(), Parcelable {

    override fun createSelf(value4d: Value4d) = Padding(value4d).also {
        it.isRtlAware = this.isRtlAware
    }

    fun applyOn(view: View) {
        val value = getPreparedValueInPx()
        if (isRtlAware) {
            view.setPaddingRelative(
                value.start ?: view.paddingStart,
                value.top ?: view.paddingTop,
                value.end ?: view.paddingEnd,
                value.bottom ?: view.paddingBottom
            )
            return
        }
        view.setPadding(
            value.start ?: view.paddingStart,
            value.top ?: view.paddingTop,
            value.end ?: view.paddingEnd,
            value.bottom ?: view.paddingBottom
        )
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other) && other is Padding
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    class Builder internal constructor(value: Value4d) : Builder4d<Builder>(value) {
        fun build() = Padding(getValue())

        fun applyOn(view: View) = build().applyOn(view)

    }

    companion object {

        fun dp() = Builder(Dp4d(null, null, null, null))

        fun px() = Builder(Px4d(null, null, null, null))

        fun fromViewPx(view: View) = Builder(
            Px4d(
                view.paddingStart, view.paddingTop,
                view.paddingEnd, view.paddingBottom
            )
        )


        @JvmField
        val CREATOR = object : Parcelable.Creator<Padding> {
            override fun createFromParcel(parcel: Parcel) = Padding(parcel)

            override fun newArray(size: Int): Array<Padding?> = arrayOfNulls(size)
        }
    }

    override fun describeContents(): Int = 0

    override fun writeToParcel(parcel: Parcel?, flags: Int) {
        parcel?.writeInt(mainValue.typeCode())
        start?.let { parcel?.writeInt(it) }
        end?.let { parcel?.writeInt(it) }
        top?.let { parcel?.writeInt(it) }
        bottom?.let { parcel?.writeInt(it) }
        parcel?.writeBool(isRtlAware)
    }

    constructor(parcel: Parcel) : this(
        createValue4dByType(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt()
        )
    ) {
        isRtlAware = parcel.readBool()!!
    }

}



