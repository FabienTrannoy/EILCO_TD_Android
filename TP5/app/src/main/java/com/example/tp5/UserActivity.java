package com.example.tp5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    List<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = findViewById(R.id.rvContacts);

        // Initialisation des contacts
        contacts.add(new Contact("Ulfric", "Sombrage", "https://static.wikia.nocookie.net/elderscrolls/images/e/ee/Ulfric_Jarl.png/revision/latest/scale-to-width-down/600?cb=20121021223811"));
        contacts.add(new Contact("Général", "Tullius", "https://static.wikia.nocookie.net/elderscrolls/images/3/3e/GeneralTullius.png/revision/latest/scale-to-width-down/600?cb=20121209224339"));
        contacts.add(new Contact("Balgruuf", "le Grand", "https://static.wikia.nocookie.net/elderscrolls/images/a/ae/Jarl_Balgruuf_the_Greater.png/revision/latest/scale-to-width-down/660?cb=20121021003036"));
        contacts.add(new Contact("Elisif", "la Juste", "https://static.wikia.nocookie.net/elderscrolls/images/0/05/Elisif_the_Fair.png/revision/latest/scale-to-width-down/599?cb=20121022231351"));
        contacts.add(new Contact("Maven", "Roncenoir", "https://static.wikia.nocookie.net/elderscrolls/images/f/f4/Maven.png/revision/latest?cb=20120914002028"));
        contacts.add(new Contact("Alduin", "Le Dévoreur de Mondes", "https://static.wikia.nocookie.net/elderscrolls/images/7/7f/Alduin_over_Helgen.png/revision/latest/scale-to-width-down/1000?cb=20120810223011"));
        contacts.add(new Contact("Kodlak", "Blancrin", "https://static.wikia.nocookie.net/elderscrolls/images/6/6d/Kodlak_Whitemane.png/revision/latest/scale-to-width-down/600?cb=20191017011205"));
        contacts.add(new Contact("M'aiq", "le menteur", "https://static.wikia.nocookie.net/elderscrolls/images/b/b0/M%27aiqTheLiarCC.png/revision/latest/scale-to-width-down/600?cb=20141123223333"));
        contacts.add(new Contact("Titus", "Mede II", "https://static.wikia.nocookie.net/elderscrolls/images/b/b2/TESV_Emperor.png/revision/latest/scale-to-width-down/288?cb=20120106060800"));

        // Création d'un adapter avec initialisation du constructeur avec notre liste de contacts
        ContactAdapter adapter = new ContactAdapter(contacts);
        // On notifie au recyclerview notre adapter
        rvContacts.setAdapter(adapter);
        // On déclare quelle type de LayoutManager on désire
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
    }
}