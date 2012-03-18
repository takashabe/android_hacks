package com.android.android_hacks

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.view.View
import android.view.View.OnClickListener
import android.content.{SharedPreferences, Context}

class Hack11_MainActivity extends TypedActivity {
  private var pref1 = 100
  private var pref2 = "hoge"

  override def onCreate(savedInstanceBundle: Bundle) {
    super.onCreate(savedInstanceBundle)
    setContentView(R.layout.hack11_main)

    val textView = findView(TR.textView)
    val sp: SharedPreferences = getSharedPreferences("savePreferences", Context.MODE_PRIVATE)

    val saveButton = findView(TR.saveButton)
    saveButton.setOnClickListener(new OnClickListener() {
      override def onClick(view: View): Unit = {
        putPreference(sp)
        textView.setText("saved Prefences")
      }
    })

    val loadButton = findView(TR.loadButton)
    loadButton.setOnClickListener(new OnClickListener() {
      override def onClick(view: View): Unit = {
        textView.setText("load Prefences: " + getPreference(sp))
      }
    })
  }


  def putPreference(sp: SharedPreferences): Unit = {
    val editor: SharedPreferences.Editor = sp.edit()
    editor.putInt("id", pref1)
    editor.putString("name", pref2)
    editor.commit()
  }

  def getPreference(sp: SharedPreferences): String = {
    sp.getInt("id", -1)
    sp.getString("name", "None")
  }

  def rmPreference(sp: SharedPreferences): Unit = {
    val editor: SharedPreferences.Editor = sp.edit()
    editor.remove("id")
    editor.remove("name")
    editor.commit()
  }
}
