package com.example.brianmj.dialogfragmenttest

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.widget.TimePicker

/**
 * Created by brianmj on 1/21/18.
 */
class TimePickerFragment : DialogFragment()
{

    companion object {
        val EXTRA_TIME = "EXTRA_TIME"
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // use context, NOT context.applicationContext. You'll get an error about Activity not running yet
        val layout = LayoutInflater.from(context).inflate(R.layout.dialog_time_layout, null)

        val timePicker = layout.findViewById<TimePicker>(R.id.dialog_time_picker)
        timePicker.hour = 15
        timePicker.minute = 44
        timePicker.setIs24HourView(true)

        return AlertDialog.Builder(activity)
                .setView(layout)
                .setTitle(R.string.pick_time)
                .setPositiveButton(android.R.string.ok, object : DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        val hour = timePicker.hour
                        val minute = timePicker.minute

                        val myTime = MyTime(hour, minute)
                        if(targetFragment == null){

                        }else{
                            val i = Intent()
                            i.putExtra(EXTRA_TIME, myTime)
                            targetFragment.onActivityResult(targetRequestCode, Activity.RESULT_OK, i)
                        }

                    }
                })
                .create()
    }
}