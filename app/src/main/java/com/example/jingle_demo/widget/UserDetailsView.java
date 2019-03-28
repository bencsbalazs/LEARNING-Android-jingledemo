package com.example.jingle_demo.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.jingle_demo.R;
import com.example.jingle_demo.model.Photo;
import com.example.jingle_demo.model.User;

import java.util.List;

public class UserDetailsView extends ScrollView {
    private UserPhotoView coverPhoto;
    private UserPhotoView photo1;
    private UserPhotoView photo2;
    private UserPhotoView photo3;

    private TextView nameText;
    private TextView jobText;

    private User user;

    public UserDetailsView(Context context) {
        super(context);
        init(context);
    }

    public UserDetailsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public UserDetailsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(final Context context) {
        setFillViewport(true);
        setVerticalScrollBarEnabled(false);
        setOverScrollMode(OVER_SCROLL_NEVER);

        View.inflate(context, R.layout.user_details_view, this);

        coverPhoto = (UserPhotoView) findViewById(R.id.upv_user_details_cover);
        photo1 = (UserPhotoView) findViewById(R.id.upv_user_details_photo_1);
        photo2 = (UserPhotoView) findViewById(R.id.upv_user_details_photo_2);
        photo3 = (UserPhotoView) findViewById(R.id.upv_user_details_photo_3);

        nameText = (TextView) findViewById(R.id.tv_user_details_name);
        jobText = (TextView) findViewById(R.id.tv_user_datails_job);
    }

    public void setCoverPhoto(Photo photo) {
            coverPhoto.setType(UserPhotoView.TYPE_COVER);
            coverPhoto.setPhoto(photo);
    }

    public void setNormalPhoto(Photo photo, UserPhotoView userPhotoView) {
        userPhotoView.setType(UserPhotoView.TYPE_NORMAL);
        userPhotoView.setPhoto(photo);
    }

    public void setPhotos(List<Photo> photos) {
        Photo coverPhoto = photos.get(0);
        Photo photo1 = photos.get(1);
        Photo photo2 = photos.get(2);
        Photo photo3 = photos.get(3);

        setCoverPhoto(coverPhoto);
        setNormalPhoto(photo1, this.photo1);
        setNormalPhoto(photo2, this.photo2);
        setNormalPhoto(photo3, this.photo3);
    }

    public void setUser(final User user) {
        this.user = user;

        setPhotos(user.photos);
        setNameAge(user.first_name, user.age);
        setJob(user.job, user.company);
    }

    private void setJob(String job, String company) {
        StringBuilder jobText = new StringBuilder();
        jobText.append(job)
                .append(" @")
                .append(company);
        this.jobText.setText(jobText);
    }

    private void setNameAge(String first_name, int age) {
        final SpannableStringBuilder nameBuilder = new SpannableStringBuilder(first_name);
        nameBuilder.append(", ");
        nameBuilder.setSpan(new StyleSpan(Typeface.BOLD), 0, nameBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        nameBuilder.append(Integer.toString(age));
        this.nameText.setText(nameBuilder);
    }
}
