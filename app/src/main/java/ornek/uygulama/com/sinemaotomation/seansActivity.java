package ornek.uygulama.com.sinemaotomation;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import ornek.uygulama.com.sinemaotomation.adapter.FilmlerAdapter;
import ornek.uygulama.com.sinemaotomation.adapter.seansAdapter;
import ornek.uygulama.com.sinemaotomation.dao.DatabaseCopyHelper;
import ornek.uygulama.com.sinemaotomation.dao.filmlerDao;
import ornek.uygulama.com.sinemaotomation.dao.sinemaDao;
import ornek.uygulama.com.sinemaotomation.objects.Filmler;
import ornek.uygulama.com.sinemaotomation.objects.Seans;

public class seansActivity extends AppCompatActivity {

    private Filmler filmler;
    TextView textView;
    private ArrayList SeansArray;
    private sinemaDao vt;
    private seansAdapter seansAdapter;
    RecyclerView recyclerView;
    private Seans seans;
    public static String filmadi;
    public static String filmresim;
    Button seansEkle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seans);


        seansEkle=findViewById(R.id.seansEkle);

        recyclerView=findViewById(R.id.recyclerView2);
        filmler= (Filmler) getIntent().getSerializableExtra("filmbilgi");

        filmadi=filmler.getFilm_adi();
        filmresim=filmler.getFilm_resim();


        recyclerView.setHasFixedSize(true); //ekran döndürmede bozulma
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
        veritabaniKopyala();

        vt =  new sinemaDao(this);


       SeansArray =new filmlerDao().filmSeansi(vt,filmler.getFilm_id());




        seansAdapter=new seansAdapter(this,SeansArray);
        recyclerView.setAdapter(seansAdapter);

        seans= (Seans) getIntent().getSerializableExtra("seans");



        seansEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seansEkleme(seans);
            }
        });

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
    public void seansEkleme(final Seans seans){
        LayoutInflater layoutInflater= LayoutInflater.from(this);
        View tasarim=layoutInflater.inflate(R.layout.salonekle,null);
        final EditText salonEkle;
        salonEkle=tasarim.findViewById(R.id.salonEkle);


        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setTitle("Seans Ekle");
        ad.setView(tasarim);
        ad.setPositiveButton("Ekle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String eSeansid=salonEkle.getText().toString().trim();
                new filmlerDao().senasEkle(vt,Integer.valueOf(eSeansid));


                SeansArray =new filmlerDao().filmSeansi(vt,filmler.getFilm_id());




                seansAdapter=new seansAdapter(getApplicationContext(),SeansArray);
                recyclerView.setAdapter(seansAdapter);


            }
        });
        ad.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        ad.create().show();
    }
}
