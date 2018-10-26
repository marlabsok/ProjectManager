package com.comfboard.notebook.feature

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class ProjectActivity : AppCompatActivity() {

    private var mFm = supportFragmentManager
    private var mFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project)

        val bottomBar = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomBar!!.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.meta -> Toast.makeText(this@ProjectActivity, R.string.menu_new_project, Toast.LENGTH_SHORT).show()
            }
            false
        }

        mFragment = mFm.findFragmentById(R.id.fragmentContainer)
        if (mFragment == null) {
            mFragment = ProjectListFragment()
            mFm.beginTransaction()
                .add(R.id.fragmentContainer, this.mFragment as ProjectListFragment)
                .commit()
        }
    }
}
