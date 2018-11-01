package com.comfboard.notebook.feature

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.*


private const val ARG_ID= "id"

class ProjectMetaFragment : Fragment() {
    var project: Project? = null

    var id: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = arguments!!.getString(ARG_ID, UUID.randomUUID().toString())
        }
        project = ProjectLab.get(activity).getProject(UUID.fromString(id))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_project_meta, container, false)
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
