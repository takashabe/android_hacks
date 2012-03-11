package com.android.android_hacks

import android.app.{Activity, AlertDialog, Dialog}
import android.os.Bundle
import android.content.DialogInterface
import android.widget.{Button, EditText}
import android.view.View
import android.view.View.OnClickListener

class Hack10_MainActivity extends TypedActivity {
  private var mResultText: EditText = null
  private var mDialog: Dialog = null

  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.hack10_main)
    val button: Button = findView(TR.AlertDialogButtonOk)
    button.setOnClickListener(new OnClickListener() {
      override def onClick(view: View): Unit = {
        mDialog = new Dialog(Hack10_MainActivity.this)
        mDialog.setContentView(R.layout.dialog_ok)
        mDialog.setTitle("Dialog with OK")
        mDialog.findViewById(R.id.ButtonOK).setOnClickListener(new OnClickListener() {
          override def onClick(view: View): Unit = {
            mDialog.dismiss()
            mResultText.setText("Dialog [OK] pressed")
          }
        })
        mDialog.show
      }
    })
    mResultText = findView(TR.textResult)
  }
}
