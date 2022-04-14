package khosravi.android.espashgar.space

import junit.framework.Assert.assertTrue
import khosravi.android.espashgar.aInt
import khosravi.android.espashgar.aValue4d
import org.junit.Test

class Builder4dTest {

    @Test
    fun test_every() {
        val sut = sut()
        val start = aInt()
        val top = aInt()
        val end = aInt()
        val bottom = aInt()
        sut.every(start, top, end, bottom)
        assertTrue(sut.getValue().start == start)
        assertTrue(sut.getValue().top == top)
        assertTrue(sut.getValue().end == end)
        assertTrue(sut.getValue().bottom == bottom)
    }

    @Test
    fun test_all() {
        val sut = sut()
        val value = aInt()
        sut.all(value)

        assertTrue(sut.getValue().start == value)
        assertTrue(sut.getValue().end == value)
        assertTrue(sut.getValue().top == value)
        assertTrue(sut.getValue().bottom == value)
    }

    @Test
    fun test_side() {
        val sut = sut()
        val horizontal = aInt()
        val vertical = aInt()
        sut.side(horizontal, vertical)

        assertHorizontal(sut, horizontal)
        assertVertical(sut, vertical)
    }

    @Test
    fun test_horizontal() {
        val sut = sut()
        val horizontal = aInt()
        sut.horizontal(horizontal)
        assertHorizontal(sut, horizontal)
    }

    @Test
    fun test_vertical() {
        val sut = sut()
        val vertical = aInt()
        sut.vertical(vertical)
        assertVertical(sut, vertical)
    }

    @Test
    fun test_divideHorizontal() {
        val sut = sut()
        val horizontal = aInt()
        sut.divideHorizontal(horizontal)
        assertHorizontal(sut, horizontal / 2)
    }

    @Test
    fun test_divideVertical() {
        val sut = sut()
        val vertical = aInt()
        sut.divideVertical(vertical)
        assertVertical(sut, vertical / 2)
    }


    @Test
    fun test_start() {
        val sut = sut()
        val value = aInt()
        sut.start(value)
        assertTrue(sut.getValue().start == value)
    }

    @Test
    fun test_end() {
        val sut = sut()
        val value = aInt()
        sut.end(value)
        assertTrue(sut.getValue().end == value)
    }

    @Test
    fun test_bottom() {
        val sut = sut()
        val value = aInt()
        sut.bottom(value)
        assertTrue(sut.getValue().bottom == value)
    }

    @Test
    fun test_top() {
        val sut = sut()
        val value = aInt()
        sut.top(value)
        assertTrue(sut.getValue().top == value)
    }

    private fun assertHorizontal(sut: Builder4dFake, horizontal: Int) {
        assertTrue(sut.getValue().start == horizontal)
        assertTrue(sut.getValue().end == horizontal)
    }

    private fun assertVertical(sut: Builder4dFake, vertical: Int) {
        assertTrue(sut.getValue().top == vertical)
        assertTrue(sut.getValue().bottom == vertical)
    }

    private fun sut(
        start: Int? = null, top: Int? = null, end: Int? = null, bottom: Int? = null
    ): Builder4dFake {
        val value = aValue4d(start, top, end, bottom)
        return Builder4dFake(value)
    }

    private class Builder4dFake constructor(value: Value4d) : Builder4d<Builder4dFake>(value)
}