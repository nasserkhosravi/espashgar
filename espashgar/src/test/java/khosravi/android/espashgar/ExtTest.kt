package khosravi.android.espashgar

import android.os.Parcel
import android.view.View
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import khosravi.android.espashgar.space.Margin
import khosravi.android.espashgar.space.Padding
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ExtTest {

    @Test
    fun test_Margin_applyOn() {
        val margin = mockk<Margin>(relaxed = true)
        val views = listOf(mockk<View>(), mockk())
        margin.applyOn(views)
        views.forEach {
            verify { margin.applyOn(it) }
        }
    }

    @Test
    fun test_Padding_applyOn() {
        val padding = mockk<Padding>(relaxed = true)
        val views = listOf(mockk<View>(), mockk())
        padding.applyOn(views)
        views.forEach {
            verify { padding.applyOn(it) }
        }
    }

    @Test
    fun test_Parcel_readBool_1() {
        val parcel = mockk<Parcel>()
        every { parcel.readInt() } returns 1
        assertThat(parcel.readBool()).isTrue
    }

    @Test
    fun test_Parcel_readBool_0() {
        val parcel = mockk<Parcel>()
        every { parcel.readInt() } returns 0
        assertThat(parcel.readBool()).isFalse
    }

    @Test
    fun test_Parcel_readBool_else() {
        mockk<Parcel>().let { sut ->
            every { sut.readInt() } returns -1
            assertThat(sut.readBool()).isNull()
        }

        mockk<Parcel>().let { sut ->
            every { sut.readInt() } returns 2
            assertThat(sut.readBool()).isNull()
        }
    }

    @Test
    fun test_Parcel_writeBool_true() {
        val parcel = mockk<Parcel>(relaxed = true)
        parcel.writeBool(true)
        verify { parcel.writeInt(1) }
    }

    @Test
    fun test_Parcel_writeBool_false() {
        val parcel = mockk<Parcel>(relaxed = true)
        parcel.writeBool(false)
        verify { parcel.writeInt(0) }
    }

    @Test
    fun test_Parcel_writeBool_null() {
        val parcel = mockk<Parcel>(relaxed = true)
        parcel.writeBool(null)
        verify { parcel.writeInt(-1) }
    }
}