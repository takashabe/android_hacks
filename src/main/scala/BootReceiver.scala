package com.android.android_hacks

import _root_.android.app.Activity
import _root_.android.os.Bundle
import _root_.android.widget.Button
import _root_.android.view.View
import _root_.android.view.View.OnClickListener
import _root_.android.content.{Intent, BroadcastReceiver, Context}
import _root_.android.net.Uri

class BootReceiver extends BroadcastReceiver {
  override def onReceive(context: Context, rIntent: Intent) = {
    val intent: Intent = new Intent(context, classOf[IntentActivity])
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    context.startActivity(intent)
  }
}
