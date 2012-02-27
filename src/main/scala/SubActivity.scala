package com.android.android_hacks

import _root_.android.app.Activity
import _root_.android.os.Bundle

object SubActivity extends Activity with TypedActivity {
  override def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.sub)
  }
}
