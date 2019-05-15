package ornek.uygulama.com.sinemaotomation.objects;

import java.io.Serializable;

public class Filmler implements Serializable {
    private int film_id;
    private String film_adi;
    private String film_resim;

    public Filmler() {

    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getFilm_adi() {
        return film_adi;
    }

    public void setFilm_adi(String film_adi) {
        this.film_adi = film_adi;
    }

    public String getFilm_resim() {
        return film_resim;
    }

    public void setFilm_resim(String film_resim) {
        this.film_resim = film_resim;
    }

    public Filmler(int film_id, String film_adi, String film_resim) {
        this.film_id = film_id;
        this.film_adi = film_adi;
        this.film_resim = film_resim;
    }
}
