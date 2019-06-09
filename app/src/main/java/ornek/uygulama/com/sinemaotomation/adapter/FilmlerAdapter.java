package ornek.uygulama.com.sinemaotomation.adapter;



import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import ornek.uygulama.com.sinemaotomation.R;
import ornek.uygulama.com.sinemaotomation.biletActivity;
import ornek.uygulama.com.sinemaotomation.dao.filmlerDao;
import ornek.uygulama.com.sinemaotomation.dao.sinemaDao;
import ornek.uygulama.com.sinemaotomation.objects.Filmler;
import ornek.uygulama.com.sinemaotomation.objects.Seans;
import ornek.uygulama.com.sinemaotomation.seansActivity;


public class FilmlerAdapter extends RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu> {
    private Context mContext;
    private List<Filmler> filmlerListe;
    private sinemaDao vt;

    public FilmlerAdapter(Context mContext, List<Filmler> filmlerListe,sinemaDao vt) {
        this.mContext = mContext;
        this.filmlerListe = filmlerListe;
        this.vt=vt;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardView film_card;
        private TextView textViewFilmAd;
        private ImageView ımageViewFilmResim,imageNokta;

        public CardTasarimTutucu(View itemView) {
            super(itemView);
            film_card = itemView.findViewById(R.id.cardView);
            textViewFilmAd = itemView.findViewById(R.id.textViewFilmAd);
            ımageViewFilmResim = itemView.findViewById(R.id.imageViewFilmResim);
            imageNokta = itemView.findViewById(R.id.imageNokta);
        }
    }

    @Override
    public CardTasarimTutucu onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.filmcardtasarim,parent,false);
        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(final CardTasarimTutucu holder, int position) {
        final Filmler film = filmlerListe.get(position);

        holder.textViewFilmAd.setText(film.getFilm_adi());

        Picasso.with(mContext)
                .load(film.getFilm_resim())
                .into(holder.ımageViewFilmResim);
        holder.film_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext, seansActivity.class);
                intent.putExtra("filmbilgi",film);
                mContext.startActivity(intent);




            }
        });
        holder.imageNokta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(mContext,holder.imageNokta);
                popupMenu.getMenuInflater().inflate(R.menu.menu_pop,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                       switch (item.getItemId()){
                           case R.id.sil:
                               Snackbar.make(holder.imageNokta,"Film Silinsin Mi ?",Snackbar.LENGTH_LONG)
                                       .setAction("Evet", new View.OnClickListener() {
                                           @Override
                                           public void onClick(View view) {
                                               new filmlerDao().filmSil(vt,film.getFilm_id());

                                               filmlerListe = new filmlerDao().tumFilmler(vt);

                                               notifyDataSetChanged();

                                           }
                                       })
                                       .show();
                               return true;

                           case R.id.guncelle:
                               alertGoster(film);

                               return true;

                           case R.id.salonEkle:
                               Toast.makeText(mContext,String.valueOf(film.getFilm_id()),Toast.LENGTH_LONG).show();

                               salonEkle(film);
                               return true;
                               default:
                                   return false;

                       }


                    }
                });

                popupMenu.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return filmlerListe.size();
    }


    public void alertGoster(final Filmler film){
        LayoutInflater layoutInflater= LayoutInflater.from(mContext);
        View tasarim=layoutInflater.inflate(R.layout.menusilveguncelle,null);
        final EditText editFilmAdi,editFilmResim;
        editFilmAdi=tasarim.findViewById(R.id.editFilmAdi);
        editFilmResim=tasarim.findViewById(R.id.editFilmResim);
        editFilmAdi.setText(film.getFilm_adi());
        editFilmResim.setText(film.getFilm_resim());
        AlertDialog.Builder ad=new AlertDialog.Builder(mContext);
        ad.setTitle("Film Güncelle");
        ad.setView(tasarim);
        ad.setPositiveButton("Güncelle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String gfilmAdi=editFilmAdi.getText().toString().trim();
                String gfilmResim=editFilmResim.getText().toString().trim();
                new filmlerDao().filmGuncelle(vt,film.getFilm_id(),gfilmAdi,gfilmResim);

                filmlerListe = new filmlerDao().tumFilmler(vt);

                notifyDataSetChanged();


            }
        });
        ad.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        ad.create().show();
    }
   public void salonEkle(final Filmler filmler){
        LayoutInflater layoutInflater= LayoutInflater.from(mContext);
        View tasarim=layoutInflater.inflate(R.layout.salonekle,null);
        final EditText salonEkle;
       salonEkle=tasarim.findViewById(R.id.salonEkle);


        AlertDialog.Builder ad=new AlertDialog.Builder(mContext);
        ad.setTitle("Salon Ekle");
        ad.setView(tasarim);
        ad.setPositiveButton("Ekle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String eSalonadi=salonEkle.getText().toString().trim();
                new filmlerDao().salonekle(vt,eSalonadi,filmler.getFilm_id());

                filmlerListe = new filmlerDao().tumFilmler(vt);

                notifyDataSetChanged();


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
