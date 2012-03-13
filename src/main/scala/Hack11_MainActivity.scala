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
  lazy val sp:SharedPreferences = getSharedPreferences("savePreferences", Context.MODE_PRIVATE)

  override def onCreate(savedInstanceBundle: Bundle) {
    super.onCreate(savedInstanceBundle)
    setContentView(R.layout.hack11_main)

    val textView = findView(TR.textView)

    val saveButton = findView(TR.saveButton)
    saveButton.setOnClickListener(new OnClickListener() {
      override def onClick(view: View): Unit = {
        putPreference()
        textView.setText("saved Prefences")
      }
    })

    val loadButton = findView(TR.loadButton)
    loadButton.setOnClickListener(new OnClickListener() {
      override def onClick(view: View): Unit = {
        // getPreference()
        textView.setText("load Prefences" + getPreference())
      }
    })
  }



  def putPreference(): Unit = {
    // sp = getSharedPreferences("key", Context.MODE_PRIVATE)
    val editor: SharedPreferences.Editor = sp.edit()
    editor.putInt("id", pref1)
    editor.putString("name", pref2)
    editor.commit()
  }

  def getPreference(): String = {
    // sp = getSharedPreferences("key", Context.MODE_PRIVATE)
    sp.getInt("id", -1)
    sp.getString("name", "None")
  }

  def rmPreference(): Unit = {
    val editor: SharedPreferences.Editor = sp.edit()
    editor.remove("id")
    editor.remove("name")
    editor.commit()
  }
}
