package ornek.uygulama.com.sinemaotomation.adapter;



import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ornek.uygulama.com.sinemaotomation.R;
import ornek.uygulama.com.sinemaotomation.objects.Filmler;
import ornek.uygulama.com.sinemaotomation.seansActivity;

/**
 * Created by kasimadalan on 4.05.2018.
 */

public class FilmlerAdapter extends RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu> {
    private Context mContext;
    private List<Filmler> filmlerListe;

    public FilmlerAdapter(Context mContext, List<Filmler> filmlerListe) {
        this.mContext = mContext;
        this.filmlerListe = filmlerListe;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardView film_card;
        private TextView textViewFilmAd;
        private ImageView ımageViewFilmResim;
        public CardTasarimTutucu(View itemView) {
            super(itemView);
            film_card = itemView.findViewById(R.id.cardView);
            textViewFilmAd = itemView.findViewById(R.id.textViewFilmAd);
            ımageViewFilmResim = itemView.findViewById(R.id.imageViewFilmResim);
        }
    }

    @Override
    public CardTasarimTutucu onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.filmcardtasarim,parent,false);
        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(CardTasarimTutucu holder, int position) {
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

    }

    @Override
    public int getItemCount() {
        return filmlerListe.size();
    }




}
