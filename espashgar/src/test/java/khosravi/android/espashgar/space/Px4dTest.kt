package khosravi.android.espashgar.space

import android.content.Context
import android.util.TypedValue
import io.mockk.mockk
import io.mockk.verify
import khosravi.android.espashgar.aInt
import khosravi.android.espashgar.pxToDp
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Px4dTest {

    @Test
    fun test_pxToDp() {
        val context = mockk<Context>(relaxed = true)
        val sut = sut(aInt(), aInt(), aInt(), aInt())
        sut.toDp(context)
        verify { sut.start?.pxToDp(context) }
        verify { sut.end?.pxToDp(context) }
        verify { sut.top?.pxToDp(context) }
        verify { sut.bottom?.pxToDp(context) }
    }

    @Test
    fun test_typeCode() {
        assertThat(sut().typeCode()).isEqualTo(TypedValue.COMPLEX_UNIT_PX)
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
        val px4d = sut(aInt(), aInt(), aInt(), aInt())
        val dp4d = Dp4d(px4d.start, px4d.top, px4d.end, px4d.bottom)
        assertThat(px4d).isNotEqualTo(dp4d)
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
    ) = Px4d(start, top, end, bottom)

}