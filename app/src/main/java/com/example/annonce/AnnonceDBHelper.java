package com.example.annonce;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.*;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.content.ContentValues;
import android.database.Cursor;

import androidx.annotation.Nullable;

public class AnnonceDBHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "Annonce.db";
    public static final int DATABASE_VERSION = 1; //au depart on met version=1 et on change la version des qu'on decide de modifier quelque chose dans la table donc on change
    public static final String TABLE_ANNONCE = "Annonce";
    public static final String COL_TITLE ="title";
    public static final String COL_PRICE ="price";
    public static final String COL_DESCRIPTION = "description";
    public static final String COL_DATE_DE_PUBLICATION ="dateDePublication";
    public static final String COL_DATE_DE_FIN_DE_PUBLICATION ="dateDeFinDePublication";
    public static final String COL_DATE_DE_CREATION ="dateDeCreation";
    public static final String COL_DATE_DE_MODIFICATION = "dateDeModification";



    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_ANNONCE + "("
            //+ COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_TITLE + " TEXT,"
            + COL_PRICE + " INTEGER,"
            + COL_DESCRIPTION + " TEXT,"
            + COL_DATE_DE_PUBLICATION + " TEXT," // sqlite ne supporte pas localdatetime donc on met du text
            + COL_DATE_DE_FIN_DE_PUBLICATION + " TEXT,"
            + COL_DATE_DE_CREATION + " TEXT,"
            + COL_DATE_DE_MODIFICATION + " TEXT);";
    // faire un constructeur // constructor
    //public AnnonceDBHelper(@Nullable Context context, @Nullable String name); // a completer
    public AnnonceDBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //On creer la table
        String CREATE_TABLE = "CREATE TABLE " + TABLE_ANNONCE + " ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COL_TITLE + " TEXT,"
                + COL_PRICE + " INTEGER,"
                + COL_DESCRIPTION + " TEXT,"
                + COL_DATE_DE_PUBLICATION + " TEXT,"
                + COL_DATE_DE_FIN_DE_PUBLICATION + " TEXT,"
                + COL_DATE_DE_CREATION + " TEXT,"
                + COL_DATE_DE_MODIFICATION + " TEXT)";
        db.execSQL(CREATE_TABLE);
    }
    //creer une premiere annonce avec contentvalues

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // on supprime la table au depart puis on la recrée

        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_ANNONCE + ";");
        Log.d("Onupgrade", "base de donne dsupprimée et recréée" + db);
        onCreate(db);
    }


    // Méthode pour insérer une annonce
    public long insererAnnonce(String title, int price, String description, String dateDePublication, String dateDeFinDePublication, String dateDeCreation, String dateDeModification) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_TITLE, title);
        values.put(COL_PRICE, price);
        values.put(COL_DESCRIPTION, description);
        values.put(COL_DATE_DE_PUBLICATION, dateDePublication);
        values.put(COL_DATE_DE_FIN_DE_PUBLICATION, dateDeFinDePublication);
        values.put(COL_DATE_DE_CREATION, dateDeCreation);
        values.put(COL_DATE_DE_MODIFICATION, dateDeModification);

        long newRowId = db.insert(TABLE_ANNONCE, null, values);
        db.close();
        return newRowId;
    }

    // Méthode pour récupérer toutes les annonces
    public Cursor getAllAnnonces() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_ANNONCE, null, null, null, null, null, null);
    }
}
// recuperer toute les lignes dune table
// insérer en base de donnée 2 ou 3 annonce et faire auto increment et faire un select et
// stocker toute les données dans un objet qui sappelle cursor : j'ai besoin dun curseur pour ma méthode select