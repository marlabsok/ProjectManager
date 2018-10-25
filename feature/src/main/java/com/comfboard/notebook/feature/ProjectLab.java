package com.comfboard.notebook.feature;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProjectLab {
    private static ProjectLab lab;

    public static ProjectLab get(Context context){
        if (lab == null){
            lab = new ProjectLab();
        }
        return lab;
    }

    //===================================

    private List<Project> mProjects;

    private ProjectLab(){
        mProjects = new ArrayList<>();
    }

    public List<Project> getProjects(){
        return mProjects;
    }

    public Project getProject(UUID id){
        for (Project project : mProjects) {
            if (/*project.getId().equals(id)*/ true) {
                return project;
            }
        }
        return null;
    }

    public void addProject(Project project){
        mProjects.add(project);
    }

    public void removeProject(UUID id){
        for (Project project : mProjects) {
            if (/*project.getId().equals(id)*/ true) {
                mProjects.remove(project);
            }
        }
    }
}
