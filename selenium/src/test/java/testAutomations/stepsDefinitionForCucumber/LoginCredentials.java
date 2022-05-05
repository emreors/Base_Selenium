package testAutomations.stepsDefinitionForCucumber;

import io.cucumber.java.en.*;

/**
 * Created by Emre ÖRS
 * Date 11.01.2022
 */

public class LoginCredentials {
    @Given("kullanici hepsiburada anasayfasina erisir")
    public void kullaniciHepsiburadaAnasayfasinaErisir() {
        System.out.println("Kullanıcı, Hepsiburada ana sayfasına erişti");
    }

    @And("ana sayfada giris yap butonu goruntulenir")
    public void anaSayfadaGirisYapButonuGoruntulenir() {
        System.out.println("Kullanıcı, ana sayfada giriş yap butonunu görüntüledi");
    }

    @When("kullanici giris yap butonuna tiklar")
    public void kullaniciGirisYapButonunaTiklar() {
        System.out.println("Kullanıcı, giriş yap butonuna tıkladı");
    }

    @Then("kullanici login sayfasina yonlendirilir")
    public void kullaniciLoginSayfasinaYonlendirilir() {
        System.out.println("Kullanıcı, Login Sayfasına yönlendirildi");
    }

    @Given("kullanici login sayfasina erisir")
    public void kullaniciLoginSayfasinaErisir() {
        System.out.println("Kullanıcı, Login sayfasına erişti");
    }

    @When("kullanici gecerli bir kullanici adi girer {string}")
    public void kullaniciGecerliBirKullaniciAdiGirer(String arg0) {
        System.out.println("Kullanıcı, Kullanıcı Adı girişini gerçekleştirdi");
    }

    @And("kullanici username icin giris yap butonuna tiklar")
    public void kullanciUsernameIcinGirisYapButonunaTiklar() {
        System.out.println("Kullanıcı, Kullanıcı Adı için Giriş yap butonuna tıkladı");
    }

    @Then("kullanici Password sayfasina yonlendirilir")
    public void kullaniciPasswordSayfasinaYonlendirilir() {
        System.out.println("Kullanıcı, Şifre sayfasına yönlendirildi");
    }

    @Given("kullanici password sayfasina erisir")
    public void kullaniciPasswordSayfasinaErisir() {
        System.out.println("Kullanıcı, password sayfasına erişti");
    }

    @When("kullanici gecerli bir password girer {string}")
    public void kullaniciGecerliBirPasswordGirer(String arg0) {
        System.out.println("Kullanıcı, password girişini gerçekleştirdi");
    }

    @And("kullanici password icin giris yap butonuna tiklar")
    public void kullanciPasswordIcinGirisYapButonunaTiklar() {
        System.out.println("Kullanıcı, Password için Giriş yap butonuna tıkladı");
    }

    @Then("kullanici ana sayfaya erisir")
    public void kullaniciAnaSayfayaErisir() {
        System.out.println("Kullanıcı, login olarak anasayfaya erişti");
    }

    @And("anasayfada hesabim dropdown menusu goruntulenir")
    public void anasayfadaHesabimDropdownMenusuGoruntulenir() {
        System.out.println("Kullanıcı, anasayfada hesabım dropdown menüsünü görüntüledi");
    }

    @But("anasayfada artik giris yap butonu goruntulenmez")
    public void anasayfadaArtikGirisYapButonuGoruntulenmez() {
        System.out.println("Kullanıcı, anasayfada giriş yap butonunu görüntülemedi");
    }
}
