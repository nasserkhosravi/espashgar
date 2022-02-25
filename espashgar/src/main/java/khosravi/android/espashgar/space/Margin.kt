package khosravi.android.espashgar.space

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.ContentInfo
import android.view.View
import android.view.ViewGroup
import khosravi.android.espashgar.*
import khosravi.android.espashgar.marginEnd
import khosravi.android.espashgar.marginStart
import khosravi.android.espashgar.readBool
import khosravi.android.espashgar.writeBool

class Margin internal constructor(
    override val mainValue: Value4d
) : Space4D<Margin>(), Parcelable {

    override fun createSelf(value4d: Value4d) = Margin(value4d)
        .also { it.isRtlAware = this.isRtlAware }

    fun applyOn(view: View) {
        view.layoutParams?.let {
            applyOn(it,view.context)
            view.layoutParams = it
        }
    }

    fun applyOn(layoutParam: ViewGroup.LayoutParams,context:Context?) {
        if (layoutParam is ViewGroup.MarginLayoutParams) {
            val value = getPreparedValueInPx(context)
            if (isRtlAware) {
                layoutParam.setMargins(
                    value.start ?: layoutParam.marginStart,
                    value.end ?: layoutParam.marginEnd,
                    value.top ?: layoutParam.topMargin,
                    value.bottom ?: layoutParam.bottomMargin
                )
                return
            }
            layoutParam.setMargins(
                value.start ?: layoutParam.leftMargin,
                value.end ?: layoutParam.rightMargin,
                value.top ?: layoutParam.topMargin,
                value.bottom ?: layoutParam.bottomMargin
            )
        }
    }


    override fun equals(other: Any?): Boolean {
        return super.equals(other) && other is Margin
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    class Builder internal constructor(value: Value4d) : Builder4d<Builder>(value) {
        fun build() = Margin(getValue())

        fun applyOn(view: View) = build().applyOn(view)
    }

    companion object {

        fun dp() = Builder(Dp4d(null, null, null, null))

        fun px() = Builder(Px4d(null, null, null, null))

        fun fromViewPx(view: View): Builder {
            return Builder(
                Px4d(
                    view.marginStart, view.marginTop,
                    view.marginEnd, view.marginBottom
                )
            )
        }

        @JvmField
        val CREATOR = object : Parcelable.Creator<Margin> {
            override fun createFromParcel(parcel: Parcel) = Margin(parcel)

            override fun newArray(size: Int): Array<Margin?> = arrayOfNulls(size)
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