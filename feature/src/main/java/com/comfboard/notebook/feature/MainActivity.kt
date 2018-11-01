package com.comfboard.notebook.feature

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import java.util.*

class MainActivity : AppCompatActivity() {

    private var mFm = supportFragmentManager
    private var mFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomBar = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomBar!!.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.new_project -> {
                    val project : Project = Project()
                    intent = newIntent(this@MainActivity, project.id)
                    startActivity(intent)
                    Toast.makeText(this@MainActivity, R.string.menu_new_project, Toast.LENGTH_SHORT).show()
                }
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
        // TODO: Подключить Меню
        // TODO: Переход в активность Проекта
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

    companion object {
        val EXTRA_LIST_ID = "com.comfboard.android.lists.list_id"

        fun newIntent(packageContext: Context, id: UUID): Intent {
            val intent = Intent(packageContext, ProjectActivity::class.java)
            intent.putExtra(EXTRA_LIST_ID, id.toString())
            return intent
        }
    }
}
