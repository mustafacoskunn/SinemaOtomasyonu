package ornek.uygulama.com.sinemaotomation.objects;

public class Seans {
    private int seans_id;
    private String seans_saati;
    private String salon_adi;

    public Seans() {
    }

    public Seans(int seans_id, String seans_saati, String salon_adi) {
        this.seans_id = seans_id;
        this.seans_saati = seans_saati;
        this.salon_adi = salon_adi;
    }

    public int getSeans_id() {
        return seans_id;
    }

    public void setSeans_id(int seans_id) {
        this.seans_id = seans_id;
    }

    public String getSeans_saati() {
        return seans_saati;
    }

    public void setSeans_saati(String seans_saati) {
        this.seans_saati = seans_saati;
    }

    public String getSalon_adi() {
        return salon_adi;
    }

    public void setSalon_adi(String salon_adi) {
        this.salon_adi = salon_adi;
    }
}
