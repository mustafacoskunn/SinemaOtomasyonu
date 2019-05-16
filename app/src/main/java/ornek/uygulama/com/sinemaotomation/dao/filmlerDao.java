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
        Cursor c=db.rawQuery("select * from salon inner join salon_seans on salon.salon_id=salon_seans.salon_id INNER join seans on salon_seans.seans_id=seans.seans_id where film_id="+filmid,null); //satır satır filmleri getir

        while (c.moveToNext()){// kaç satır veri geldiyse o kadar çalış

            Seans seans=new Seans(c.getInt(c.getColumnIndex("seans_id")),c.getString(c.getColumnIndex("seans_saati")),c.getString(c.getColumnIndex("salon_adi")));


            seanslarArray.add(seans);
        }
        return seanslarArray;
    }

}
