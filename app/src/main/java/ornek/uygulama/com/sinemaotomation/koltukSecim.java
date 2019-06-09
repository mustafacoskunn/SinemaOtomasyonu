package ornek.uygulama.com.sinemaotomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import ornek.uygulama.com.sinemaotomation.adapter.koltukAdapter;
import ornek.uygulama.com.sinemaotomation.adapter.seansAdapter;
import ornek.uygulama.com.sinemaotomation.dao.DatabaseCopyHelper;
import ornek.uygulama.com.sinemaotomation.dao.filmlerDao;
import ornek.uygulama.com.sinemaotomation.dao.sinemaDao;
import ornek.uygulama.com.sinemaotomation.objects.Filmler;
import ornek.uygulama.com.sinemaotomation.objects.Koltuk;
import ornek.uygulama.com.sinemaotomation.objects.Seans;

public class koltukSecim extends AppCompatActivity {



    private Filmler filmler;

    private ArrayList KoltukArray;
    private sinemaDao vt;
    private koltukAdapter koltukAdapter;
    RecyclerView recyclerView;
    private Koltuk koltuk;
    private Seans seans;
    public static String seansSaat,salonAdi;
    public static String filmresim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koltuk_secim);



        recyclerView=findViewById(R.id.rv);
        filmler= (Filmler) getIntent().getSerializableExtra("filmbilgi");

        recyclerView.setHasFixedSize(true); //ekran döndürmede bozulma
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.VERTICAL));
        veritabaniKopyala();

        vt =  new sinemaDao(this);


        KoltukArray =new filmlerDao().tumKoltuklar(vt);




        koltukAdapter=new koltukAdapter(this,KoltukArray);
        recyclerView.setAdapter(koltukAdapter);


        seans= (Seans) getIntent().getSerializableExtra("seans");
        seansSaat=seans.getSeans_saati();
        salonAdi=seans.getSalon_adi();


        System.out.println("Denemesalon"+seans.getSalon_id());
    }

    public void veritabaniKopyala(){ //hazır

        DatabaseCopyHelper helper = new DatabaseCopyHelper(this);

        try {
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        helper.openDataBase();


    }
}
