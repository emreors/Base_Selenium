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

public class testSpotify extends testAutomations.TestBase {
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


    @FindBy(xpath = "//header/div[3]/div[1]/div[1]/form[1]/input[1]")
    public WebElement araTextBoxUst;

    @FindBy(xpath = "//span[contains(text(),'Hepsini gör')]")
    public WebElement hepsiniGorButonu;

    @FindBy(xpath = "//div[contains(text(),'Virtuanal Carnival')]")
    public WebElement analCarnaval;

    @FindBy(xpath = "//body/div[@id='main']/div[1]/div[2]/div[2]/footer[1]/div[1]/div[2]/div[1]/div[1]/button[1]")
    public WebElement playButton;
//
//    @FindBy(xpath = "")
//    public WebElement ;
//
//    @FindBy(xpath = "")
//    public WebElement ;
//
//    @FindBy(xpath = "")
//    public WebElement ;
//
//    @FindBy(xpath = "")
//    public WebElement ;




    @Test
    public void testSpotify() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Fwait.until(ExpectedConditions.visibilityOf(oturumAcButonu));

        Logger.info("Oturum Açma Butonuna Tıklanıyor..");
        try {
            oturumAcButonu.click();
        } catch (Exception e) {
            Logger.warn("Oturum Aç Tıklanamadı");
        }



        Fwait.until(ExpectedConditions.visibilityOf(kullaniciAdiTextBox));
        kullaniciAdiTextBox.click();
        kullaniciAdiTextBox.sendKeys(Kullanici.KULLANICI3.getAd());

        Fwait.until(ExpectedConditions.visibilityOf(kullaniciPasswordTextBox));
        kullaniciPasswordTextBox.click();
        kullaniciPasswordTextBox.sendKeys(Kullanici.KULLANICI3.getSifre());

        Fwait.until(ExpectedConditions.visibilityOf(oturumAcLoginButonu));
        oturumAcLoginButonu.click();
        Thread.sleep(2000);

        Logger.info("Login Olunuyor..");
        try {
            Fwait.until(ExpectedConditions.visibilityOf(araTextBox));
        } catch (Exception e) {
            Logger.warn("Login Olunamadı");
        }

        Fwait.until(ExpectedConditions.visibilityOf(araTextBox));
        araTextBox.click();
        Thread.sleep(1000);
        araTextBoxUst.click();
        araTextBoxUst.sendKeys("Rhinogod");
        Thread.sleep(1000);

        hepsiniGorButonu.click();
        Thread.sleep(2000);

        Fwait.until(ExpectedConditions.visibilityOf(analCarnaval));
        analCarnaval.click();
        Thread.sleep(2000);
        Logger.info("Virtuanal Carnaval Seçildi..");


        Fwait.until(ExpectedConditions.visibilityOf(playButton));
        playButton.click();
        Logger.info("Virtuanal Carnaval Çalınıyor..");

        Thread.sleep(15560);



        System.out.println("Test Tamamlandı!");
        Thread.sleep(5000);
    }
}