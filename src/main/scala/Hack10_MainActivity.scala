package com.android.android_hacks

import android.app.{Activity, AlertDialog, Dialog, DatePickerDialog}
import android.os.Bundle
import android.content.DialogInterface
import android.widget.{Button, EditText, DatePicker}
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
        val datePickerDialog: DatePickerDialog =
          new DatePickerDialog(Hack10_MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            def onDateSet(view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int): Unit =
              mResultText.setText("%04d/%02d/%02d".format(year, monthOfYear+1, dayOfMonth))
          }, 2012, 3, 12)
        datePickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = mResultText.setText("DatePickerDialog Canceled.")
          })
        datePickerDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = mResultText.setText("DatePickerDialog OK.")
          })
        datePickerDialog.show()
      }
    })
    mResultText = findView(TR.textResult)
  }
}
