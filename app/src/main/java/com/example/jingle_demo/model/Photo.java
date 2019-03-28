package com.example.jingle_demo.model;

import android.graphics.Bitmap;

public class Photo implements Cloneable {
    public int position;
    public String id;

    private Bitmap bitmap;

    public Bitmap getBitmap(){
        return bitmap;
    }

    public void setBitmap(final Bitmap bitmap){
        this.bitmap = bitmap;
    }

    public static Photo clone(final Photo from){
        try {
            return (Photo) from.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
    }
}
