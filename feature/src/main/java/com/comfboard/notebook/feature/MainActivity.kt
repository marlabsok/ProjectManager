package com.comfboard.notebook.feature

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private var mToolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mToolbar = findViewById<Toolbar>(R.id.toolbar)
//        setActionBar(mToolbar)

        var bottomBar = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomBar!!.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.new_project -> Toast.makeText(this@MainActivity, R.string.menu_new_project, Toast.LENGTH_SHORT).show()
                }
                return false
            }

        })

        // TODO: Подключить Toolbar
        // TODO: Подключить Фрагмент-
        // TODO: Подключить Меню
        // TODO: Переход в активность Пользователя-
        // TODO: Переход в активность Проекта-
    }

    //Меню создано
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_user, menu)
        return true
    }

    ////Меню выбрано
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val action = item.itemId
        when (action) {
            R.id.user -> {
                Toast.makeText(this, R.string.menu_user, Toast.LENGTH_SHORT).show()
            }
            else -> return false
        }
        return true
    }
}
