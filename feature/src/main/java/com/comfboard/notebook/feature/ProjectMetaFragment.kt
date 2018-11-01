package com.comfboard.notebook.feature

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import kotlinx.android.synthetic.main.fragment_project_meta.*
import java.util.*


private const val ARG_ID= "id"

class ProjectMetaFragment : Fragment() {
    var project: Project? = null

    lateinit var mView: View

    var id: String? = null

    var editTextTitle: EditText? = null
    var editTextDescription: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = arguments!!.getString(ARG_ID, UUID.randomUUID().toString())
        }
        project = ProjectLab.get(activity).getProject(UUID.fromString(id))

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.fragment_project_meta, container, false)
        return mView
    }


    companion object {
        @JvmStatic
        fun newInstance(id: String) =
            ProjectMetaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_ID, id)
                }
            }
    }
}
