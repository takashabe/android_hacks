package com.android.android_hacks

import android.app.{Activity, Dialog, ProgressDialog}
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.{Bundle, Handler, Message}
import android.content.DialogInterface
import android.widget.{Button, EditText, TimePicker}
import android.view.View
import android.view.View.OnClickListener

class Hack10_MainActivity extends TypedActivity {
  private var mResultText: EditText = null
  private var mProgressDialog: ProgressDialog = null
  private var mProgress: Int = 0
  private var mProgressHandler: Handler = null

  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.hack10_main)
    val button = findView(TR.AlertDialogButtonOk)
    button.setOnClickListener(new OnClickListener() {
      override def onClick(view: View): Unit = {
        mProgressDialog = new ProgressDialog(Hack10_MainActivity.this)
        mProgressDialog.setTitle("My Progress Dialog")
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
        mProgressDialog.setMax(100)
        mProgressDialog.setButton("OK", new DialogInterface.OnClickListener() {
          override def onClick(dialog: DialogInterface, whichButton: Int): Unit = mResultText.setText("ProgressDialog Dialog [OK] pressed at " + mProgress + "%")
        })
        mProgressDialog.setButton2("Cancel", new DialogInterface.OnClickListener() {
          override def onClick(dialog: DialogInterface, whichButton: Int): Unit = mResultText.setText("ProgressDialog Dialog [Cancel] pressed at " + mProgress + "%")
        })
        mProgress = 0
        mProgressDialog.show()
        mProgressDialog.setProgress(0)
        mProgressHandler.sendEmptyMessage(0)
      }
    })

    mResultText = findView(TR.textResult)
    mProgressHandler = new Handler {
      override def handleMessage(msg: Message) {
        super.handleMessage(msg)
        mProgress match {
          case x if x >= 100 => {
            mProgressDialog.dismiss()
            mResultText.setText("Progress Dialog finished " + mProgress + "%")
          }
          case _ => {
            mProgress += 1
            mProgressDialog.incrementProgressBy(1)
            mProgressHandler.sendEmptyMessageDelayed(0, 100)
          }
        }
      }
    }
  }
}
