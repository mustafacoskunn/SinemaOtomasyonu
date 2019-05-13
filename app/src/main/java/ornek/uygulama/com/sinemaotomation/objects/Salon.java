package ornek.uygulama.com.sinemaotomation.objects;

public class Salon {
    private int salon_id;
    private String salon_adi;
    private int film_id;
    private Filmler filmler;

    public Salon() {
    }

    public Salon(int salon_id, String salon_adi, int film_id, Filmler filmler) {

        this.salon_id = salon_id;
        this.salon_adi = salon_adi;
        this.film_id = film_id;
        this.filmler = filmler;
    }

    public int getSalon_id() {
        return salon_id;
    }

    public void setSalon_id(int salon_id) {
        this.salon_id = salon_id;
    }

    public String getSalon_adi() {
        return salon_adi;
    }

    public void setSalon_adi(String salon_adi) {
        this.salon_adi = salon_adi;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public Filmler getFilmler() {
        return filmler;
    }

    public void setFilmler(Filmler filmler) {
        this.filmler = filmler;
    }
}

