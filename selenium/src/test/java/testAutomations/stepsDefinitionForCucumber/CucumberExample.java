package testAutomations.stepsDefinitionForCucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import testAutomations.Kullanici;
import testAutomations.TestBase;

/**
 * @author Emre Örs
 * @Date 5.05.2022
 */
public class CucumberExample extends TestBase {

    private String baseUrl = servisAdresi;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    @Test

    @Given("Tanimli URL acilir.")
    public void testtanimli_url_acilir() {
        PageFactory.initElements(driver, this);

    }

    @Given("Kullanici adi ve sifre ile sisteme giris yapilir.")
    public void testkullanici_adi_ve_sifre_ile_sisteme_giris_yapilir() {
        try {
            kullaniciGirisiYap(driver, Kullanici.KULLANICI3);
        } catch (Exception e) {
            System.out.println("Zaten giriş yapılmış.");
        }

    }

    @When("Anasayfada ust kisimda bulunan arama yap alanina tiklanir.")
    public void anasayfada_ust_kisimda_bulunan_arama_yap_alanina_tiklanir() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("Cikis yapilir")
    public void cikis_yapilir() {
        // Write code here that turns the phrase above into concrete actions

    }
}
