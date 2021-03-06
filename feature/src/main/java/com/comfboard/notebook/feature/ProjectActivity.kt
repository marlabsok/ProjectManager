package com.comfboard.notebook.feature

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import java.util.*

class ProjectActivity : AppCompatActivity() {

    private var mFm = supportFragmentManager
    private var mFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project)

        val bundle = intent.extras

        val mId = UUID.fromString(bundle.getString(MainActivity.EXTRA_PROJECT_ID)).toString()

        val bottomBar = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        mFragment = mFm.findFragmentById(R.id.fragmentContainer)
        if (mFragment == null) {
            mFragment = ProjectMetaFragment.newInstance(mId)
            mFm.beginTransaction()
                .add(R.id.fragmentContainer, this.mFragment as ProjectMetaFragment)
                .commit()
        }

        bottomBar!!.setOnNavigationItemSelectedListener { item ->

            when(item.itemId){
                R.id.meta -> {
                    Toast.makeText(this@ProjectActivity, R.string.menu_meta, Toast.LENGTH_SHORT).show()
                }
                R.id.todo -> {
                    Toast.makeText(this@ProjectActivity, R.string.menu_todo, Toast.LENGTH_SHORT).show()
                }
                R.id.note ->{
                    Toast.makeText(this@ProjectActivity, R.string.menu_note, Toast.LENGTH_SHORT).show()
                }
            }
            false
        }

    }


}
