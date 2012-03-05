package com.android.android_hacks

import android.app.Activity
import _root_.android.os.Bundle
import _root_.android.widget.Button
import _root_.android.view.View
import _root_.android.view.View.OnClickListener
import _root_.android.content.Intent
import _root_.android.net.Uri

class IntentActivity extends Activity with TypedActivity {
  private var explicitButton: Button = null
  private var implicitButton: Button = null

  override def onCreate(savedInstanceState: Bundle) = {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.intent)

    // 明示的intent
    this.explicitButton = findView(TR.Explicit)
    explicitButton.setOnClickListener(new OnClickListener() {
      override def onClick(arg0: View): Unit = {
        val intent: Intent = new Intent()
        intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity")
        startActivity(intent)
      }
    })

    // 暗黙的intent
    this.implicitButton = findView(TR.Implicit)
    implicitButton.setOnClickListener(new OnClickListener() {
      override def onClick(arg0: View): Unit = {
        val intent: Intent = new Intent()
        val uri: Uri = Uri.parse("http://google.com")
        intent.setAction(Intent.ACTION_VIEW)
        intent.setData(uri)
        startActivity(intent)
      }
    })
  }
}
