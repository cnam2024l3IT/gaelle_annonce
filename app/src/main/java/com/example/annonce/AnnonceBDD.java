package com.example.annonce;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;

public class AnnonceBDD {
    private SQLiteDatabase db = null;
    private AnnonceDBHelper annonceDBHelper = null;

    public AnnonceBDD(Context context){
        // créé la BDD et sa table
        annonceDBHelper = new AnnonceDBHelper(context);
    }
    public void open(){
        // ouvre la BDD en ecriture
        if (db == null)
            db = annonceDBHelper.getWritableDatabase();
    }
    public void close(){
        if (db != null && db.isOpen())
            db.close();
    }
    public SQLiteDatabase getBdd(){
        return db;
    }
    public boolean insererAnnonce(Annonce annonce){ // mettre public boolean insererAnnonce
        ContentValues values = new ContentValues();
        long res; // on peut le laisser comma ça car c'est un type de base donc il ne retournera pas de null

        //values.put(AnnonceDBHelper.COL_ID, annonce.getId());
        values.put(AnnonceDBHelper.COL_TITLE, annonce.getTitle());
        values.put(AnnonceDBHelper.COL_DESCRIPTION, annonce.getDescription());
        values.put(AnnonceDBHelper.COL_PRICE, annonce.getPrice());

        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd'HH:mm:ss");
        values.put(AnnonceDBHelper.COL_DATE_DE_CREATION, sdf.format(annonce.getDateDeCreation()));
        values.put(AnnonceDBHelper.COL_DATE_DE_MODIFICATION, sdf.format(annonce.getDateDeModification()));
        values.put(AnnonceDBHelper.COL_DATE_DE_FIN_DE_PUBLICATION, sdf.format(annonce.getDateDeFinDePublication()));
        values.put(AnnonceDBHelper.COL_DATE_DE_PUBLICATION, sdf.format(annonce.getDateDePublication()));

        res = db.insert(AnnonceDBHelper.TABLE_ANNONCE, null, values);
        if(res > -1) {
            return true;
    }else{
            return false;
        }
    }

}
// il faut instancier cette classe avec DBHelper
