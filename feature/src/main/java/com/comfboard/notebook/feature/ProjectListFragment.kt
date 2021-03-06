package com.comfboard.notebook.feature

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class ProjectListFragment : Fragment() {

    private var mRecyclerViewItems: RecyclerView? = null
    private var mAdapter: ProjectAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val mView = inflater.inflate(R.layout.fragment_project_list, container, false)

        this.mRecyclerViewItems = mView!!.findViewById<View>(R.id.recyclerView) as RecyclerView
        this.mRecyclerViewItems!!.layoutManager = LinearLayoutManager(this.activity)

        updateUI()

        return mView
    }

    //Holder
    private inner class ProjectHolder(itemView: View): RecyclerView.ViewHolder(itemView),
        View.OnClickListener,
        View.OnLongClickListener{

        val mTextViewTitle: TextView = itemView.findViewById<View>(R.id.tv_name) as TextView

        var project: Project? = null
        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(v: View) {
            Toast.makeText(activity, "Click", Toast.LENGTH_LONG).show()
            val intent = MainActivity.newIntent(context!!.applicationContext, project!!.id)
            startActivity(intent)
        }

        override fun onLongClick(v: View?): Boolean {
            Toast.makeText(activity, "Long Click", Toast.LENGTH_LONG).show()
            return true
        }
    }

    //Адаптор
    private inner class ProjectAdapter(private val mProjects: List<Project>) :
        RecyclerView.Adapter<ProjectHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectHolder {
            val layoutInflater = LayoutInflater.from(activity)
            val view = layoutInflater.inflate(R.layout.project, parent, false)

            return ProjectHolder(view)
        }

        override fun onBindViewHolder(holder: ProjectHolder, position: Int) {
            holder.project = mProjects[position]

            holder.mTextViewTitle.text = holder.project!!.title
        }

        override fun getItemCount(): Int {
            return mProjects.size
        }
    }

    private fun updateUI() {
        val projectLab = ProjectLab.get(activity)
        val projects = projectLab.projects
        this.mAdapter = ProjectAdapter(projects)
        this.mRecyclerViewItems!!.adapter = this.mAdapter

        if (mAdapter == null) {
            mAdapter = ProjectAdapter(projects)
            mRecyclerViewItems!!.adapter = mAdapter
        } else {
            mAdapter!!.notifyDataSetChanged()
        }
    }
}
