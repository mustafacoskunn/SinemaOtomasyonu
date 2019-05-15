package ornek.uygulama.com.sinemaotomation.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import ornek.uygulama.com.sinemaotomation.objects.Film_seans;
import ornek.uygulama.com.sinemaotomation.objects.Filmler;
import ornek.uygulama.com.sinemaotomation.objects.Seans;

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

    public ArrayList<Seans> filmSeansi(sinemaDao vt,int filmid){
        ArrayList<Seans> seanslarArray=new ArrayList<>(); //bu listeye atıcaz verileri
        SQLiteDatabase db=vt.getWritableDatabase(); // yazma yetkisi
        Cursor c=db.rawQuery("SELECT * FROM film_seans  inner JOIN seans ON film_seans.seans_id=seans.seans_id WHERE film_id="+filmid,null); //satır satır filmleri getir

        while (c.moveToNext()){// kaç satır veri geldiyse o kadar çalış

            Seans seans=new Seans(c.getInt(c.getColumnIndex("seans_id")),c.getString(c.getColumnIndex("seans_saati")));


            seanslarArray.add(seans);
        }
        return seanslarArray;
    }

}
