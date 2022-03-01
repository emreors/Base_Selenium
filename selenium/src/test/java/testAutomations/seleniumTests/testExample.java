package testAutomations.seleniumTests;

import testAutomations.Kullanici;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Emre ÖRS
 * Date 09.01.2022
 */

public class testExample extends testAutomations.TestBase {
    private String baseUrl;
    private boolean acceptNextAlert = true;

    @FindBy(xpath = "//button[contains(text(),'Oturum aç')]")
    public WebElement oturumAcButonu;

    @FindBy(xpath = "//input[@id='login-username']")
    public WebElement kullaniciAdiTextBox;

    @FindBy(xpath = "//input[@id='login-password']")
    public WebElement kullaniciPasswordTextBox;

    @FindBy(xpath = "//p[contains(text(),'Oturum Aç')]")
    public WebElement oturumAcLoginButonu;

    @FindBy(xpath = "//span[contains(text(),'Ara')]")
    public WebElement araTextBox;



    @Test
    public void testOdev1() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Fwait.until(ExpectedConditions.visibilityOf(oturumAcButonu));

        Logger.info("Dropdown Menüye Tıklanıyor..");
        try {
            oturumAcButonu.click();
        } catch (Exception e) {
            Logger.warn("Oturum Aç Tıklanamadı");
        }



        Fwait.until(ExpectedConditions.visibilityOf(kullaniciAdiTextBox));
        kullaniciAdiTextBox.click();
        kullaniciAdiTextBox.sendKeys(Kullanici.KULLANICI2.getAd());

        Fwait.until(ExpectedConditions.visibilityOf(kullaniciPasswordTextBox));
        kullaniciPasswordTextBox.click();
        kullaniciPasswordTextBox.sendKeys(Kullanici.KULLANICI2.getSifre());

        Fwait.until(ExpectedConditions.visibilityOf(oturumAcLoginButonu));
        oturumAcLoginButonu.click();
        Thread.sleep(2000);

        Logger.info("Login Olunuyor.."); // Login Kontrolü
        try {
            Fwait.until(ExpectedConditions.visibilityOf(araTextBox));
        } catch (Exception e) {
            Logger.warn("Login Olunamadı");
        }


        System.out.println("Test Tamamlandı!");
        Thread.sleep(5000);
    }
}