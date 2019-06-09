package ornek.uygulama.com.sinemaotomation.objects;

import java.io.Serializable;

public class Koltuk implements Serializable {
    private int koltuk_id;
    private int salon_id;
    private String koltuk_harf;
    private int koltuk_rakam;

    public Koltuk() {
    }

    public Koltuk(int koltuk_id, int salon_id, String koltuk_harf, int koltuk_rakam) {
        this.koltuk_id = koltuk_id;
        this.salon_id = salon_id;
        this.koltuk_harf = koltuk_harf;
        this.koltuk_rakam = koltuk_rakam;
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

    public String getKoltuk_harf() {
        return koltuk_harf;
    }

    public void setKoltuk_harf(String koltuk_harf) {
        this.koltuk_harf = koltuk_harf;
    }

    public int getKoltuk_rakam() {
        return koltuk_rakam;
    }

    public void setKoltuk_rakam(int koltuk_rakam) {
        this.koltuk_rakam = koltuk_rakam;
    }
}
