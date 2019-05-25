package ornek.uygulama.com.sinemaotomation;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ornek.uygulama.com.sinemaotomation.objects.Filmler;

public class yoneticiSayfasi extends AppCompatActivity {

    EditText kAdi,sifre;
    Button girisYap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yonetici_sayfasi);
        kAdi=findViewById(R.id.kAdi);
        sifre=findViewById(R.id.sifre);
        girisYap=findViewById(R.id.girisYap);





    }

    public void giris(View view){



    }
}
