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
import ornek.uygulama.com.sinemaotomation.biletActivity;
import ornek.uygulama.com.sinemaotomation.objects.Koltuk;
import ornek.uygulama.com.sinemaotomation.objects.Seans;
import ornek.uygulama.com.sinemaotomation.seansActivity;



public class koltukAdapter extends RecyclerView.Adapter<koltukAdapter.CardTasarimTutucu> {
    private Context mContext;
    private List<Koltuk> koltukList;

    public koltukAdapter(Context mContext, List<Koltuk> koltukList) {
        this.mContext = mContext;
        this.koltukList = koltukList;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardView cardView;
        private Button koltuk;


        public CardTasarimTutucu(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            koltuk = itemView.findViewById(R.id.koltuk);


        }
    }

    @Override
    public CardTasarimTutucu onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.koltukcardiviewtasarim,parent,false);
        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(final CardTasarimTutucu holder, int position) {

         final Koltuk koltukk = koltukList.get(position);
        holder.koltuk.setText(String.valueOf(koltukk.getKoltuk_rakam()));
        holder.koltuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, biletActivity.class);
                intent.putExtra("biletbilgi",koltukk);
                mContext.startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return koltukList.size();
    }




}
