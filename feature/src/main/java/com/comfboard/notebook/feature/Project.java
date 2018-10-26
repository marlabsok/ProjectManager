package com.comfboard.notebook.feature;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Project {

    /*-------------------------Поля-------------------------*/

    private UUID mId;               //id
    private String mTitle;          //Название
    private String mDescription;    //Описание
    private List<String> mTag;      //Тег
    private int mColor;              //цвет
    private Date mDate;             //Дата
    private List<UUID> mUsers;     //Участник
    /*---------------------Конструткоры---------------------*/

    //			По умолчанию
    public Project(UUID id) {
        this.mId 		    = id;
    }

    //			Настраиваемый
    public Project() {
        this.mId 		    = UUID.randomUUID();

    }

    /*----------------------Свойства-----------------------*/

    //____________________Id____________________//
    public UUID getId() {
        return this.mId;
    }

    //____________________Title_________________//
    public String getTitle() {
        return this.mTitle;
    }
    public void setTitle(String title) {
        this.mTitle = title;
    }

    //____________________Description_________________//
    public String getDescription() {
        return this.mDescription;
    }
    public void setDescription(String description) {
        this.mDescription = description;
    }

    //____________________Tag_________________//
    public List<String> getTag() {
        return this.mTag;
    }

    //____________________Users_________________//
    public List<UUID> getUsers() {
        return this.mUsers;
    }

    //____________________Color__________________//
    public int getColor(){
        return this.mColor;
    }
    public void setColor(int сolor) {
        this.mColor = сolor;
    }

    //____________________Date__________________//
    public Date getDate(){
        return this.mDate;
    }

    public void setDate(){
        this.mDate = new Date();
    }
    /*--------------------Методы--------------------*/

}
