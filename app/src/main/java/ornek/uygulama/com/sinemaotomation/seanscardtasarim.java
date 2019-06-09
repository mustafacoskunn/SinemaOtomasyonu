package ornek.uygulama.com.sinemaotomation;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import ornek.uygulama.com.sinemaotomation.adapter.seansAdapter;
import ornek.uygulama.com.sinemaotomation.dao.sinemaDao;
import ornek.uygulama.com.sinemaotomation.objects.Filmler;
import ornek.uygulama.com.sinemaotomation.objects.Seans;

public class seanscardtasarim extends AppCompatActivity {
    private Seans seans;
    private sinemaDao vt;

    private  Filmler filmler;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seanscardtasarim);


        seans= (Seans) getIntent().getSerializableExtra("seans");
        textView.setText(seans.getSalon_adi());
        System.out.println("bilgi"+seans.getSeans_id());
        vt =  new sinemaDao(this);




        filmler= (Filmler) getIntent().getSerializableExtra("filmbilgi");

        SQLiteDatabase db=vt.getWritableDatabase(); // yazma yetkisi


        Cursor c=db.rawQuery("SELECT * from salon where film_id="+filmler.getFilm_id(),null); //satır satır filmleri getir

        while (c.moveToNext()){// kaç satır veri geldiyse o kadar çalış

            Seans seans=new Seans(c.getInt(c.getColumnIndex("seans_id")),c.getString(c.getColumnIndex("seans_saati")),c.getString(c.getColumnIndex("salon_adi")),c.getInt(c.getColumnIndex("salon_id")));

            System.out.println("girdi");
            textView.setText(seans.getSalon_adi());
        }


    }
}
