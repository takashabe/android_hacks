package com.android.android_hacks

import _root_.android.app.Activity
import _root_.android.os.Bundle
import android.content.pm._
import android.widget._
import android.content._
import android.view.View._
import android.view._

class MainActivity extends Activity with TypedActivity {
  var mButton: Button = null
  var mIsSubActivityEnable: Boolean = false
  var mManager: PackageManager = null
  var mCname: ComponentName = null

  override def onCreate(bundle: Bundle) {
    super.onCreate(bundle)
    setContentView(R.layout.main)

    mButton = findView(TR.button01)
    mManager = getPackageManager()
    mCname = new ComponentName(this, SubActivity.getClass)
    mIsSubActivityEnable = !(mManager.getComponentEnabledSetting(mCname) == PackageManager.COMPONENT_ENABLED_STATE_DISABLED)
    setButtonText()
    mButton.setOnClickListener(new OnClickListener() {
      def onClick(v: View):Unit = {
        mIsSubActivityEnable match {
          case true => mManager.setComponentEnabledSetting(mCname, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP)
          case false => mManager.setComponentEnabledSetting(mCname, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP)
        }
        mIsSubActivityEnable = !mIsSubActivityEnable
        setButtonText()
      }
    })
  }

  def setButtonText():Unit = {
    mIsSubActivityEnable match {
      case true => mButton.setText("Disable SubActivity")
      case false => mButton.setText("Enable SubActivity")
    }
  }

}
