package com.comfboard.notebook.feature

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private var mFm = supportFragmentManager
    private var mFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomBar = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomBar!!.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.new_project -> Toast.makeText(this@MainActivity, R.string.menu_new_project, Toast.LENGTH_SHORT).show()
            }
            false
        }

        mFragment = mFm.findFragmentById(R.id.fragmentContainer)
        if (mFragment == null) {
            mFragment = ProjectListFragment()
            mFm.beginTransaction()
                .add(R.id.fragmentContainer, this.mFragment as ProjectListFragment)
                .commit()

        // TODO: Подключить Toolbar
        // TODO: Подключить Фрагмент-
        // TODO: Подключить Меню
        // TODO: Переход в активность Пользователя-
        // TODO: Переход в активность Проекта-
    }

        //Меню создано
        fun onCreateOptionsMenu(menu: Menu): Boolean {
            menuInflater.inflate(R.menu.toolbar_user, menu)
            return true
        }

        ////Меню выбрано
        fun onOptionsItemSelected(item: MenuItem): Boolean {
            val action = item.itemId
            when (action) {
                R.id.user -> {
                    Toast.makeText(this@MainActivity, R.string.menu_user, Toast.LENGTH_SHORT).show()
                }
                else -> return false
            }
            return true
        }
    }
}
