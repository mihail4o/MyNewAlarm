package com.balivo.mynewalarm

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.widget.Toast

class StandUP : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        Toast.makeText(context, "In Broadcast Receiver", Toast.LENGTH_SHORT).show()

        val myManager = NotificationManagerCompat.from(context)

        val myNoti = NotificationCompat.Builder(context)
        myNoti.setContentTitle("Stand Up Notification")
        myNoti.setContentText("You need to Stand Up!")
        myNoti.setSmallIcon(R.drawable.ic_notyf)

        val i1 = Intent(context, StandUpActivity::class.java)
        val pd = PendingIntent.getActivity(context,0, i1,0)
        myNoti.setContentIntent(pd)

        myNoti.setAutoCancel(true)

        myManager.notify(1, myNoti.build())
    }
}
