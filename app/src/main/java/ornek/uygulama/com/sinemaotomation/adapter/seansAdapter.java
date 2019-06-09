package ornek.uygulama.com.sinemaotomation.adapter;



import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import ornek.uygulama.com.sinemaotomation.R;
import ornek.uygulama.com.sinemaotomation.koltukSecim;
import ornek.uygulama.com.sinemaotomation.objects.Seans;
import ornek.uygulama.com.sinemaotomation.seansActivity;



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
        private TextView salonAdi;

        public CardTasarimTutucu(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            button = itemView.findViewById(R.id.koltuk);
            salonAdi=itemView.findViewById(R.id.salonAdi);

        }
    }

    @Override
    public CardTasarimTutucu onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_seanscardtasarim,parent,false);
        return new CardTasarimTutucu(view);
    }


    @Override
    public void onBindViewHolder(CardTasarimTutucu holder, int position) {

        final Seans seans1 = seansListe.get(position);
        holder.button.setText(seans1.getSeans_saati());
        holder.salonAdi.setText(seans1.getSalon_adi());

        System.out.println("deneme"+seans1.getSalon_id());


        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(mContext, koltukSecim.class);
                intent1.putExtra("seans",  seans1);

                mContext.startActivity(intent1);
            }
        });
        Intent intent=new Intent(mContext, seansActivity.class);
        intent.putExtra("seans",  seans1);


    }

    @Override
    public int getItemCount() {
        return seansListe.size();
    }




}
