package khosravi.android.espashgar.space

import android.content.Context
import android.util.TypedValue
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import khosravi.android.espashgar.aDp4d
import khosravi.android.espashgar.aPx4d
import khosravi.android.espashgar.aValue4d
import org.assertj.core.api.Assertions.assertThat
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.lang.IllegalArgumentException
import kotlin.Int

@RunWith(RobolectricTestRunner::class)
class Space4DTest {

    @Test
    fun test_isDp() {
        val sut = createSutDp()
        assertIsDp(sut)
    }

    @Test
    fun test_isPx() {
        val sut = createSutPx()
        assertIsPx(sut)
    }

    @Test
    fun test_toDp_changingFromPx() {
        val sut = createSutPx(1, 1, 1, 1).toDp()
        assertIsDp(sut)
    }

    @Test
    fun test_toPx_changingFromDp() {
        val sut = createSutDp().toPx()
        assertIsPx(sut)
    }

    @Test
    fun test_sum_empty() {
        val sut = createSutDp() + 12
        assertThat(sut.start).isEqualTo(12)
        assertThat(sut.top).isEqualTo(12)
        assertThat(sut.end).isEqualTo(12)
        assertThat(sut.bottom).isEqualTo(12)
    }

    @Test
    fun test_sum() {
        val sut = createSutDp(1, 2, 3, 4) + 12
        assertThat(sut.start).isEqualTo(13)
        assertThat(sut.top).isEqualTo(14)
        assertThat(sut.end).isEqualTo(15)
        assertThat(sut.bottom).isEqualTo(16)
    }

    @Test
    fun test_sumAssign() {
        val sut = createSutDp(1, 1, 1, 1)
        sut += 10
        assertThat(sut.start).isEqualTo(11)
        assertThat(sut.top).isEqualTo(11)
        assertThat(sut.end).isEqualTo(11)
        assertThat(sut.bottom).isEqualTo(11)
    }

    @Test
    fun test_minus_empty() {
        val sut = createSutDp() - 12
        assertThat(sut.start).isEqualTo(-12)
        assertThat(sut.top).isEqualTo(-12)
        assertThat(sut.end).isEqualTo(-12)
        assertThat(sut.bottom).isEqualTo(-12)
    }

    @Test
    fun test_minus() {
        val sut = createSutDp(10, 12, 13, 14) - 10
        assertThat(sut.start).isEqualTo(0)
        assertThat(sut.top).isEqualTo(2)
        assertThat(sut.end).isEqualTo(3)
        assertThat(sut.bottom).isEqualTo(4)
    }

    @Test
    fun test_minusAssign() {
        val sut = createSutDp(10, 10, 10, 10)
        sut -= 2
        assertThat(sut.start).isEqualTo(8)
        assertThat(sut.top).isEqualTo(8)
        assertThat(sut.end).isEqualTo(8)
        assertThat(sut.bottom).isEqualTo(8)
    }

    @Test
    fun test_times_empty() {
        val sut = createSutDp() * 12
        assertThat(sut.start).isEqualTo(0)
        assertThat(sut.top).isEqualTo(0)
        assertThat(sut.end).isEqualTo(0)
        assertThat(sut.bottom).isEqualTo(0)
    }

    @Test
    fun test_times() {
        val sut = createSutDp(10, 12, 13, 14) * 2
        assertThat(sut.start).isEqualTo(20)
        assertThat(sut.top).isEqualTo(24)
        assertThat(sut.end).isEqualTo(26)
        assertThat(sut.bottom).isEqualTo(28)
    }

    @Test
    fun test_timesAssign() {
        val sut = createSutDp(10, 10, 10, 10)
        sut *= 2
        assertThat(sut.start).isEqualTo(20)
        assertThat(sut.top).isEqualTo(20)
        assertThat(sut.end).isEqualTo(20)
        assertThat(sut.bottom).isEqualTo(20)
    }

    @Test
    fun test_equals_sameTypeSameValue() {
        val a = createSutDp(10, 20, 0, 4)
        val b = createSutDp(10, 20, 0, 4)
        assertThat(a).isEqualTo(b)
    }

    @Test
    fun test_equals_differenceTypeBySameValue() {
        val a = createSutDp(1, 1, 1, 1)
        val b = createSutPx(1, 1, 1, 1)
        assertThat(a).isNotEqualTo(b)
    }

    @Test
    fun test_equals_valueDifference() {
        val a = createSutDp(1, 1, 1, 1)
        val b = createSutDp(1, 1, 2, 1)
        assertThat(a).isNotEqualTo(b)
    }

    @Test
    fun test_equals_sameReference() {
        val a = createSutDp(1, 1, 1, 1)
        val b = a
        assertThat(a).isEqualTo(b)
    }

    @Test
    fun test_createValue4dByType_dp() {
        val type = TypedValue.COMPLEX_UNIT_DIP
        val actual = Space4D.createValue4dByType(type, 1, 2, 3, 4)
        assertThat(actual).isInstanceOf(Dp4d::class.java)
    }

    @Test
    fun test_createValue4dByType_px() {
        val type = TypedValue.COMPLEX_UNIT_PX
        val actual = Space4D.createValue4dByType(type, 1, 2, 3, 4)
        assertThat(actual).isInstanceOf(Px4d::class.java)
    }

    @Test
    fun test_createValue4dByType_values() {
        val type = TypedValue.COMPLEX_UNIT_PX
        val actual = Space4D.createValue4dByType(type, 1, 2, 3, 4)
        assertThat(actual.start).isEqualTo(1)
        assertThat(actual.top).isEqualTo(2)
        assertThat(actual.end).isEqualTo(3)
        assertThat(actual.bottom).isEqualTo(4)
    }

    @Test
    fun test_createValue4dByType_unsupportedType() {
        assertThrows(IllegalArgumentException::class.java) {
            val unsupportedType = TypedValue.COMPLEX_UNIT_PT
            Space4D.createValue4dByType(unsupportedType, 1, 2, 3, 4)
        }
    }

    @Test
    fun test_getPreparedValueInPx_when_pxValueIsNull() {
        val sutDp = createSutDp()

        val pxValue = sutDp.getPreparedValueInPx(mockk(relaxed = true))
        assertThat(pxValue).isInstanceOf(Px4d::class.java)
    }

    @Test
    fun test_getPreparedValueInPx_whenCalledTwice_returnReferenceMustBeSame() {
        val context = mockk<Context>(relaxed = true)
        val sutDp = createSutDp()

        val pxValue1 = sutDp.getPreparedValueInPx(context)
        val pxValue2 = sutDp.getPreparedValueInPx(context)

        assertTrue(pxValue1 === pxValue2)
    }

    @Test
    fun test_vertical() {
        val actual = createSutDp(0, 8, 0, 2)
        assertThat(actual.vertical).isEqualTo(10)
    }

    @Test
    fun test_vertical_bothNull() {
        val actual = createSutDp(0, null, 0, null)
        assertThat(actual.vertical).isEqualTo(null)
    }

    @Test
    fun test_vertical_oneNull() {
        val actual = createSutDp(0, 8, 0, null)
        assertThat(actual.vertical).isEqualTo(8)
    }

    @Test
    fun test_horizontal() {
        val actual = createSutDp(4, 0, 8, 0)
        assertThat(actual.horizontal).isEqualTo(12)
    }

    @Test
    fun test_horizontal_bothNull() {
        val actual = createSutDp(null, 2, null, 2)
        assertThat(actual.horizontal).isEqualTo(null)
    }

    @Test
    fun test_horizontal_oneNull() {
        val actual = createSutDp(null, null, 10, null)
        assertThat(actual.horizontal).isEqualTo(10)
    }

    /////////////////
    //Utility section
    /////////////////
    private fun assertIsPx(sut: Space4D<*>) {
        assertThat(sut.isPx()).isTrue
        assertThat(sut.isDp()).isFalse
    }

    private fun assertIsDp(sut: Space4D<*>) {
        assertThat(sut.isDp()).isTrue
        assertThat(sut.isPx()).isFalse
    }

    private fun createSutDp(
        start: Int? = null,
        top: Int? = null,
        end: Int? = null,
        bottom: Int? = null
    ): Space4dFake {
        return Space4dFake(aDp4d(start, top, end, bottom))
    }

    private fun createSutPx(
        start: Int? = null,
        top: Int? = null,
        end: Int? = null,
        bottom: Int? = null
    ): Space4dFake {
        return Space4dFake(aPx4d(start, top, end, bottom))
    }

    private class Space4dFake(override val mainValue: Value4d) : Space4D<Space4dFake>() {

        override fun createSelf(value4d: Value4d): Space4dFake {
            return Space4dFake(value4d)
        }

    }
}