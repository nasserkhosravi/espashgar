package khosravi.android.espashgar

import android.view.View
import khosravi.android.espashgar.space.Margin
import khosravi.android.espashgar.space.Padding
import org.junit.Test
import org.mockito.Mockito.*

class ExtTest {

    @Test
    fun test_applyOn_margin() {
        val margin = mock(Margin::class.java)
        val views = listOf(mock(View::class.java), mock(View::class.java))
        margin.applyOn(views)
        views.forEach {
            verify(margin).applyOn(it)
        }
    }

    @Test
    fun test_applyOn_padding() {
        val padding = mock(Padding::class.java)
        val views = listOf(mock(View::class.java), mock(View::class.java))
        padding.applyOn(views)
        views.forEach {
            verify(padding).applyOn(it)
        }
    }

}