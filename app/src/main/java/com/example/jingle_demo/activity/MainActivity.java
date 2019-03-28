package com.example.jingle_demo.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jingle_demo.R;
import com.example.jingle_demo.model.Photo;
import com.example.jingle_demo.model.User;
import com.example.jingle_demo.widget.UserDetailsView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserDetailsView userDetailsView = (UserDetailsView) findViewById(R.id.udv_user_details);

        User user = getMockUser();

        userDetailsView.setUser(user);
    }

    private User getMockUser() {
        User user = new User();

        user.photos = getMockPhotos();
        user.first_name = "Janka";
        user.age = 21;

        user.job = "HR asszisztens";
        user.company="HRP Group Kft.";

        return user;
    }

    private ArrayList<Photo> getMockPhotos() {
        Photo coverPhoto = new Photo();
        Photo photo1 = new Photo();
        Photo photo2 = new Photo();
        Photo photo3 = new Photo();

        Bitmap bitmapCover = BitmapFactory.decodeResource(getResources(), R.drawable.cover_photo);
        coverPhoto.setBitmap(bitmapCover);
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.photo1);
        photo1.setBitmap(bitmap1);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.photo2);
        photo2.setBitmap(bitmap2);
        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.photo3);
        photo3.setBitmap(bitmap3);
        Photo[] photos = new Photo[] {coverPhoto, photo1, photo2, photo3};
        return new ArrayList<>(Arrays.asList(photos));
    }
}
