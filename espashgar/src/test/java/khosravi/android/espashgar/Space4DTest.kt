package khosravi.android.espashgar

import com.google.common.truth.Truth.assertThat
import khosravi.android.espashgar.space.Dp4d
import khosravi.android.espashgar.space.Px4d
import khosravi.android.espashgar.space.Space4D
import khosravi.android.espashgar.space.Value4d
import org.junit.Test

class Space4DTest {

    @Test
    fun `test isDp`() {
        val sut = createSutDp()
        assertIsDp(sut)
    }

    @Test
    fun `test isPx`() {
        val sut = createSutPx()
        assertIsPx(sut)
    }

    @Test
    fun `test dp changing toPx`() {
        val sut = createSutDp().toPx()
        assertIsPx(sut)
    }

    @Test
    fun `test px changing toDp`() {
        val sut = createSutPx().toDp()
        assertIsDp(sut)
    }

    @Test
    fun `test sum empty`() {
        val sut = createSutDp() + 12
        assertThat(sut.start).isEqualTo(12)
        assertThat(sut.top).isEqualTo(12)
        assertThat(sut.end).isEqualTo(12)
        assertThat(sut.bottom).isEqualTo(12)
    }

    @Test
    fun `test sum`() {
        val sut = createSutDp(1,2,3,4) + 12
        assertThat(sut.start).isEqualTo(13)
        assertThat(sut.top).isEqualTo(14)
        assertThat(sut.end).isEqualTo(15)
        assertThat(sut.bottom).isEqualTo(16)
    }

    @Test
    fun `test sumAssign`() {
        val sut = createSutDp(1,1,1,1)
        sut += 10
        assertThat(sut.start).isEqualTo(11)
        assertThat(sut.top).isEqualTo(11)
        assertThat(sut.end).isEqualTo(11)
        assertThat(sut.bottom).isEqualTo(11)
    }

    @Test
    fun `test minus empty`() {
        val sut = createSutDp() - 12
        assertThat(sut.start).isEqualTo(-12)
        assertThat(sut.top).isEqualTo(-12)
        assertThat(sut.end).isEqualTo(-12)
        assertThat(sut.bottom).isEqualTo(-12)
    }

    @Test
    fun `test minus`() {
        val sut = createSutDp(10,12,13,14) - 10
        assertThat(sut.start).isEqualTo(0)
        assertThat(sut.top).isEqualTo(2)
        assertThat(sut.end).isEqualTo(3)
        assertThat(sut.bottom).isEqualTo(4)
    }

    @Test
    fun `test minusAssign`() {
        val sut = createSutDp(10,10,10,10)
        sut -= 2
        assertThat(sut.start).isEqualTo(8)
        assertThat(sut.top).isEqualTo(8)
        assertThat(sut.end).isEqualTo(8)
        assertThat(sut.bottom).isEqualTo(8)
    }

    @Test
    fun `test times empty`() {
        val sut = createSutDp() * 12
        assertThat(sut.start).isEqualTo(0)
        assertThat(sut.top).isEqualTo(0)
        assertThat(sut.end).isEqualTo(0)
        assertThat(sut.bottom).isEqualTo(0)
    }

    @Test
    fun `test times`() {
        val sut = createSutDp(10,12,13,14) * 2
        assertThat(sut.start).isEqualTo(20)
        assertThat(sut.top).isEqualTo(24)
        assertThat(sut.end).isEqualTo(26)
        assertThat(sut.bottom).isEqualTo(28)
    }

    @Test
    fun `test timesAssign`() {
        val sut = createSutDp(10,10,10,10)
        sut *= 2
        assertThat(sut.start).isEqualTo(20)
        assertThat(sut.top).isEqualTo(20)
        assertThat(sut.end).isEqualTo(20)
        assertThat(sut.bottom).isEqualTo(20)
    }


    /////////////////
    //Utility section
    /////////////////
    private fun assertIsPx(sut: Space4D<*>) {
        assertThat(sut.isPx()).isTrue()
        assertThat(sut.isDp()).isFalse()
    }

    private fun assertIsDp(sut: Space4D<*>) {
        assertThat(sut.isDp()).isTrue()
        assertThat(sut.isPx()).isFalse()
    }

    private fun createSutDp(
        start: Int? = null,
        top: Int? = null,
        end: Int? = null,
        bottom: Int? = null
    ): Space4dFake {
        return Space4dFake(Dp4d(start, top, end, bottom))
    }

    private fun createSutPx(
        start: Int? = null,
        top: Int? = null,
        end: Int? = null,
        bottom: Int? = null
    ): Space4dFake {
        return Space4dFake(Px4d(start, top, end, bottom))
    }

    private class Space4dFake(override val mainValue: Value4d) : Space4D<Space4dFake>() {

        override fun createSelf(value4d: Value4d): Space4dFake {
            return Space4dFake(value4d)
        }

    }
}