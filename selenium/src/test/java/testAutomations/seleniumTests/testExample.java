package testAutomations.seleniumTests;

import testAutomations.Kullanici;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

/**
 * Created by Emre ÖRS
 * Date 19.11.2019
 */

public class testExample extends testAutomations.TestBase {
    private String baseUrl;
    private boolean acceptNextAlert = true;

    @FindBy(xpath = "//div[@id='myAccount']")
    public WebElement girisYapDropDownMenu;
    @FindBy(xpath = "//a[@id='login']")
    public WebElement loginButonuOnDropDownMenu;

    @FindBy(xpath = "//input[@id='txtUserName']")
    public WebElement kullaniciAdiTextBox;

    @FindBy(xpath = "//button[@id='btnLogin']")
    public WebElement girisYapButonuUsername;

    @FindBy(xpath = "//input[@id='txtPassword']")
    public WebElement kullaniciPasswordTextBox;

    @FindBy(xpath = "//button[@id='btnEmailSelect']")
    public WebElement girisYapButonuPassword;

    @FindBy(xpath = "//span[contains(text(),'Hesabım')]")
    public WebElement hesabim;

    @FindBy(xpath = "//body/div[@id='container']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")
//    @FindBy(xpath = "//input[@placeholder='Ürün, kategori veya marka ara']")
    public WebElement mainAramaBox;

    @FindBy(xpath = "//div[contains(text(),'ARA')]")
    public WebElement mainAramaButton;

    @FindBy(xpath = "//div[contains(text(),'Satıcı')]")
    public WebElement saticiDropDownMultiSelect;

    @FindBy(xpath = "//div[contains(text(),'Hepsiburada')]")
    public WebElement satici1;

    @FindBy(xpath = "//a[@title='Hepsiburada']//*[name()='svg']//*[name()='path' and contains(@d,'M11.525 6.')]")
    public WebElement anasayfaHepsiburada;

    @FindBy(xpath = "//div[contains(text(),'Elektromanya')]")
    public WebElement satici2;

    @FindBy(xpath = "//li[@id='i0']")
    public WebElement sayfadakiIlkUrun;

    @FindBy(xpath = "//h1[@id='product-name']")
    public WebElement urunAdiElement;

    @FindBy(id = "addToCart")
    public WebElement sepeteEkleProductPage;

    @FindBy(xpath = "//button[contains(text(),'Sepete git')]")
    public WebElement sepeteGitPPPopUp;

    @FindBy(xpath = "//button[contains(text(),'Alışverişe devam et')]")
    public WebElement alisveriseDevamEtProductPagePopUp;

    String ilkSecilenUrun = "Birinci Ürün Seçilemedi";
    String ikinciSecilenUrun = "İkinci Ürün Seçilemedi";

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/section[1]/section[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[2]/div[2]")
    public WebElement sepettekiIlkUrunElement;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/section[1]/section[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/div[2]/div[2]")
    public WebElement sepettekiIkinciUrunElement;

    @Test
    public void testOdev1() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Fwait.until(ExpectedConditions.visibilityOf(girisYapDropDownMenu));

        Logger.info("Dropdown Menüye Tıklanıyor..");
        try {
            girisYapDropDownMenu.click();
        } catch (Exception e) {
            Logger.warn("Dropdown Menü Tıklanamadı.");
        }

        Fwait.until(ExpectedConditions.visibilityOf(loginButonuOnDropDownMenu));
        Logger.info("Login Butonuna Tıklanıyor..");
        try {
            loginButonuOnDropDownMenu.click();
        } catch (Exception e) {
            Logger.warn("Login Butonuna Tıklanamadı!");
        }

        Fwait.until(ExpectedConditions.visibilityOf(kullaniciAdiTextBox));
        kullaniciAdiTextBox.click();
        kullaniciAdiTextBox.sendKeys(Kullanici.KULLANICI1.getAd());

        Fwait.until(ExpectedConditions.visibilityOf(girisYapButonuUsername));
        girisYapButonuUsername.click();

        Fwait.until(ExpectedConditions.visibilityOf(kullaniciPasswordTextBox));
        kullaniciPasswordTextBox.click();
        kullaniciPasswordTextBox.sendKeys(Kullanici.KULLANICI1.getSifre());

        Fwait.until(ExpectedConditions.visibilityOf(girisYapButonuPassword));
        girisYapButonuPassword.click();
        Thread.sleep(2000);

        Logger.info("Login Olunuyor.."); // Login Kontrolü
        try {
            Fwait.until(ExpectedConditions.visibilityOf(hesabim));
        } catch (Exception e) {
            Logger.warn("Login Olunamadı");
        }

        js.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -100);", mainAramaBox);
        Fwait.until(ExpectedConditions.visibilityOf(mainAramaBox));
        mainAramaBox.click();
        Thread.sleep(2000);
        Logger.info("Ürün Arama alanı dolduruluyor..");
        mainAramaBox.sendKeys("iphone 11");
        Thread.sleep(2000);

        Fwait.until(ExpectedConditions.visibilityOf(mainAramaButton));
        Logger.info("Ürün Arama Butonuna tıklanıyor..");
        mainAramaButton.click();
        Thread.sleep(2000);

        // Birinci satıcıdan Ürün ekleniyor..
        js.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0,-200);", saticiDropDownMultiSelect);
        Fwait.until(ExpectedConditions.visibilityOf(saticiDropDownMultiSelect));
        saticiDropDownMultiSelect.click();
        Thread.sleep(2000);

        Fwait.until(ExpectedConditions.visibilityOf(satici1));
        Logger.info(satici1.getText() + "Satıcısı seçiliyor..");
        satici1.click();
        Thread.sleep(2000);

        Fwait.until(ExpectedConditions.visibilityOf(sayfadakiIlkUrun));
        js.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, 0);", sayfadakiIlkUrun);
        Logger.info("Görüntülenen ilk ürüne tıklanıyor. ");
        sayfadakiIlkUrun.click();
        Thread.sleep(2000);

        // Yeni sekme handle
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        try {
            driver.switchTo().window(tabs2.get(1));
        } catch (Exception e) {
            Logger.warn("Yeni Sekme açılmadı");
        }

        Logger.info("Seçilen ilk Ürün İsmi : " + urunAdiElement.getText());
        ilkSecilenUrun = urunAdiElement.getText();

        Thread.sleep(2000);

        js.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -100);", sepeteEkleProductPage);
        Fwait.until(ExpectedConditions.visibilityOf(sepeteEkleProductPage));
        Logger.info("Ürün Sepete Ekleniyor..");

        sepeteEkleProductPage.click();

        Fwait.until(ExpectedConditions.visibilityOf(sepeteGitPPPopUp));
        Fwait.until(ExpectedConditions.visibilityOf(alisveriseDevamEtProductPagePopUp));
        Logger.info("Ürün alışverişe devam et Butonuna Tıklanıyor..");
        alisveriseDevamEtProductPagePopUp.click();

        js.executeScript("window.scrollBy(0, 0);");
        Fwait.until(ExpectedConditions.visibilityOf(anasayfaHepsiburada));

        // İkinci satıcıdan Ürün ekleniyor..
        Thread.sleep(2000);

        js.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0,-200);", saticiDropDownMultiSelect);
        Fwait.until(ExpectedConditions.visibilityOf(saticiDropDownMultiSelect));
        Logger.info("Satıcı Dropdown menüye Tıklanıyor..");
        saticiDropDownMultiSelect.click();

        js.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, 0);", satici2);
        Fwait.until(ExpectedConditions.visibilityOf(satici2));
        Logger.info(satici2.getText() + "Satıcısı seçiliyor..");
        satici2.click();
        Thread.sleep(2000);

        Fwait.until(ExpectedConditions.visibilityOf(sayfadakiIlkUrun));
        js.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, 0);", sayfadakiIlkUrun);
        Logger.info("Görüntülenen ilk ürüne tıklanıyor. ");
        sayfadakiIlkUrun.click();
        Thread.sleep(2000);

        // Yeni sekme handle
        ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles());
        try {
            driver.switchTo().window(tabs3.get(2));
        } catch (Exception e) {
            Logger.warn("Yeni Sekme açılmadı");
        }

        Logger.info("Seçilen ikinci Ürün İsmi : " + urunAdiElement.getText());
        ikinciSecilenUrun = urunAdiElement.getText();

        Fwait.until(ExpectedConditions.visibilityOf(sepeteEkleProductPage));
        js.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -100);", sepeteEkleProductPage);
        sepeteEkleProductPage.click();
        Thread.sleep(2000);

        Fwait.until(ExpectedConditions.visibilityOf(sepeteGitPPPopUp));
        sepeteGitPPPopUp.click();
        Thread.sleep(2000);

        Logger.info("---------------Seçilen Ürüneler----------------");
        Logger.info("Seçilen birinci ürün :" + ilkSecilenUrun);
        Logger.info("Seçilen ikinci Ürün :" + ikinciSecilenUrun);

        Logger.info("---------------Sepetteki Ürünler----------------");
        Logger.info("Sepetteki birinci Ürün :" + sepettekiIlkUrunElement.getText());
        Logger.info("Sepetteki ikinci Ürün :" + sepettekiIkinciUrunElement.getText());

        try {
            Assert.assertEquals("Ürünler uyuşmuyor", ilkSecilenUrun, sepettekiIlkUrunElement.getText());
            Assert.assertEquals("Ürünler uyuşmuyor", ikinciSecilenUrun, sepettekiIkinciUrunElement.getText());
            Logger.info("Seçilen ürünler ve sepete eklenen ürünler uyuşuyor. :) ");
        } catch (Exception e) {
            Logger.warn("Sepetteki ürün ile seçilen ürün uyuşmuyor. :( ");
        }

        System.out.println("Test Tamamlandı!");
        Thread.sleep(5000);
    }
}