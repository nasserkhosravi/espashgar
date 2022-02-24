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

    private fun assertIsPx(sut: Space4dFake) {
        assertThat(sut.isPx()).isTrue()
        assertThat(sut.isDp()).isFalse()
    }

    private fun assertIsDp(sut: Space4dFake) {
        assertThat(sut.isDp()).isTrue()
        assertThat(sut.isPx()).isFalse()
    }

    private fun createSutDp(): Space4dFake {
        return Space4dFake(Dp4d(null, null, null, null))
    }

    private fun createSutPx(): Space4dFake {
        return Space4dFake(Px4d(null, null, null, null))
    }

    private class Space4dFake(override val mainValue: Value4d) : Space4D<Space4dFake>() {

        override fun createSelf(value4d: Value4d): Space4dFake {
            return Space4dFake(value4d)
        }

    }
}