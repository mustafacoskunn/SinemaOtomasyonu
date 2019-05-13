package ornek.uygulama.com.sinemaotomation.objects;

public class Film_seans {
    private int film_id;
    private int seans_id;
    private Filmler filmler;
    private Seans seans;

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
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

    public Seans getSeans() {
        return seans;
    }

    public void setSeans(Seans seans) {
        this.seans = seans;
    }

    public Film_seans(int film_id, int seans_id, Filmler filmler, Seans seans) {
        this.film_id = film_id;
        this.seans_id = seans_id;
        this.filmler = filmler;
        this.seans = seans;
    }

    public Film_seans() {
    }
}
