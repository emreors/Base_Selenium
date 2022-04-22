package testAutomations;

import org.junit.Ignore;

/**
 * Created by Emre Örs
 * Date :03.01.2019
 */
@Ignore
public enum Kullanici {

    KULLANICI1("emre.smfc@gmail.com", "B3n1m4d1m3mr3"),
    KULLANICI2("saaa", "bbbb");

    private String ad;
    private String sifre;

    public String getAd() {
        return ad;
    }

    public String getSifre() {
        return sifre;
    }

    Kullanici(String ad, String sifre) {
        this.ad = ad;
        this.sifre = sifre;
    }
}