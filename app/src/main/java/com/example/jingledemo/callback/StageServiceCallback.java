package com.example.jingledemo.callback;

import com.example.jingledemo.model.User;

import java.util.List;

public interface StageServiceCallback {
    public void downloadSuccess(List<User> users);
    public void repositoryLoadSuccess(final List<User> users);
}
