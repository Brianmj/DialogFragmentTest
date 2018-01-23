package com.example.brianmj.dialogfragmenttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm: FragmentManager = supportFragmentManager
        var container = fm.findFragmentById(R.id.fragment_container)

        if(container == null) {
            container = RealFragment()
            fm.beginTransaction()
                    .add(R.id.fragment_container, container)
                    .commit()
        }
    }
}
