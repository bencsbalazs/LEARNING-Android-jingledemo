package com.example.jingle_demo.model;

import android.widget.LinearLayout;

import java.util.List;

public class User implements Cloneable {
    public String first_name;
    public  int age;
    public String job;
    public String company;
    public List<Photo> photos;

    public static User clone(final User from){
        try {
            return (User) from.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
    }
}
