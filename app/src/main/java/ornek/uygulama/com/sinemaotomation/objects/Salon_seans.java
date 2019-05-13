package ornek.uygulama.com.sinemaotomation.objects;

public class Salon_seans {
    private int salon_id;
    private int seans_id;

    private Seans seans;
    private Salon salon;
    public Salon_seans() {
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

    public Seans getSeans() {
        return seans;
    }

    public void setSeans(Seans seans) {
        this.seans = seans;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Salon_seans(int salon_id, int seans_id, Seans seans, Salon salon) {
        this.salon_id = salon_id;
        this.seans_id = seans_id;
        this.seans = seans;
        this.salon = salon;
    }
}
