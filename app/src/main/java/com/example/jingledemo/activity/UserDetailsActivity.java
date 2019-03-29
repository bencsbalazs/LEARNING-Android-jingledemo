package com.example.jingledemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jingledemo.R;
import com.example.jingledemo.model.User;
import com.example.jingledemo.widget.UserDetailsView;

import org.parceler.Parcels;

public class UserDetailsActivity extends AppCompatActivity {

    private static final String EXTRA_USER = "extra.user";

    public static void startActivity(final Context context, final User user) {
        Intent intent = new Intent(context, UserDetailsActivity.class);
        intent.putExtra(EXTRA_USER, Parcels.wrap(user));
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        setTitle(getString(R.string.details_title));

        UserDetailsView userDetailsView = (UserDetailsView) findViewById(R.id.udv_user_details);

        final Intent intent = getIntent();
        final User user = Parcels.unwrap(intent.getParcelableExtra(EXTRA_USER));
        if (user == null) {
            finish();
            return;
        }

        userDetailsView.setUser(user);
    }
}
