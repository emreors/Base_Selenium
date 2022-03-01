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
 * Date 09.01.2022
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


        System.out.println("Test Tamamlandı!");
        Thread.sleep(5000);
    }
}