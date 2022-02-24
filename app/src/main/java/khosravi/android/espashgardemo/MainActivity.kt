package khosravi.android.espashgardemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import khosravi.android.espashgar.*
import khosravi.android.espashgar.space.Margin
import khosravi.android.espashgar.space.Padding
import khosravi.android.espashgardemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))

        setContentView(R.layout.activity_main)
        val view = binding.button
        val view2 = binding.button2

        //Comprehensive builder-> Margin.dp() or Margin.px()
        val margin = marginDp().all(15)
            .top(0)
            .vertical(20)
            .divideVertical(10)
            .build()

        //Apply and reuse margin
        margin.applyOn(view, view2)

        //Convert between px and dp
        val pixelMargin = margin.toPx()

        //Pass between android component as parcelable
        Bundle().putParcelable("margin", margin)

        //get margin of view
        val marginOfView = view.getMargin().applyOn(view2)

        //Do basic math operation such plus, minus, times
        val doubledMargin = view.getMargin() * 2

        //Support rtl control (default is true)
        margin.isRtlAware = false

        //all above features are available with same syntax for Padding
        Padding.dp()
            .horizontal(20)
            .applyOn(view2)
    }
}