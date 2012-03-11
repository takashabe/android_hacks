package com.android.android_hacks

import android.app.{Activity, AlertDialog}
import android.os.Bundle
import android.content.DialogInterface
import android.widget.{Button, EditText}
import android.view.View
import android.view.View.OnClickListener

class Hack10_MainActivity extends TypedActivity {
  private var mResultText: EditText = null

  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.hack10_main)
    val button: Button = findView(TR.AlertDialogButtonOk)
    button.setOnClickListener(new OnClickListener() {
      override def onClick(view: View): Unit = {
        val DIALOG_ITEM: Array[java.lang.CharSequence] = Array("one", "two", "three", "four")
        new AlertDialog.Builder(Hack10_MainActivity.this)
            .setTitle("Alert Dialog Ok")
            .setItems(DIALOG_ITEM, new DialogInterface.OnClickListener() {
                override def onClick(dialog: DialogInterface, which: Int): Unit = mResultText.setText(DIALOG_ITEM(which))
              })
            // .setMessage("Alert Dialog with OK Button only.")
            // .setPositiveButton("OK", new DialogInterface.OnClickListener() {
              // override def onClick(dialog: DialogInterface, which: Int): Unit = mResultText.setText("Alert Dialog [OK] pressed")
              // })
            // .setNegativeButton("Negative", new DialogInterface.OnClickListener() {
                // override def onClick(dialog: DialogInterface, which: Int): Unit = mResultText.setText("Alert Dialog [Negative] pressed")
              // })
            // .setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                // override def onClick(dialog: DialogInterface, which: Int): Unit = mResultText.setText("Alert Dialog [Neutral] pressed")
              // })
              .create()
              .show()
            }
          })
      mResultText = findView(TR.textResult)
    }
}
