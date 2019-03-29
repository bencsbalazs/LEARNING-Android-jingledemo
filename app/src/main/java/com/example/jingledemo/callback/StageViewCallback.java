package com.example.jingledemo.callback;

import com.example.jingledemo.model.User;

import java.util.List;

public interface StageViewCallback {
    public void populateUser(final List<User> users);
}
