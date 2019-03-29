package com.example.jingledemo.model;

import com.google.gson.annotations.SerializedName;

public class UserTag implements Cloneable {
    @SerializedName("id")
    public String id;
    @SerializedName("name")
    public String name;

    public static UserTag clone(final UserTag from) {
        try {
            return (UserTag) from.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
