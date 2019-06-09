package ornek.uygulama.com.sinemaotomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ornek.uygulama.com.sinemaotomation.adapter.seansAdapter;
import ornek.uygulama.com.sinemaotomation.objects.Bilet;
import ornek.uygulama.com.sinemaotomation.objects.Filmler;
import ornek.uygulama.com.sinemaotomation.objects.Koltuk;
import ornek.uygulama.com.sinemaotomation.objects.Seans;

public class biletActivity extends AppCompatActivity {

    Filmler filmler;
    Koltuk koltuk;
    Bilet bilet;

    TextView t1,t2,t3;
    Button b1;
    ImageView ımageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilet);
        koltuk= (Koltuk) getIntent().getSerializableExtra("biletbilgi");
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        b1=findViewById(R.id.b1);
        ımageView=findViewById(R.id.imageView);
        Picasso.with(this)
                .load(seansActivity.filmresim)
                .into(ımageView);

        t1.setText(seansActivity.filmadi);
        t2.setText(koltukSecim.salonAdi+" "+koltukSecim.seansSaat);
        t3.setText(koltuk.getKoltuk_harf()+ " "+koltuk.getKoltuk_rakam());





    }
}
