package khosravi.android.espashgar

import android.os.Parcel
import android.view.View
import com.google.common.truth.Truth.assertThat
import khosravi.android.espashgar.space.Margin
import khosravi.android.espashgar.space.Padding
import org.junit.Test
import org.mockito.Mockito.*

class ExtTest {

    @Test
    fun test_Margin_applyOn() {
        val margin = mock(Margin::class.java)
        val views = listOf(mock(View::class.java), mock(View::class.java))
        margin.applyOn(views)
        views.forEach {
            verify(margin).applyOn(it)
        }
    }

    @Test
    fun test_Padding_applyOn() {
        val padding = mock(Padding::class.java)
        val views = listOf(mock(View::class.java), mock(View::class.java))
        padding.applyOn(views)
        views.forEach {
            verify(padding).applyOn(it)
        }
    }

    @Test
    fun test_Parcel_readBool_1() {
        val mock = mock(Parcel::class.java)
        `when`(mock.readInt()).thenReturn(1)
        assertThat(mock.readBool()).isTrue()
    }

    @Test
    fun test_Parcel_readBool_0() {
        val mock = mock(Parcel::class.java)
        `when`(mock.readInt()).thenReturn(0)
        assertThat(mock.readBool()).isFalse()
    }

    @Test
    fun test_Parcel_readBool_else() {
        mock(Parcel::class.java).let { sut ->
            `when`(sut.readInt()).thenReturn(-1)
            assertThat(sut.readBool()).isNull()
        }

        mock(Parcel::class.java).let { sut ->
            `when`(sut.readInt()).thenReturn(2)
            assertThat(sut.readBool()).isNull()
        }
    }

    @Test
    fun test_Parcel_writeBool_true() {
        val parcel = mock(Parcel::class.java)
        parcel.writeBool(true)
        verify(parcel).writeInt(1)
    }

    @Test
    fun test_Parcel_writeBool_false() {
        val parcel = mock(Parcel::class.java)
        parcel.writeBool(false)
        verify(parcel).writeInt(0)
    }

    @Test
    fun test_Parcel_writeBool_null() {
        val parcel = mock(Parcel::class.java)
        parcel.writeBool(null)
        verify(parcel).writeInt(-1)
    }
}