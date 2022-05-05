package testAutomations.stepsDefinitionForCucumber;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import testAutomations.Kullanici;
import testAutomations.TestBase;

/**
 * @author Emre Örs
 * @Date 5.05.2022
 */
public class CucumberExample extends TestBase{

    private String baseUrl = servisAdresi;
    private boolean acceptNextAlert = true;

    @FindBy(xpath = "//body/div[@class='layout-wrapper ']/div[@class='layout-sidebar layout-sidebar-dark ']/div[@id='nano-container']/div[@class='nano-content sidebar-scroll-content me-sidebar']/form[@id='menuform']/ul[@id='menuform:menu']/li[@id='menuform:per_menu3_id']/a[1]")
    public WebElement personelModulu;
   


    @Test
    public void testCucumberExample() throws Exception {

        System.out.println("testCucumberExample başladı");
        try {
            kullaniciGirisiYap(driver, Kullanici.KULLANICI1);
        } catch (Exception e) {
            System.out.println("Zaten giriş yapılmış.");
        }
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("Login oldu");

        Fwait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("Main-Div")));
        Fwait.until(ExpectedConditions.visibilityOf(personelModulu));
        personelModulu.click();
        System.out.println("Personel Modulune girildi");

        System.out.println("testCucumberExample Tamamlandı!");
        System.out.println("LogOut oldu");
        Thread.sleep(3000);
    }
}