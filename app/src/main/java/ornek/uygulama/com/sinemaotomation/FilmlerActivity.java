package ornek.uygulama.com.sinemaotomation;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.util.ArrayList;

import ornek.uygulama.com.sinemaotomation.adapter.FilmlerAdapter;
import ornek.uygulama.com.sinemaotomation.dao.DatabaseCopyHelper;
import ornek.uygulama.com.sinemaotomation.dao.filmlerDao;
import ornek.uygulama.com.sinemaotomation.dao.sinemaDao;
import ornek.uygulama.com.sinemaotomation.objects.Filmler;

public class FilmlerActivity extends AppCompatActivity {

    private RecyclerView filmlerrv;
    private ArrayList<Filmler> filmlerArrayList;
    private FilmlerAdapter filmlerAdapter;
    private sinemaDao vt;
    public static Filmler filmler;
    private FloatingActionButton fab;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmler);
        filmlerrv=findViewById(R.id.recyclerView);
        filmlerrv.setHasFixedSize(true); //ekran döndürmede bozulma
        filmlerrv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)); // 2şer 2şer grid şekilde diz
        veritabaniKopyala();

        fab=findViewById(R.id.fab);
        vt =  new sinemaDao(this);





        filmlerArrayList=new filmlerDao().tumFilmler(vt);


        filmlerAdapter=new FilmlerAdapter(this,filmlerArrayList,vt);
        filmlerrv.setAdapter(filmlerAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertGoster();
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
    public void alertGoster(){
        LayoutInflater layoutInflater= LayoutInflater.from(this);
        View tasarim=layoutInflater.inflate(R.layout.menusilveguncelle,null);
        final EditText editFilmAdi,editFilmResim;
        editFilmAdi=tasarim.findViewById(R.id.editFilmAdi);
        editFilmResim=tasarim.findViewById(R.id.editFilmResim);
        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setTitle("Film Ekle");
        ad.setView(tasarim);
        ad.setPositiveButton("Ekle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String yfilmAdi=editFilmAdi.getText().toString().trim();
                String yfilmResim=editFilmResim.getText().toString().trim();


                new filmlerDao().filmEkle(vt,yfilmAdi,yfilmResim);

                filmlerArrayList = new filmlerDao().tumFilmler(vt);

                filmlerAdapter = new FilmlerAdapter(FilmlerActivity.this,filmlerArrayList,vt);

                filmlerrv.setAdapter(filmlerAdapter);

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
