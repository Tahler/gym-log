package me.tyborg.gymlog.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import me.tyborg.gymlog.R;

/**
 * Created by Tyler Berry on 8/16/2015.
 */
public class CreateSession extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_session);

        Intent intent = getIntent();
        if (intent != null) {
            getActionBar().setTitle(intent.getStringExtra("title"));
        }
    }
}
