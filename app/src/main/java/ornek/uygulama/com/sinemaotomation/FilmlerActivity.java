package ornek.uygulama.com.sinemaotomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmler);
        filmlerrv=findViewById(R.id.recyclerView);
        filmlerrv.setHasFixedSize(true); //ekran döndürmede bozulma
        filmlerrv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)); // 2şer 2şer grid şekilde diz
        veritabaniKopyala();

        vt =  new sinemaDao(this);


        filmlerArrayList=new filmlerDao().tumFilmler(vt);

        filmlerAdapter=new FilmlerAdapter(this,filmlerArrayList);
        filmlerrv.setAdapter(filmlerAdapter);

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
