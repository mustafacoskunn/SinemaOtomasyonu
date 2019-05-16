package ornek.uygulama.com.sinemaotomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seans);


        recyclerView=findViewById(R.id.recyclerView2);
        filmler= (Filmler) getIntent().getSerializableExtra("filmbilgi");

        recyclerView.setHasFixedSize(true); //ekran döndürmede bozulma
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
        veritabaniKopyala();

        vt =  new sinemaDao(this);


       SeansArray =new filmlerDao().filmSeansi(vt,filmler.getFilm_id());




        seansAdapter=new seansAdapter(this,SeansArray);
        recyclerView.setAdapter(seansAdapter);


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
