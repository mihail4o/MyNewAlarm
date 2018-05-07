package com.balivo.mynewalarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var myAlarmManager : AlarmManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myAlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
    }

    fun startSomething(view:View) {

        Toast.makeText(this, "Alarm Started", Toast.LENGTH_SHORT).show()

        val i1 = Intent()
        i1.setAction("com.balivo.mynew.alarm.MESSAGE_1")
        i1.addCategory("android.intent.category.DEFAULT")

        val pd = PendingIntent.getBroadcast(this, 0, i1, 0)
        myAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 30, pd)
    }

    fun stopSomething(view:View) {
        val i1 = Intent()
        i1.setAction("com.balivo.mynew.alarm.MESSAGE_1")
        i1.addCategory("android.intent.category.DEFAULT")

        val pd = PendingIntent.getBroadcast(this, 0, i1, 0)
        myAlarmManager.cancel(pd)

        Toast.makeText(this, "Alarm Stopped", Toast.LENGTH_SHORT).show()
    }
}
