package com.example.td4_newslist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NewsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setTitle(getLocalClassName());

        Intent intent = getIntent();
        String login = "NOM";
        if (intent.hasExtra("login")) {
            login = intent.getStringExtra("login");
        }


        Button buttonDetails = findViewById(R.id.button_details);
        Button buttonLogout = findViewById(R.id.button_logout);
        Button buttonAbout = findViewById(R.id.button_about);
        TextView textViewNom = findViewById(R.id.textView_nom);

        textViewNom.setText("Bonjour " + login);

        buttonDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go details activity
                Intent intent = new Intent(NewsActivity.this, DetailsActivity.class);
                startActivity(intent);
            }
        });

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // retour a login activity
                Intent intent = new Intent(NewsActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


        buttonAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://news.google.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
