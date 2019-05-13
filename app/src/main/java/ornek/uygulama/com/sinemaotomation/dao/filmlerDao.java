package ornek.uygulama.com.sinemaotomation.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import ornek.uygulama.com.sinemaotomation.objects.Filmler;

public class filmlerDao {
    public ArrayList<Filmler> tumFilmler(sinemaDao vt){
        ArrayList<Filmler> tumFilmlerArrayList=new ArrayList<>(); //bu listeye atıcaz verileri
        SQLiteDatabase db=vt.getWritableDatabase(); // yazma yetkisi
        Cursor c=db.rawQuery("Select * From filmler",null); //satır satır filmleri getir

        while (c.moveToNext()){// kaç satır veri geldiyse o kadar çalış
            Filmler filmler=new Filmler(c.getInt(c.getColumnIndex("film_id")),c.getString(c.getColumnIndex("film_adi")),c.getString(c.getColumnIndex("film_resim")));

            tumFilmlerArrayList.add(filmler);
        }
        return tumFilmlerArrayList;
    }
}
