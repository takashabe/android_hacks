package com.android.android_hacks

import _root_.android.app.Activity
import _root_.android.os.Bundle
import _root_.android.widget.Button
import _root_.android.view.View
import _root_.android.view.View.OnClickListener
import _root_.android.content.Intent
import _root_.android.net.Uri

class FilterActivity extends Activity with TypedActivity {
  override def onCreate(savedInstanceState: Bundle) = {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.sublayout)
    val url: String = getIntent().getAction() == (Intent.ACTION_VIEW) match {
      case x if x == true => getIntent().getData().toString()
      case _ => "Not implicit intent"
    }
    val implicitText = findView(TR.implicitText)
    implicitText.setText(url)
  }
}
