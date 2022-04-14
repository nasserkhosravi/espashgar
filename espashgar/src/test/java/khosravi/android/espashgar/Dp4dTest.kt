package khosravi.android.espashgar

import android.content.Context
import android.util.TypedValue
import io.mockk.mockk
import io.mockk.verify
import khosravi.android.espashgar.space.Dp4d
import khosravi.android.espashgar.space.Px4d
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Dp4dTest {

    @Test
    fun test_toPixel() {
        val context = mockk<Context>(relaxed = true)
        val sut = sut(aInt(), aInt(), aInt(), aInt())
        sut.toPixel(context)
        verify { sut.start?.dpToPx(context) }
        verify { sut.end?.dpToPx(context) }
        verify { sut.top?.dpToPx(context) }
        verify { sut.bottom?.dpToPx(context) }
    }

    @Test
    fun test_typeCode() {
        assertThat(sut().typeCode()).isEqualTo(TypedValue.COMPLEX_UNIT_DIP)
    }

    @Test
    fun test_clone() {
        val sut = sut(aInt(), aInt(), aInt(), aInt())
        val cloned = sut.clone()
        assertThat(sut).isEqualTo(cloned)
        assertThat(sut !== cloned).isTrue
    }

    @Test
    fun test_equals_sameValuesWithDifferentType() {
        val dp4d = sut(aInt(), aInt(), aInt(), aInt())
        val px4d = Px4d(dp4d.start, dp4d.top, dp4d.end, dp4d.bottom)
        assertThat(dp4d).isNotEqualTo(px4d)
    }

    @Test
    fun test_equals_equalValues() {
        val a = sut()
        val b = sut(a.start, a.top, a.end, a.bottom)
        assertThat(a).isEqualTo(b)
    }

    private fun sut(
        start: Int? = null,
        top: Int? = null,
        end: Int? = null,
        bottom: Int? = null
    ) = Dp4d(start, top, end, bottom)

}