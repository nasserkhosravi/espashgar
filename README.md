
# Spashgar a dynamic spacer for Android

Spashgar is a **dynamic** spacer for Android That eases building, manipulating, converting, modeling **margin** and **padding**.  
Totally, padding and margin setting is easy in android but if you want do it in a managed manner, this library is for you, especially if you build your UI programmatically.  
Also this library has a beautiful syntax 😉.

    //Comprehensive builder-> Margin.dp() or Margin.px() val margin = marginDp().all(15)    .top(0)    
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
