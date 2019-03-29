package com.example.jingledemo.service;

import android.content.Context;

import com.example.jingledemo.asynctask.StageAsyncTask;
import com.example.jingledemo.callback.StageServiceCallback;
import com.example.jingledemo.callback.StageViewCallback;
import com.example.jingledemo.constants.Constants;
import com.example.jingledemo.model.User;
import com.example.jingledemo.repository.ConfigurationRepository;
import com.example.jingledemo.repository.UserRepository;
import com.example.jingledemo.utils.TimeUtil;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;

public class StageService implements StageServiceCallback {

    ConfigurationRepository configurationRepository;
    UserRepository userRepository;

    StageAsyncTask downloadUserListTask;

    StageViewCallback callback;

    public void setCallback(@NotNull StageViewCallback callback) {
        this.callback = callback;
    }

    public StageService(final Context context) {
        this.downloadUserListTask = new StageAsyncTask();
        this.userRepository = new UserRepository(context);
        this.configurationRepository = new ConfigurationRepository(context);
    }

    public void getUserList() {
        final Date savedDownloadDate = configurationRepository.getDownloadDate();
        if (TimeUtil.isOlderThanFiveMins(savedDownloadDate)) {
            downloadUserListTask.setCallback(this);
            downloadUserListTask.execute(Constants.STAGE_URL);
        } else {
            userRepository.getAllUsers(this);
        }
    }

    public void loadUsers() {
        downloadUserListTask.setCallback(this);
        downloadUserListTask.execute(Constants.STAGE_URL);
    }

    @Override
    public void downloadSuccess(List<User> users) {
        callback.populateUser(users);
        userRepository.clearUsers();
        userRepository.saveUsers(users);
        configurationRepository.saveDownloadDate(new Date());
    }

    @Override
    public void repositoryLoadSuccess(List<User> users) {
        callback.populateUser(users);
    }
}
