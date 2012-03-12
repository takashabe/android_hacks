package com.android.android_hacks

import android.app.{Activity, AlertDialog, Dialog, TimePickerDialog}
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import android.content.DialogInterface
import android.widget.{Button, EditText, TimePicker}
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
        val timePickerDialog: TimePickerDialog = new TimePickerDialog(Hack10_MainActivity.this, new OnTimeSetListener() {
          override def onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int): Unit = mResultText.setText("%02d:%02d".format(hourOfDay, minute))
        }, 0, 0, true)
      timePickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE
        , "Cancel"
        , new DialogInterface.OnClickListener() {
          override def onClick(dialog: DialogInterface, which: Int): Unit =
            mResultText.setText("TimePickerDialog Canceled")
          })
        timePickerDialog.show()
      }
    })
    mResultText = findView(TR.textResult)
  }
}
