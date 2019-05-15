package ornek.uygulama.com.sinemaotomation.adapter;



import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ornek.uygulama.com.sinemaotomation.R;
import ornek.uygulama.com.sinemaotomation.objects.Film_seans;
import ornek.uygulama.com.sinemaotomation.objects.Filmler;
import ornek.uygulama.com.sinemaotomation.objects.Seans;
import ornek.uygulama.com.sinemaotomation.seansActivity;

/**
 * Created by kasimadalan on 4.05.2018.
 */

public class seansAdapter extends RecyclerView.Adapter<seansAdapter.CardTasarimTutucu> {
    private Context mContext;
    private List<Seans> seansListe;

    public seansAdapter(Context mContext, List<Seans> seansListe) {
        this.mContext = mContext;
        this.seansListe = seansListe;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardView cardView;
        private Button button;

        public CardTasarimTutucu(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            button = itemView.findViewById(R.id.button);

        }
    }

    @Override
    public CardTasarimTutucu onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_seanscardtasarim,parent,false);
        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(CardTasarimTutucu holder, int position) {
        final Seans seans = seansListe.get(position);

        holder.button.setText(seans.getSeans_saati());




    }

    @Override
    public int getItemCount() {
        return seansListe.size();
    }




}
