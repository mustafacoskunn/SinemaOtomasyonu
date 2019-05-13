package ornek.uygulama.com.sinemaotomation.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sinemaDao extends SQLiteOpenHelper {

    public sinemaDao(Context context) {
        super(context, "sinema.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS\"bilet\" (\n" +
                "\t\"bilet_id\"\tvarchar(50) NOT NULL,\n" +
                "\t\"bilet_adi\"\tvarchar(50) DEFAULT NULL,\n" +
                "\t\"film_id\"\tint(11) NOT NULL,\n" +
                "\t\"koltuk_id\"\tint(11) NOT NULL,\n" +
                "\t\"salon_id\"\tint(11) NOT NULL,\n" +
                "\t\"seans_id\"\tint(11) NOT NULL,\n" +
                "\tPRIMARY KEY(\"bilet_id\"),\n" +
                "\tCONSTRAINT \"film_id\" FOREIGN KEY(\"film_id\") REFERENCES \"filmler\"(\"film_id\"),\n" +
                "\tCONSTRAINT \"koltuk_id\" FOREIGN KEY(\"koltuk_id\") REFERENCES \"koltuk\"(\"koltuk_id\"),\n" +
                "\tCONSTRAINT \"salon_id\" FOREIGN KEY(\"salon_id\") REFERENCES \"salon\"(\"salon_id\")\n" +
                ");");
        db.execSQL("CREATE TABLE IF NOT EXISTS\"film_seans\" (\n" +
                "\t\"film_id\"\tint(11) NOT NULL,\n" +
                "\t\"seans_id\"\tint(11) NOT NULL,\n" +
                "\tCONSTRAINT \"film__id\" FOREIGN KEY(\"film_id\") REFERENCES \"filmler\"(\"film_id\"),\n" +
                "\tCONSTRAINT \"seans__id\" FOREIGN KEY(\"seans_id\") REFERENCES \"seans\"(\"seans_id\")\n" +
                ");");
        db.execSQL("CREATE TABLE IF NOT EXISTS\"filmler\" (\n" +
                "\t\"film_id\"\tint(11) NOT NULL,\n" +
                "\t\"film_adi\"\tvarchar(50) NOT NULL,\n" +
                "\tPRIMARY KEY(\"film_id\")\n" +
                ");");
        db.execSQL("CREATE TABLE IF NOT EXISTS\"koltuk\" (\n" +
                "\t\"koltuk_id\"\tint(11) NOT NULL,\n" +
                "\t\"salon_id\"\tint(11) NOT NULL,\n" +
                "\t\"koltuk_harf\"\tvarchar(2) NOT NULL,\n" +
                "\t\"koltuk_rakam\"\tint(3) DEFAULT NULL,\n" +
                "\tPRIMARY KEY(\"koltuk_id\")\n" +
                ");");
        db.execSQL("CREATE TABLE IF NOT EXISTS\"salon\" (\n" +
                "\t\"salon_id\"\tint(11) NOT NULL,\n" +
                "\t\"salon_adi\"\tvarchar(50) NOT NULL,\n" +
                "\t\"film_id\"\tint(11) NOT NULL,\n" +
                "\tPRIMARY KEY(\"salon_id\"),\n" +
                "\tCONSTRAINT \"film_id_for\" FOREIGN KEY(\"film_id\") REFERENCES \"filmler\"(\"film_id\")\n" +
                ");");
        db.execSQL("CREATE TABLE IF NOT EXISTS\"salon_seans\" (\n" +
                "\t\"salon_id\"\tint(11) NOT NULL,\n" +
                "\t\"seans_id\"\tint(11) NOT NULL,\n" +
                "\tCONSTRAINT \"seans_ids\" FOREIGN KEY(\"seans_id\") REFERENCES \"seans\"(\"seans_id\"),\n" +
                "\tCONSTRAINT \"salon_ids\" FOREIGN KEY(\"salon_id\") REFERENCES \"salon\"(\"salon_id\")\n" +
                ");");
        db.execSQL("CREATE TABLE IF NOT EXISTS\"seans\" (\n" +
                "\t\"seans_id\"\tint(11) NOT NULL,\n" +
                "\t\"seans_saati\"\tvarchar(11) NOT NULL,\n" +
                "\tPRIMARY KEY(\"seans_id\")\n" +
                ");");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS bilet ");
        db.execSQL("DROP TABLE IF EXISTS film_seans ");
        db.execSQL("DROP TABLE IF EXISTS filmler ");
        db.execSQL("DROP TABLE IF EXISTS koltuk ");
        db.execSQL("DROP TABLE IF EXISTS salon ");
        db.execSQL("DROP TABLE IF EXISTS salon_seans ");
        db.execSQL("DROP TABLE IF EXISTS seans ");
        onCreate(db);

    }
}
