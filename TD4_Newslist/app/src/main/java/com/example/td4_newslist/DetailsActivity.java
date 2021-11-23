package com.example.td4_newslist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setTitle(getLocalClassName());

        Button buttonOk = findViewById(R.id.button_ok);
        TextView textViewName = findViewById(R.id.textView_name);

        // récupérer le contexte d'application et la donnée qu'elle contient
        NewsListApplication app = (NewsListApplication) getApplicationContext();
        String login = app.getLogin();
        textViewName.setText(login);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go back a newsActivity
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
