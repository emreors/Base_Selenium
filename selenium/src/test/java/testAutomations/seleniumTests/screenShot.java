package testAutomations.seleniumTests;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testAutomations.Kullanici;

import java.io.File;
import java.io.IOException;

/**
 * Created by Emre ÖRS
 * Date 09.01.2021
 */

public class screenShot extends testAutomations.TestBase {
    private String baseUrl;
    private boolean acceptNextAlert = true;

    @FindBy(xpath = "//div[contains(text(),'Oturum aç')]")
    public WebElement oturumAcButonu;

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
        Actions actions = new Actions(driver);
        Fwait.until(ExpectedConditions.visibilityOf(oturumAcButonu));


        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        File screenshot = (scrShot.getScreenshotAs(OutputType.FILE));
        File destFile =  new File(imageSystemPath); // getProperty ile windows kullanıcısını buluyoruz

        try {
            FileUtils.copyFile(screenshot, destFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        // screenshot tamam, şimdi ilgili dosyayı yüklüyoruz

        oturumAcButonu.sendKeys(imageSystemPath);
    }
}