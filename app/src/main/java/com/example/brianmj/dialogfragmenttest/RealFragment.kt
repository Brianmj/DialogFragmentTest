package com.example.brianmj.dialogfragmenttest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import java.sql.Time

/**
 * Created by brianmj on 1/21/18.
 */
class RealFragment : Fragment() {

    companion object {
        val DIALOG_TIME = "DialogTime"
        val REQUEST_CODE = 5
    }

    lateinit var buttonTime: Button
    lateinit var textView: TextView
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var vw = inflater?.inflate(R.layout.fragment_real_layout, container, false)

        buttonTime = vw?.findViewById<Button>(R.id.button_show_time)!!
        textView = vw?.findViewById<TextView>(R.id.text_show_time)!!

        buttonTime?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                val manager = fragmentManager
                val timePickerDialog = TimePickerFragment()
                timePickerDialog.setTargetFragment(this@RealFragment, REQUEST_CODE)
                timePickerDialog.show(manager, DIALOG_TIME)
            }
        })

        return vw
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == REQUEST_CODE){

                val myDate = data?.getSerializableExtra(TimePickerFragment.EXTRA_TIME) as MyTime
                val dispString = "${myDate.hour}: ${myDate.minute}"
                textView.text = dispString

            }
        }
    }
}