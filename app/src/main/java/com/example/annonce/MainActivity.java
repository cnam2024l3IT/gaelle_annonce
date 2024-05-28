package com.example.annonce;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDateTime;

public class MainActivity extends AppCompatActivity {

    private AnnonceDBHelper dbHelper;
    private EditText titleEditText, priceEditText, descriptionEditText;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new AnnonceDBHelper(this);
        //c=this;
        //ListAnnoncesActivity = new ArrayList<>();
        //cursor = dbHelper.getAllAnnonces("Annonce");

        titleEditText = findViewById(R.id.editTextText2);
        priceEditText = findViewById(R.id.editTextText3);
        descriptionEditText = findViewById(R.id.editTextText);
        Button insertButton = findViewById(R.id.button);
        Button addAnnonceButton = findViewById(R.id.buttonAddAnnonce);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                int price = Integer.parseInt(priceEditText.getText().toString());
                String description = descriptionEditText.getText().toString();
                String dateDePublication = LocalDateTime.now().toString();
                String dateDeFinDePublication = LocalDateTime.now().toString();
                String dateDeCreation = LocalDateTime.now().toString();
                String dateDeModification = LocalDateTime.now().toString();

                long result = dbHelper.insererAnnonce(title, price, description, dateDePublication, dateDeFinDePublication, dateDeCreation, dateDeModification);

                if (result > -1) {
                    Toast.makeText(MainActivity.this, "Annonce ajoutée avec succès!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Erreur lors de l'ajout de l'annonce.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        addAnnonceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddAnnonceActivity.class);
                startActivity(intent);
            }
        });
    }
}


// inserer une personne a linterieure : nom/prenom
//combien dannonce elle a cette personne
// pour personne il faut simuler des join

// créer uné méthode qui prend une annonce en paramètre et ça nous insère directement dans la database.
// créer une activité avec des widget (pour un titre, pour prix, description)
//tout en bas ajouter un bouton et quand on clique sur le bouton l'annonce s'insère dans la database.