package ornek.uygulama.com.sinemaotomation.objects;

public class Bilet {
    private String bilet_id;
    private String bilet_adi;
    private int film_id;
    private int koltuk_id;
    private int salon_id;
    private int seans_id;
    private Filmler filmler;
    private Koltuk koltuk;
    private Salon salon;

    public Bilet() {
    }

    public Bilet(String bilet_id, String bilet_adi, int film_id, int koltuk_id, int salon_id, int seans_id, Filmler filmler, Koltuk koltuk, Salon salon) {
        this.bilet_id = bilet_id;
        this.bilet_adi = bilet_adi;
        this.film_id = film_id;
        this.koltuk_id = koltuk_id;
        this.salon_id = salon_id;
        this.seans_id = seans_id;
        this.filmler = filmler;
        this.koltuk = koltuk;
        this.salon = salon;
    }

    public String getBilet_id() {
        return bilet_id;
    }

    public void setBilet_id(String bilet_id) {
        this.bilet_id = bilet_id;
    }

    public String getBilet_adi() {
        return bilet_adi;
    }

    public void setBilet_adi(String bilet_adi) {
        this.bilet_adi = bilet_adi;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public int getKoltuk_id() {
        return koltuk_id;
    }

    public void setKoltuk_id(int koltuk_id) {
        this.koltuk_id = koltuk_id;
    }

    public int getSalon_id() {
        return salon_id;
    }

    public void setSalon_id(int salon_id) {
        this.salon_id = salon_id;
    }

    public int getSeans_id() {
        return seans_id;
    }

    public void setSeans_id(int seans_id) {
        this.seans_id = seans_id;
    }

    public Filmler getFilmler() {
        return filmler;
    }

    public void setFilmler(Filmler filmler) {
        this.filmler = filmler;
    }

    public Koltuk getKoltuk() {
        return koltuk;
    }

    public void setKoltuk(Koltuk koltuk) {
        this.koltuk = koltuk;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }
}
