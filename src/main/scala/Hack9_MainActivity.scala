package com.android.android_hacks

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.view.View
import android.view.View.OnClickListener

class Hack9_MainActivity extends TypedActivity {
  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.hack9_main)
    // val button01: Button = findView(TR.button01)
    // button01.setOnClickListener(new OnClickListener() {
      // override def onClick(view: View): Unit = view match {
          // case x: Button => x.setText("Clicked")
          // case _ =>
      // }
    // })
  }

  def button02ClickHandler(view: View): Unit = view match {
    case x: Button => x.setText("Button02 Clicked")
    case _ =>
  }
}
