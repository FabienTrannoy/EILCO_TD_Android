package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton = (Button) findViewById(R.id.roll_button);
        TextView rollText = (TextView) findViewById(R.id.roll_textView);
        TextView rollText2 = (TextView) findViewById(R.id.roll_textView_2);
        EditText rollEdit = findViewById(R.id.roll_edit);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast toast = Toast.makeText(MainActivity.this, "Dé lancé!", Toast.LENGTH_SHORT);
                toast.show();*/
                // Valeurs max et min du dé
                int min = 1, max = 6;
                if(!rollEdit.getText().toString().equals("")){
                    max = Integer.parseInt(rollEdit.getText().toString());
                }
                // Formule pour calculer la valeur du dé à partir de Math.random
                int rand1 = min + (int) (Math.random() * ((max - min) + 1));
                int rand2 = min + (int) (Math.random() * ((max - min) + 1));
                // Mise à jour du textview
                rollText.setText(String.valueOf(rand1));
                rollText2.setText(String.valueOf(rand2));

            }
        });

    }
}