package ornek.uygulama.com.sinemaotomation.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import ornek.uygulama.com.sinemaotomation.objects.Film_seans;
import ornek.uygulama.com.sinemaotomation.objects.Filmler;
import ornek.uygulama.com.sinemaotomation.objects.Koltuk;
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
    public ArrayList<Koltuk> tumKoltuklar(sinemaDao vt){
        ArrayList<Koltuk> tumKoltuklar=new ArrayList<>(); //bu listeye atıcaz verileri
        SQLiteDatabase db=vt.getWritableDatabase(); // yazma yetkisi
        Cursor c=db.rawQuery("Select * From koltuk",null); //satır satır filmleri getir

        while (c.moveToNext()){// kaç satır veri geldiyse o kadar çalış
            Koltuk koltuk=new Koltuk(c.getInt(c.getColumnIndex("koltuk_id")),c.getInt(c.getColumnIndex("salon_id")),c.getString(c.getColumnIndex("koltuk_harf")),c.getInt(c.getColumnIndex("koltuk_rakam")));

            tumKoltuklar.add(koltuk);
        }
        return tumKoltuklar;
    }

    public ArrayList<Seans> filmSeansi(sinemaDao vt,int filmid){
        ArrayList<Seans> seanslarArray=new ArrayList<>(); //bu listeye atıcaz verileri
        SQLiteDatabase db=vt.getWritableDatabase(); // yazma yetkisi
        Cursor c=db.rawQuery("select * from salon inner join salon_seans on salon.salon_id=salon_seans.salon_id INNER join seans on salon_seans.seans_id=seans.seans_id where film_id="+filmid+ "",null); //satır satır filmleri getir

        while (c.moveToNext()){// kaç satır veri geldiyse o kadar çalış

            Seans seans=new Seans(c.getInt(c.getColumnIndex("seans_id")),c.getString(c.getColumnIndex("seans_saati")),c.getString(c.getColumnIndex("salon_adi")),c.getInt(c.getColumnIndex("salon_id")));


            seanslarArray.add(seans);
        }
        return seanslarArray;
    }

    public void filmSil(sinemaDao vt,int film_id){
        SQLiteDatabase db = vt.getWritableDatabase();
        db.delete("filmler","film_id=?",new String[]{String.valueOf(film_id)});
        db.close();
    }
    public void filmGuncelle(sinemaDao vt,int film_id,String film_ad,String film_resim){
        SQLiteDatabase db = vt.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("film_adi",film_ad);
        values.put("film_resim",film_resim);

        db.update("filmler",values,"film_id=?",new String[]{String.valueOf(film_id)});
        db.close();

    }
    public void filmEkle(sinemaDao vt,String film_adi,String film_resim){
        SQLiteDatabase db = vt.getWritableDatabase();

        ContentValues values = new ContentValues();


        values.put("film_adi",film_adi);
        values.put("film_resim",film_resim);
        db.insertOrThrow("filmler",null,values);
        db.close();

    }
    public void salonekle(sinemaDao vt,String salon_adi,int film_id){
        SQLiteDatabase db = vt.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("salon_adi",salon_adi);
        values.put("film_id",film_id);


        db.insertOrThrow("salon",null,values);
        db.close();






    }
    public void senasEkle(sinemaDao vt,int seans_id){
        SQLiteDatabase db = vt.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("salon_id",1);
        values.put("seans_id",seans_id);


        db.insertOrThrow("salon_seans",null,values);
        db.close();


    }





}
