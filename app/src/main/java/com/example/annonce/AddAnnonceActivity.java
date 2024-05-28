package com.example.annonce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDateTime;

public class AddAnnonceActivity extends AppCompatActivity {
    private AnnonceDBHelper dbHelper;
    private EditText titleEditText, priceEditText, descriptionEditText, dateDePublicationEditText, dateDeFinDePublicationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_annonce);

        dbHelper = new AnnonceDBHelper(this);

        titleEditText = findViewById(R.id.titleEditText);
        priceEditText = findViewById(R.id.priceEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        dateDePublicationEditText = findViewById(R.id.dateDePublicationEditText);
        dateDeFinDePublicationEditText = findViewById(R.id.dateDeFinDePublicationEditText);
        Button addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                int price = Integer.parseInt(priceEditText.getText().toString());
                String description = descriptionEditText.getText().toString();
                String dateDePublication = dateDePublicationEditText.getText().toString();
                String dateDeFinDePublication = dateDeFinDePublicationEditText.getText().toString();
                String dateDeCreation = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    dateDeCreation = LocalDateTime.now().toString();
                }
                String dateDeModification = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    dateDeModification = LocalDateTime.now().toString();
                }

                long result = dbHelper.insererAnnonce(title, price, description, dateDePublication, dateDeFinDePublication, dateDeCreation, dateDeModification);

                if (result > -1) {
                    Toast.makeText(AddAnnonceActivity.this, "Annonce ajoutée avec succès!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddAnnonceActivity.this, "Erreur lors de l'ajout de l'annonce.", Toast.LENGTH_SHORT).show();
                }

                // Rediriger vers l'activité qui affiche la liste des annonces
                Intent intent = new Intent(AddAnnonceActivity.this, ListAnnoncesActivity.class);
                startActivity(intent);
            }
        });
    }
}
