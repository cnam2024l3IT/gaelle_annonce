package com.example.annonce;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListAnnoncesActivity extends AppCompatActivity {
    private AnnonceDBHelper dbHelper;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_annonces);
        dbHelper = new AnnonceDBHelper(this);
        listView = findViewById(R.id.listView);
        // ceci est un test

        Cursor cursor = dbHelper.getAllAnnonces();

        String[] from = {AnnonceDBHelper.COL_TITLE, AnnonceDBHelper.COL_PRICE, AnnonceDBHelper.COL_DESCRIPTION};
        int[] to = {R.id.titleTextView, R.id.priceTextView, R.id.descriptionTextView};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.annonce_list_item, cursor, from, to, 0);
        listView.setAdapter(adapter);


    }

}